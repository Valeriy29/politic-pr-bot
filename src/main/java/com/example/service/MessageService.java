package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.function.Consumer;

@Service
public class MessageService {

    @Autowired
    private KeyboardService keyboardService;

    public SendMessage getStartMenu(Message message, String text) {
        return sendMsgKeyboard(message, text, keyboardService::setButtonsStart);
    }

    public SendMessage getOthers(Message message, String text) {
        return sendMsgKeyboard(message, text, keyboardService::setButtonsOthers);
    }

    public SendMessage getSpecial(Message message, String text) {
        return sendMsgKeyboard(message, text, keyboardService::setButtonsBackToSpecial);
    }
    
    public SendMessage getStartMenuAdmin(Message message, String text) {
        return sendMsgKeyboard(message, text, keyboardService::setButtonsStartAdmin);
    }

    public SendMessage getStartServeMenu(Message message, String text) {
        return sendMsgKeyboard(message, text, keyboardService::setButtonsToServeStart);
    }

    public SendMessage getServePreparingPoliticAndBrandMenu(Message message, String text) {
        return sendMsgKeyboard(message, text, keyboardService::setButtonsServePreparingPoliticAndBrand);
    }

    public SendMessage getCallInBuiltMenuMenu(Message message, String text) {
        return sendMsgKeyboard(message, text, keyboardService::setButtonsCallInBuiltMenu);
    }

    public SendMessage getStudyMenu(Message message, String text) {
        return sendMsgKeyboard(message, text, keyboardService::setButtonsStudy);
    }

    public SendMessage getMainIdeaMenu(Message message, String text) {
        return sendMsgKeyboard(message, text, keyboardService::setButtonsMainIdea);
    }

    public SendMessage getRegionMenu(Message message, String text) {
        return sendMsgKeyboard(message, text, keyboardService::setButtonsRegion);
    }

    public SendMessage getLobbyMenu(Message message, String text) {
        return sendMsgKeyboard(message, text, keyboardService::setButtonsLobbyStart);
    }

    public SendMessage getElectionsInfoMenu(Message message, String text) {
        return sendMsgKeyboard(message, text, keyboardService::setButtonsElectionsInfo);
    }

    public SendMessage getPoliticPartyMenu(Message message, String text) {
        return sendMsgKeyboard(message, text, keyboardService::setButtonsBuiltParty);
    }

    public SendMessage sendMsg(Message message, String text) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setText(text);
        return sendMessage;
    }

    public SendMessage sendMsgKeyboard(Message message, String text, Consumer<SendMessage> getKeyBoard) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setText(text);
        getKeyBoard.accept(sendMessage);
        return sendMessage;
    }

}
