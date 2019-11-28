package com.example.constant;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.example.service.KeyboardService.emoji;

public enum Answer {

    START("/start"),
    SERVE(emoji(":dart:") + " " + "Служить своему народу"),
    LOBBY(emoji(":dart:") + " " + "Лоббировать свои интересы"),
    BUILT_PARTY(emoji(":dart:") + " " + "Построить политическую партию"),
    REG_PARTY(emoji(":globe_with_meridians:") + " " + "Зарегистрировать партию"),
    CREATE_PROGRAM(emoji(":scroll:") + " " + "Разработать идеологию (программу)"),
    SUPPORTERS(emoji(":two_men_holding_hands:") + " " + "Собрать сторонников"),
    INCREASE_MEMBERSHIP(emoji(":chart_with_upwards_trend:") + " " + "Увеличить число членов партии"),
    STATE_DUMA(emoji(":office:") + " " + "Пройти в Государственную Думу"),
    FIND_FINANCING(emoji(":moneybag:") + " " + "Найти финансирование"),
    KNOW(emoji(":dart:") + " " + "Познакомиться с моим создателем"),
    STUDY(emoji(":dart:") + " " + "Пройти обучение"),
    ORDER(emoji(":page_with_curl:") + " " + "Оставить заявку"),
    MASTER(emoji(":muscle:") + "Посетить мастер класс"),
    PREPARE_WAY(emoji(":chart_with_downwards_trend:") + " " + "Нужно подготовить почву для входа в политику (снизить мои риски)"),
    BRAND(emoji(":registered:") + " " + "Создать свой личный персональный бренд и продвигать свои идеи с его помощью"),
    HAVE_IDEA(emoji(":bulb:") + " " + "У меня есть главная идея всей жизни, которая изменит ситуацию в стране"),
    HAVE_MONEY(emoji(":dollar:") + " " + "Я имею средства и сразу готов пойти на выборы"),
    VIEW_OTHERS(emoji(":arrow_left:") + " " + "Посмотреть остальные пункты"),
    CALL(emoji(":phone:") + " " + "Заказать звонок специалиста"),
    SEND_IDEA(emoji(":email:") + " " + "Отправить свою идею (почта или файлом)"),
    HAVE_MONEY_IDEA(emoji(":dollar:") + " " + "У меня много идей и денег, хочу пойти на выборы"),
    REGION("В каком регионе вы живёте?"),
    GOOD_CONTACT(emoji(":calling:") + " " + "Хочу получить хороший контакт в одном из ведомств"),
    SERIOUS_POSITION(emoji(":bust_in_silhouette:") + " " + "Хочу получить серьезную должность для себя или моего человека"),
    IMPLEMENT_IDEA(emoji(":bulb:") + " " + "Нужно внедрить нашу идею в одном из регионов для развития бизнеса"),
    GET_CONTRACT(emoji(":page_facing_up:") + " " + "Хочу получить контракт по своей теме"),
    DISMISS_DEPUTY(emoji(":no_pedestrians:") + " " + "Хочу уволить чиновника или отозвать депутата"),
    ELECTIONS_PRICE(emoji(":dollar:") + " " + "Узнать среднюю стоимость по выборам"),
    ELECTIONS_COUNTRY(emoji(":ru:") + " " + "Посмотреть, где еще проходят в стране выборы"),
    SEND_MESSAGE(emoji(":email:") + " " + "Отправить сообщение всем"),
    BACK_SERVE_MENU(emoji(":arrow_left:") + " " + "Назад в меню \"Служить своему народу\""),
    BACK_BUILT_PARTY__MENU(emoji(":arrow_left:") + " " + "Назад в меню \"Построить политическую партию\""),
    REGION_NAME_REGEX("^[?!,.а-яА-ЯёЁ\\s]+$"),
    PHONE_REGEX("^[-)(_,.+0-9\\s]+$");

    private String answer;

    Answer(String answer) {
        this.answer = answer;
    }

    public static void main(String[] args) {

    }

    public String getAnswer() {
        return answer;
    }

    public static List<String> getAllAnswers() {
        return Arrays.stream(Answer.values()).map(Answer::getAnswer).collect(Collectors.toList());
//                .map(answer -> {
//            String[] answerArr = answer.split(" ");
//            if (answerArr.length > 1) {
//                StringBuilder sb = new StringBuilder();
//                for (int i = 1; i < answerArr.length; i++) {
//                    sb.append(answerArr[i]).append(" ");
//                }
//                return sb.toString().trim();
//            }
//            return answer;
//        }).collect(Collectors.toList());
    }

}
