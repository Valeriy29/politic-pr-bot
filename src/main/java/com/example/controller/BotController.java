package com.example.controller;

import com.example.constant.Answer;
import com.example.entity.UserEntity;
import com.example.service.ElectionsService;
import com.example.service.MessageService;
import com.example.service.UserMessageService;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.ForwardMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendDocument;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import static com.example.constant.Admin.*;
import static com.example.constant.Answer.*;
import static com.example.constant.BotMessage.*;

@Controller
public class BotController extends TelegramLongPollingBot {

    @Autowired
    private MessageService messageService;

    @Autowired
    private UserService userService;

    @Autowired
    private ElectionsService electionsService;

    @Autowired
    private UserMessageService userMessageService;

    private boolean isAdminSend = false;

    @Override
    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();

        if (!userService.userExists(update)) {
            userService.registrationUser(update);
        }

        UserEntity userEntity = userService.findUserEntityByTelegramId(message.getFrom().getId());


        if (message.hasDocument() && userEntity.getSendDoc()) {
            userEntity.setSendDoc(false);
            userService.saveUser(userEntity);
            executeDocument(userMessageService.sendDocumentToAdmin(message, userEntity));
            executeMessage(messageService.sendMsg(message, DOCUMENT_ACCEPT.getBotMessage()));
        }

        if (isAdminSend) {
            isAdminSend = false;
            if (message.hasPhoto()) {
                System.out.println();
                Runnable thread = new Runnable() {
                    @Override
                    public void run() {
                        userMessageService.sendAdminsPhoto(message, BotController.this::executePhoto);
                    }
                };
                thread.run();
            }

            if (message.hasText()) {
                userMessageService.sendAdminsMessage(message.getText()).start();
            }
        }

        if (message.hasText()) {

            //check admin
            if (!userEntity.getTelegramId().equals(Integer.valueOf(ADMIN_TELEGRAM_ID.getConstant()))) {
                if (message.getText().equals(START.getAnswer())) {
                    executeMessage(messageService.getStartMenu(message, WELCOME.getBotMessage()));
                }
            } else {
                if (message.getText().equals(START.getAnswer())) {
                    executeMessage(messageService.getStartMenuAdmin(message, WELCOME.getBotMessage()));
                }
            }

            if (message.getText().equals(SEND_MESSAGE.getAnswer()) && userEntity.getTelegramId().equals(Integer.valueOf(ADMIN_TELEGRAM_ID.getConstant()))) {
                isAdminSend = true;
                executeMessage(messageService.sendMsg(message, LOAD.getBotMessage()));
            }

            if (message.getText().equals(SERVE.getAnswer())) {
                executeMessage(messageService.getStartServeMenu(message, GREAT_DESIRE.getBotMessage()));
            }

            if (message.getText().equals(LOBBY.getAnswer())) {
                executeMessage(messageService.getLobbyMenu(message, HELP_GOAL.getBotMessage()));
            }

            if (message.getText().equals(BUILT_PARTY.getAnswer())) {
                executeMessage(messageService.getPoliticPartyMenu(message, POLITIC_PARTY.getBotMessage()));
            }

            if (message.getText().equals(KNOW.getAnswer())) {
                executeMessage(messageService.sendMsg(message, MY_CREATOR.getBotMessage()));
            }

            if (message.getText().equals(STUDY.getAnswer())) {
                executeMessage(messageService.getStudyMenu(message, MASTER_CLASS.getBotMessage()));
            }

            if (message.getText().equals(PREPARE_WAY.getAnswer())) {
                userEntity.setSection(PREPARE_WAY.getAnswer());
                userService.saveUser(userEntity);
                executeMessage(messageService.getServePreparingPoliticAndBrandMenu(message, RIGHT_SOLUTION.getBotMessage()));
            }

            if (message.getText().equals(BRAND.getAnswer())) {
                userEntity.setSection(BRAND.getAnswer());
                userService.saveUser(userEntity);
                executeMessage(messageService.getServePreparingPoliticAndBrandMenu(message, ALL_RUSSIAN_POPULARITY.getBotMessage()));
            }

            if (message.getText().equals(SEND_IDEA.getAnswer())) {
                userEntity.setSendDoc(true);
                userService.saveUser(userEntity);
                executeMessage(messageService.sendMsg(message, SEND_DOCUMENT.getBotMessage() + EMAIL.getConstant()));
            }

            if (message.getText().equals(HAVE_IDEA.getAnswer())) {
                executeMessage(messageService.getMainIdeaMenu(message, THINKING_PERSON.getBotMessage()));
            }

            if (message.getText().equals(HAVE_MONEY.getAnswer()) || message.getText().equals(HAVE_MONEY_IDEA.getAnswer())) {
                userEntity.setAnsweredRegion(true);
                userService.saveUser(userEntity);
                executeMessage(messageService.getRegionMenu(message, BUSINESS_MAN_TALK.getBotMessage()));
            }

            if (message.getText().matches(REGION_NAME_REGEX.getAnswer()) && !Answer.getAllAnswers().contains(message.getText()) && userEntity.getAnsweredRegion()) {
                userEntity.setAnsweredRegion(false);
                userEntity.setSection(DECIDED_GO.getBotMessage() + message.getText());
                userService.saveUser(userEntity);
                executeMessage(messageService.getElectionsInfoMenu(message, electionsService.electionsInfoMessage(message.getText())));
            }

            if (message.getText().equals(ELECTIONS_COUNTRY.getAnswer())) {
                executeMessage(messageService.sendMsg(message, URL_RCCOMPANY.getBotMessage()));
            }

            if (message.getText().equals(ELECTIONS_PRICE.getAnswer())) {
                executeMessage(messageService.sendMsg(message, INFO_ABOUT_ELECTIONS_PRICE.getBotMessage()));
            }
//-------------------
            if (message.getText().equals(ORDER.getAnswer())) {
                userEntity.setSection(ORDER.getAnswer() + MASTER.getAnswer());
                userEntity.setInputPhone(true);
                userService.saveUser(userEntity);
                executeMessage(messageService.sendMsg(message, INPUT_PHONE.getBotMessage()));
            }

            if (message.getText().equals(MASTER.getAnswer())) {
                userEntity.setSection(MASTER.getAnswer());
                userService.saveUser(userEntity);
                executeMessage(messageService.sendMsg(message, SOON.getBotMessage()));
                executeForwardMessage(userMessageService.forwardMessageToAdmin(message));
            }
//-------------------
            if (message.getText().equals(REG_PARTY.getAnswer())) {
                userEntity.setSection(REG_PARTY.getAnswer());
                userService.saveUser(userEntity);
                executeMessage(messageService.getCallInBuiltMenuMenu(message, SERIOUS_QUESTION.getBotMessage()));
            }

            if (message.getText().equals(CREATE_PROGRAM.getAnswer())) {
                userEntity.setSection(CREATE_PROGRAM.getAnswer());
                userService.saveUser(userEntity);
                executeMessage(messageService.getCallInBuiltMenuMenu(message, SERIOUS_QUESTION.getBotMessage()));
            }

            if (message.getText().equals(SUPPORTERS.getAnswer())) {
                userEntity.setSection(SUPPORTERS.getAnswer());
                userService.saveUser(userEntity);
                executeMessage(messageService.getCallInBuiltMenuMenu(message, SERIOUS_QUESTION.getBotMessage()));
            }

            if (message.getText().equals(INCREASE_MEMBERSHIP.getAnswer())) {
                userEntity.setSection(INCREASE_MEMBERSHIP.getAnswer());
                userService.saveUser(userEntity);
                executeMessage(messageService.getCallInBuiltMenuMenu(message, SERIOUS_QUESTION.getBotMessage()));
            }

            if (message.getText().equals(STATE_DUMA.getAnswer())) {
                userEntity.setSection(STATE_DUMA.getAnswer());
                userService.saveUser(userEntity);
                executeMessage(messageService.getCallInBuiltMenuMenu(message, SERIOUS_QUESTION.getBotMessage()));
            }

            if (message.getText().equals(FIND_FINANCING.getAnswer())) {
                userEntity.setSection(FIND_FINANCING.getAnswer());
                userService.saveUser(userEntity);
                executeMessage(messageService.getCallInBuiltMenuMenu(message, SERIOUS_QUESTION.getBotMessage()));
            }
//-------------------
            if (message.getText().equals(GOOD_CONTACT.getAnswer())) {
                userEntity.setSection(GOOD_CONTACT.getAnswer());
                userEntity.setInputDescription(true);
                userService.saveUser(userEntity);
                executeMessage(messageService.sendMsg(message, YOUR_GOAL_DESCRIPTION.getBotMessage()));
            }

            if (message.getText().equals(SERIOUS_POSITION.getAnswer())) {
                userEntity.setSection(SERIOUS_POSITION.getAnswer());
                userEntity.setInputDescription(true);
                userService.saveUser(userEntity);
                executeMessage(messageService.sendMsg(message, YOUR_GOAL_DESCRIPTION.getBotMessage()));
            }

            if (message.getText().equals(IMPLEMENT_IDEA.getAnswer())) {
                userEntity.setSection(IMPLEMENT_IDEA.getAnswer());
                userEntity.setInputDescription(true);
                userService.saveUser(userEntity);
                executeMessage(messageService.sendMsg(message, YOUR_GOAL_DESCRIPTION.getBotMessage()));
            }

            if (message.getText().equals(GET_CONTRACT.getAnswer())) {
                userEntity.setSection(GET_CONTRACT.getAnswer());
                userEntity.setInputDescription(true);
                userService.saveUser(userEntity);
                executeMessage(messageService.sendMsg(message, YOUR_GOAL_DESCRIPTION.getBotMessage()));
            }

            if (message.getText().equals(DISMISS_DEPUTY.getAnswer())) {
                userEntity.setSection(DISMISS_DEPUTY.getAnswer());
                userEntity.setInputDescription(true);
                userService.saveUser(userEntity);
                executeMessage(messageService.sendMsg(message, YOUR_GOAL_DESCRIPTION.getBotMessage()));
            }
//---------------------

            if (!userEntity.getTelegramId().equals(Integer.valueOf(ADMIN_TELEGRAM_ID.getConstant()))) {
                if (message.getText().equals(VIEW_OTHERS.getAnswer())) {
                    executeMessage(messageService.getStartMenu(message, SELECT_POINT.getBotMessage()));
                }
            } else {
                if (message.getText().equals(VIEW_OTHERS.getAnswer())) {
                    executeMessage(messageService.getStartMenuAdmin(message, SELECT_POINT.getBotMessage()));
                }
            }

            if(message.getText().equals(BACK_SERVE_MENU.getAnswer())) {
                executeMessage(messageService.getStartServeMenu(message, SELECT_POINT.getBotMessage()));
            }

            if(message.getText().equals(BACK_BUILT_PARTY__MENU.getAnswer())) {
                executeMessage(messageService.getPoliticPartyMenu(message, SELECT_POINT.getBotMessage()));
            }

            if (message.getText().equals(CALL.getAnswer())) {
                userEntity.setInputPhone(true);
                userService.saveUser(userEntity);
                executeMessage(messageService.sendMsg(message, INPUT_PHONE.getBotMessage()));
            }

            if (message.getText().matches(PHONE_REGEX.getAnswer()) && !Answer.getAllAnswers().contains(message.getText()) && userEntity.getInputPhone()) {
                userEntity.setInputPhone(false);
                userService.saveUser(userEntity);
                String result = userMessageService.createMsgToAdmin(message.getText(), userEntity, userMessageService::buildPhoneString);
                executeMessage(messageService.sendMsg(message, result));
                executeForwardMessage(userMessageService.forwardMessageToAdmin(message));
            }

            if (userEntity.getInputDescription() && !Answer.getAllAnswers().contains(message.getText())) {
                userEntity.setInputDescription(false);
                userService.saveUser(userEntity);
                String result = userMessageService.createMsgToAdmin(message.getText(), userEntity, userMessageService::buildMessageString);
                executeMessage(messageService.sendMsg(message, result));
                executeForwardMessage(userMessageService.forwardMessageToAdmin(message));
            }

        }
    }

    private void executeForwardMessage(ForwardMessage forwardMessage) {
        try {
            execute(forwardMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private void executeMessage(SendMessage sendMessage) {
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private void executePhoto(SendPhoto sendPhoto) {
        try {
            execute(sendPhoto);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private void executeDocument(SendDocument sendDocument) {
        try {
            execute(sendDocument);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }


    @Override
    public String getBotUsername() {
        return BOT_NAME.getConstant();
    }

    @Override
    public String getBotToken() {
        return TOKEN.getConstant();
    }

}
