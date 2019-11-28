package com.example.service;

import com.google.common.collect.Lists;
import com.vdurmont.emoji.EmojiParser;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.example.constant.Answer.*;

@Service
public class KeyboardService {

    private final static ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();

    public static String emoji(String emoji) {
        return EmojiParser.parseToUnicode(emoji);
    }

    public ReplyKeyboardMarkup setButtonsStart(SendMessage sendMessage) {
        KeyboardRow keyboardFirstRow = new KeyboardRow();
        keyboardFirstRow.add(new KeyboardButton(SERVE.getAnswer()));
        KeyboardRow keyboardSecondRow = new KeyboardRow();
        keyboardSecondRow.add(new KeyboardButton(LOBBY.getAnswer()));
        KeyboardRow keyboardThirdRow = new KeyboardRow();
        keyboardThirdRow.add(new KeyboardButton(BUILT_PARTY.getAnswer()));
        KeyboardRow keyboardFourthRow = new KeyboardRow();
        keyboardFourthRow.add(new KeyboardButton(KNOW.getAnswer()));
        KeyboardRow keyboardFifthRow = new KeyboardRow();
        keyboardFifthRow.add(new KeyboardButton(STUDY.getAnswer()));
        List<KeyboardRow> keyboardRowList = new ArrayList<>(Lists.newArrayList(keyboardFirstRow, keyboardSecondRow, keyboardThirdRow,
                keyboardFourthRow, keyboardFifthRow));
        return initReplyKeyboard(keyboardRowList, sendMessage);
    }

    public ReplyKeyboardMarkup setButtonsBuiltParty(SendMessage sendMessage) {
        KeyboardRow keyboardFirstRow = new KeyboardRow();
        keyboardFirstRow.add(new KeyboardButton(REG_PARTY.getAnswer()));
        KeyboardRow keyboardSecondRow = new KeyboardRow();
        keyboardSecondRow.add(new KeyboardButton(CREATE_PROGRAM.getAnswer()));
        KeyboardRow keyboardThirdRow = new KeyboardRow();
        keyboardThirdRow.add(new KeyboardButton(SUPPORTERS.getAnswer()));
        KeyboardRow keyboardFourthRow = new KeyboardRow();
        keyboardFourthRow.add(new KeyboardButton(INCREASE_MEMBERSHIP.getAnswer()));
        KeyboardRow keyboardFifthRow = new KeyboardRow();
        keyboardFifthRow.add(new KeyboardButton(STATE_DUMA.getAnswer()));
        KeyboardRow keyboardSixthRow = new KeyboardRow();
        keyboardSixthRow.add(new KeyboardButton(FIND_FINANCING.getAnswer()));
        KeyboardRow keyboardSeventhRow = new KeyboardRow();
        keyboardSeventhRow.add(new KeyboardButton(VIEW_OTHERS.getAnswer()));
        List<KeyboardRow> keyboardRowList = new ArrayList<>(Lists.newArrayList(keyboardFirstRow, keyboardSecondRow, keyboardThirdRow, keyboardFourthRow, keyboardFifthRow,
                keyboardSixthRow, keyboardSeventhRow));
        return initReplyKeyboard(keyboardRowList, sendMessage);
    }

    public ReplyKeyboardMarkup setButtonsStartAdmin(SendMessage sendMessage) {
        KeyboardRow keyboardFirstRow = new KeyboardRow();
        keyboardFirstRow.add(new KeyboardButton(SERVE.getAnswer()));
        KeyboardRow keyboardSecondRow = new KeyboardRow();
        keyboardSecondRow.add(new KeyboardButton(LOBBY.getAnswer()));
        KeyboardRow keyboardThirdRow = new KeyboardRow();
        keyboardThirdRow.add(new KeyboardButton(BUILT_PARTY.getAnswer()));
        KeyboardRow keyboardFourthRow = new KeyboardRow();
        keyboardFourthRow.add(new KeyboardButton(KNOW.getAnswer()));
        KeyboardRow keyboardFifthRow = new KeyboardRow();
        keyboardFifthRow.add(new KeyboardButton(STUDY.getAnswer()));
        KeyboardRow keyboardSixthRow = new KeyboardRow();
        keyboardSixthRow.add(new KeyboardButton(SEND_MESSAGE.getAnswer()));
        List<KeyboardRow> keyboardRowList = new ArrayList<>(Lists.newArrayList(keyboardFirstRow, keyboardSecondRow, keyboardThirdRow,
                keyboardFourthRow, keyboardFifthRow, keyboardSixthRow));
        return initReplyKeyboard(keyboardRowList, sendMessage);
    }

    public ReplyKeyboardMarkup setButtonsToServeStart(SendMessage sendMessage) {
        KeyboardRow keyboardFirstRow = new KeyboardRow();
        keyboardFirstRow.add(new KeyboardButton(PREPARE_WAY.getAnswer()));
        KeyboardRow keyboardSecondRow = new KeyboardRow();
        keyboardSecondRow.add(new KeyboardButton(BRAND.getAnswer()));
        KeyboardRow keyboardThirdRow = new KeyboardRow();
        keyboardThirdRow.add(new KeyboardButton(HAVE_IDEA.getAnswer()));
        KeyboardRow keyboardFourthRow = new KeyboardRow();
        keyboardFourthRow.add(new KeyboardButton(HAVE_MONEY.getAnswer()));
        KeyboardRow keyboardFifthRow = new KeyboardRow();
        keyboardFifthRow.add(new KeyboardButton(VIEW_OTHERS.getAnswer()));
        List<KeyboardRow> keyboardRowList = new ArrayList<>(Lists.newArrayList(keyboardFirstRow, keyboardSecondRow, keyboardThirdRow, keyboardFourthRow, keyboardFifthRow));
        return initReplyKeyboard(keyboardRowList, sendMessage);
    }

    public ReplyKeyboardMarkup setButtonsServePreparingPoliticAndBrand(SendMessage sendMessage) {
        KeyboardRow keyboardFirstRow = new KeyboardRow();
        keyboardFirstRow.add(new KeyboardButton(CALL.getAnswer()));
        KeyboardRow keyboardSecondRow = new KeyboardRow();
        keyboardSecondRow.add(new KeyboardButton(BACK_SERVE_MENU.getAnswer()));
        List<KeyboardRow> keyboardRowList = new ArrayList<>(Lists.newArrayList(keyboardFirstRow, keyboardSecondRow));
        return initReplyKeyboard(keyboardRowList, sendMessage);
    }

    public ReplyKeyboardMarkup setButtonsCallInBuiltMenu(SendMessage sendMessage) {
        KeyboardRow keyboardFirstRow = new KeyboardRow();
        keyboardFirstRow.add(new KeyboardButton(CALL.getAnswer()));
        KeyboardRow keyboardSecondRow = new KeyboardRow();
        keyboardSecondRow.add(new KeyboardButton(BACK_BUILT_PARTY__MENU.getAnswer()));
        List<KeyboardRow> keyboardRowList = new ArrayList<>(Lists.newArrayList(keyboardFirstRow, keyboardSecondRow));
        return initReplyKeyboard(keyboardRowList, sendMessage);
    }

    public ReplyKeyboardMarkup setButtonsMainIdea(SendMessage sendMessage) {
        KeyboardRow keyboardFirstRow = new KeyboardRow();
        keyboardFirstRow.add(new KeyboardButton(SEND_IDEA.getAnswer()));
        KeyboardRow keyboardSecondRow = new KeyboardRow();
        keyboardSecondRow.add(new KeyboardButton(HAVE_MONEY_IDEA.getAnswer()));
        KeyboardRow keyboardThirdRow = new KeyboardRow();
        keyboardThirdRow.add(new KeyboardButton(BACK_SERVE_MENU.getAnswer()));
        List<KeyboardRow> keyboardRowList = new ArrayList<>(Lists.newArrayList(keyboardFirstRow, keyboardSecondRow, keyboardThirdRow));
        return initReplyKeyboard(keyboardRowList, sendMessage);
    }

    public ReplyKeyboardMarkup setButtonsStudy(SendMessage sendMessage) {
        KeyboardRow keyboardFirstRow = new KeyboardRow();
        keyboardFirstRow.add(new KeyboardButton(ORDER.getAnswer()));
        KeyboardRow keyboardSecondRow = new KeyboardRow();
        keyboardSecondRow.add(new KeyboardButton(MASTER.getAnswer()));
        KeyboardRow keyboardThirdRow = new KeyboardRow();
        keyboardThirdRow.add(new KeyboardButton(VIEW_OTHERS.getAnswer()));
        List<KeyboardRow> keyboardRowList = new ArrayList<>(Lists.newArrayList(keyboardFirstRow, keyboardSecondRow, keyboardThirdRow));
        return initReplyKeyboard(keyboardRowList, sendMessage);
    }

    public ReplyKeyboardMarkup setButtonsRegion(SendMessage sendMessage) {
        KeyboardRow keyboardSecondRow = new KeyboardRow();
        keyboardSecondRow.add(new KeyboardButton(BACK_SERVE_MENU.getAnswer()));
        List<KeyboardRow> keyboardRowList = Collections.singletonList(keyboardSecondRow);
        return initReplyKeyboard(keyboardRowList, sendMessage);
    }

    public ReplyKeyboardMarkup setButtonsLobbyStart(SendMessage sendMessage) {
        KeyboardRow keyboardFirstRow = new KeyboardRow();
        keyboardFirstRow.add(new KeyboardButton(GOOD_CONTACT.getAnswer()));
        KeyboardRow keyboardSecondRow = new KeyboardRow();
        keyboardSecondRow.add(new KeyboardButton(SERIOUS_POSITION.getAnswer()));
        KeyboardRow keyboardThirdRow = new KeyboardRow();
        keyboardThirdRow.add(new KeyboardButton(IMPLEMENT_IDEA.getAnswer()));
        KeyboardRow keyboardFourthRow = new KeyboardRow();
        keyboardFourthRow.add(new KeyboardButton(GET_CONTRACT.getAnswer()));
        KeyboardRow keyboardFifthRow = new KeyboardRow();
        keyboardFifthRow.add(new KeyboardButton(DISMISS_DEPUTY.getAnswer()));
        KeyboardRow keyboardSixthRow = new KeyboardRow();
        keyboardSixthRow.add(new KeyboardButton(VIEW_OTHERS.getAnswer()));
        List<KeyboardRow> keyboardRowList = new ArrayList<>(Lists.newArrayList(keyboardFirstRow, keyboardSecondRow, keyboardThirdRow, keyboardFourthRow, keyboardFifthRow,
                keyboardSixthRow));
        return initReplyKeyboard(keyboardRowList, sendMessage);
    }

    public ReplyKeyboardMarkup setButtonsElectionsInfo(SendMessage sendMessage) {
        KeyboardRow keyboardFirstRow = new KeyboardRow();
        keyboardFirstRow.add(new KeyboardButton(ELECTIONS_PRICE.getAnswer()));
        KeyboardRow keyboardSecondRow = new KeyboardRow();
        keyboardSecondRow.add(new KeyboardButton(CALL.getAnswer()));
        KeyboardRow keyboardThirdRow = new KeyboardRow();
        keyboardThirdRow.add(new KeyboardButton(ELECTIONS_COUNTRY.getAnswer()));
        KeyboardRow keyboardFourthRow = new KeyboardRow();
        keyboardFourthRow.add(new KeyboardButton(VIEW_OTHERS.getAnswer()));
        List<KeyboardRow> keyboardRowList = new ArrayList<>(Lists.newArrayList(keyboardFirstRow, keyboardSecondRow, keyboardThirdRow, keyboardFourthRow));
        return initReplyKeyboard(keyboardRowList, sendMessage);
    }


    private ReplyKeyboardMarkup initReplyKeyboard(List<KeyboardRow> keyboardRowList, SendMessage sendMessage) {
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);
        replyKeyboardMarkup.setKeyboard(keyboardRowList);
        return replyKeyboardMarkup;
    }

}
