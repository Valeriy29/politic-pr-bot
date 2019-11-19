package com.example.service;

import com.example.constant.Answer;
import com.example.entity.UserEntity;
import com.example.entity.UserMessageEntity;
import com.example.repository.UserMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.sql.Date;
import java.util.Calendar;

@Service
public class UserMessageService {

    @Autowired
    private UserMessageRepository userMessageRepository;

    @Autowired
    private RestTemplate restTemplate;

    private static final String ORDER_CALL = "Заказ звонка из рубрики ";
    private static final String PHONE = ". Телефон: ";
    private static final String ERROR = "Сообщение не было отправлено";
    private static final String SUCCESS = "Сообщение  отправлено";
    private static final String ADMIN_TELEGRAM_ID = "370678219";
    private static final String BASIC_URL = "https://api.telegram.org/bot%s/sendMessage?chat_id=%s&text=%s";
    private static final String TOKEN = "842868136:AAE3lu7F7gxNBCa_5OyuHmuIzvOYTFlKrRo";

    public String createMsgToAdmin(String text, UserEntity userEntity) {
        return sendMessageToAdmin(buildUserMessagePhone(text, userEntity));
    }

    private String buildUserMessagePhone(String text, UserEntity userEntity) {
        UserMessageEntity userMsg = new UserMessageEntity();
        String sendText = buildString(text, userEntity);
        userMsg.setMessage(sendText);
        userMsg.setUserEntity(userEntity);
        userMsg.setDate(new Date(Calendar.getInstance().getTimeInMillis()));
        userMessageRepository.save(userMsg);
        return sendText;
    }

    private String buildString(String s, UserEntity userEntity) {
        if (s.matches(Answer.PHONE_REGEX.getAnswer())) {
            return ORDER_CALL + userEntity.getSection() + PHONE + s;
        } else {
            return ORDER_CALL + userEntity.getSection() + " " + s;
        }
    }

    private String sendMessageToAdmin(String text) {
        String url = String.format(BASIC_URL, TOKEN, ADMIN_TELEGRAM_ID, text);
        try {
            restTemplate.exchange(url, HttpMethod.POST, HttpEntity.EMPTY, String.class).getBody();
            return SUCCESS;
        } catch (HttpClientErrorException | ResourceAccessException e) {
            return ERROR;
        }
    }

}


