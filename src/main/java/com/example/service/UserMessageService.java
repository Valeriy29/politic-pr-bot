package com.example.service;

import com.example.constant.Answer;
import com.example.entity.UserEntity;
import com.example.entity.UserMessageEntity;
import com.example.repository.UserMessageRepository;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import org.telegram.telegrambots.meta.api.methods.send.SendDocument;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.Document;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.PhotoSize;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.stream.Collectors;

@Service
public class UserMessageService {

    @Autowired
    private UserMessageRepository userMessageRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    private static final String ORDER_CALL = "Заказ звонка из рубрики ";
    private static final String PHONE = ". Телефон: ";
    private static final String ERROR = "Сообщение не было отправлено";
    private static final String IDEA = "Идея от пользователя ";
    private static final String ID = "ID ";
    private static final String SUCCESS = "Сообщение  отправлено";
    private static final String ADMIN_TELEGRAM_ID = "370678219";
    private static final String BASIC_URL = "https://api.telegram.org/bot%s/sendMessage?chat_id=%s&text=%s";
    private static final String TOKEN = "842868136:AAE3lu7F7gxNBCa_5OyuHmuIzvOYTFlKrRo";

    public ProcessSendingMsg sendAdminsMessage(String text) {
        return new ProcessSendingMsg(text, userRepository, restTemplate);
    }


    public SendDocument sendDocumentToAdmin(Message message, UserEntity userEntity) {
        Document d = message.getDocument();
        SendDocument send = new SendDocument().setChatId(ADMIN_TELEGRAM_ID);
        send.setDocument(d.getFileName());
        send.setDocument(d.getFileId());
        send.setCaption(createMsgToAdmin("", userEntity, this::buildDocString));
        return send;
    }

    public void sendAdminsPhoto(Message message, Consumer<SendPhoto> execute) {
        List<Integer> ids = userRepository.getAllTelegramIds();
        List<PhotoSize> photoSizeList = message.getPhoto();

        ids.forEach(id -> {
            SendPhoto sendPhoto = new SendPhoto();
            sendPhoto.setChatId(String.valueOf(id));
            sendPhoto.setPhoto(photoSizeList.get(0).getFileId());
            execute.accept(sendPhoto);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }


    public String createMsgToAdmin(String text, UserEntity userEntity, BiFunction<String, UserEntity, String> fun) {
        return sendMessageToAdmin(buildUserMessage(text, userEntity, fun));
    }

    public String buildPhoneString(String s, UserEntity userEntity) {
        if (s.matches(Answer.PHONE_REGEX.getAnswer())) {
            userEntity.setPhoneNumber(s);
            userRepository.save(userEntity);
            return ORDER_CALL + userEntity.getSection() + PHONE + s;
        } else {
            return ORDER_CALL + userEntity.getSection() + "\n" + s;
        }
    }

    private String buildUserMessage(String text, UserEntity userEntity, BiFunction<String, UserEntity, String> fun) {
        UserMessageEntity userMsg = new UserMessageEntity();
        String sendText = fun.apply(text, userEntity);
        userMsg.setMessage(sendText);
        userMsg.setUserEntity(userEntity);
        userMsg.setDate(new Date(Calendar.getInstance().getTimeInMillis()));
        userMessageRepository.save(userMsg);
        return sendText;
    }

    private String buildDocString(String s, UserEntity userEntity) {
        return IDEA + userEntity.getUserName() + "\n" + userEntity.getFirstName() + " " + userEntity.getLastName() + "\n" +
                ID + userEntity.getTelegramId() + "\n" + PHONE + userEntity.getPhoneNumber();
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

    public static class ProcessSendingMsg extends Thread {

        private String text;
        private UserRepository userRepository;
        private RestTemplate restTemplate;

        public ProcessSendingMsg(String text, UserRepository userRepository, RestTemplate restTemplate) {
            this.text = text;
            this.userRepository = userRepository;
            this.restTemplate = restTemplate;
        }

        public void run() {
            List<Integer> ids = userRepository.getAllTelegramIds();
            ids.forEach(id -> {
                String url = String.format(BASIC_URL, TOKEN, id, text);
                try {
                    restTemplate.exchange(url, HttpMethod.POST, HttpEntity.EMPTY, String.class).getBody();
                    System.out.println("sent");
                } catch (HttpClientErrorException | ResourceAccessException e) {
                    System.out.println("not send");
                }

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }


}


