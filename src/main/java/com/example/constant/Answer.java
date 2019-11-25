package com.example.constant;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Answer {

    START("/start"),
    SERVE("Служить своему народу"),
    LOBBY("Лоббировать свои интересы"),
    BUILT_PARTY("Построить политическую партию"),
    REG_PARTY("Зарегистрировать партию"),
    CREATE_PROGRAM("Разработать идеологию (программу)"),
    SUPPORTERS("Собрать сторонников"),
    INCREASE_MEMBERSHIP("Увеличить число членов партии"),
    STATE_DUMA("Пройти в Государственную Думу"),
    FIND_FINANCING("Найти финансирование"),
    KNOW("Познакомиться с твоим создателем"),
    STUDY("Пройти обучение"),
    ORDER("Оставить заявку"),
    MASTER("Посетить мастер класс"),
    PREPARE_WAY("Нужно подготовить почву для входа в политику (снизить мои риски)"),
    BRAND("Создать свой личный персональный бренд и продвигать свои идеи с его помощью"),
    HAVE_IDEA("У меня есть главная идея всей жизни, которая изменит ситуацию в стране"),
    HAVE_MONEY("Я имею средства и сразу готов пойти на выборы"),
    VIEW_OTHERS("Посмотреть остальные пункты"),
    CALL("Заказать звонок специалиста"),
    SEND_IDEA("Отправить свою идею (почта или файлом)"),
    HAVE_MONEY_IDEA("У меня много идей и денег, хочу пойти на выборы"),
    REGION("В каком регионе вы живёте?"),
    GOOD_CONTACT("Хочу получить хороший контакт в одном из ведомств"),
    SERIOUS_POSITION("Хочу получить серьезную должность для себя или моего человека"),
    IMPLEMENT_IDEA("Нужно внедрить нашу идею в одном из регионов для развития бизнеса"),
    GET_CONTRACT("Хочу получить контракт по своей теме"),
    DISMISS_DEPUTY("Хочу уволить чиновника или отозвать депутата"),
    ELECTIONS_PRICE("Узнать среднюю стоимость по выборам"),
    ELECTIONS_COUNTRY("Посмотреть, где еще проходят в стране выборы"),
    SEND_MESSAGE("Отправить сообщение всем"),
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
    }

}
