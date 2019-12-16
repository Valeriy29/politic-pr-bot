package com.example.constant;

import static com.example.constant.Admin.*;
import static com.example.service.KeyboardService.*;

public enum BotMessage {

    WELCOME(emoji(":wave:") + " Приветствую тебя активный гражданин! Что ты хочешь?"),
    GREAT_DESIRE("Отличное желание и стремление! Сейчас таких как ты людей в России очень мало! \nТы настоящий русский человек! Ты элита!\nКак бы ты хотел (а) служить своему народу ему во благо?"),
    HELP_GOAL("Оу, круто! Я поддерживаю людей, стремящихся к развитию и всячески тебе помогу достичь поставленной цели. Что ты хочешь?"),
    RIGHT_SOLUTION("Правильное решение для старта. Я помогу тебе спрятать все хвосты, чтобы не пострадала репутация. Если у тебя свой бизнес, я подскажу, как правильно определить схему для его безопасности. Если ты готов, жми:"),
    ALL_RUSSIAN_POPULARITY("Верно! Для того, чтобы получить определенный авторитет, необходимо иметь имя и соответствующую персону. Наши специалисты в течении года при условии необходимого финансирования создадут тебе всероссийскую популярность на нужном тебе направлении. Если ты давно этого хочешь и у тебя есть деньги, жми:"),
    THINKING_PERSON("Очень приятно осознавать, что ты думающий человек, а не просто потребитель. Спасибо, я ценю мысленный труд и готов твою идею проанализировать, выдав своё заключение. Вместе мы поймём, где и как её можно применить. Если ты готов, жми:"),
    BUSINESS_MAN_TALK("Ну наконец-то серьёзный разговор с деловым человеком, а то одна болтовня.  Отлично, тогда приступим сразу к делу:\n В каком регионе ты живешь?"),
    SERIOUS_QUESTION("Очень серьезный вопрос, требующий от меня подключить к нему специалиста. Закажи звонок"),
    SELECT_POINT("Выбери пункт:"),
    REGION_ELECTIONS_P1("В твоем регионе в"),
    REGION_ELECTIONS_P2("году пройдут следующие выборы:\n"),
    OTHER_REGION_ELECTIONS_2020("К сожалению на следующий год в твоей области выборов нет, но ты можешь принять участие в выборах в другом регионе"),
    DECIDED_GO("Если ты определился куда идём, жми:\n"),
    URL_RCCOMPANY("https://rccompany.ru/uiti-v-politiku/"),
    PAY_PAGE("https://yasobe.ru/na/Politbot"),
    YOUR_GOAL_DESCRIPTION("Опиши кратко суть твоей цели, и необходимый специалист с тобой свяжется.\n"),
    SOON("Через некоторое время мы обязательно с вами свяжемся\n"),
    INPUT_PHONE("Введи номер своего телефона:"),
    SEND_DOCUMENT("Отправь свою идею прикрепив файл или напиши на почту: "),
    DOCUMENT_ACCEPT("Файл отправлен"),
    LOAD("Напишите сообщение или прикрепите фото"),
    DOC_MSG("Необходимые документы на выдвижение:"),
    DOC_MSG_PARLIAMENT("Необходимые документы на выдвижение для выборов депутатов Н-ского областного Совета депутатов ХХ созыва:"),
    DOC_MSG_REG("Необходимые документы на выдвижение при проведении выборов главы региона:"),
    DOC_MSG_BRIEF("Бриф для разработки проекта:"),
    DOC_MSG_COMMERCIAL("Коммерческое предложение с пакетами услуг:"),
    MASTER_CLASS("А вот это дальновидно! Правильно, нужно для начала вникнуть в теорию, а потом реализовать знания на практике. Или ты можешь пройти мастер класс «Как из бизнеса уйти в политику или остаться в нём, влияя на неё»"),
    POLITIC_PARTY("Я вижу ты тоже очень серьезная личность и хочешь расширить своё влияние. Ты не представляешь, как же мне надоели эти старцы в Думе. Я помогу тебе построить политическую партию и сделаю тебя её лидером. Жми внизу то, что подходит для тебя больше всего:"),
    MY_CREATOR("Мой создатель Олег Мальцев. Один из самых нестандартных политиков и политтехнологов в России. Жми на изучение комьюнити:\n\n " +
            "ВКонтакте " + VK.getConstant() + "\n\n" +
            "Инстаграмм " + INSTAGRAM.getConstant() + "\n\n" +
            "Фейсбук " + FACEBOOK.getConstant() + "\n\n" +
            "Ютьюб " + YOU_TUBE.getConstant() + "\n\n" +
            "Сайт " + WEB_SITE.getConstant() + "\n\n"),
    INFO_ABOUT_ELECTIONS_PRICE("Да, бумажные выборы дело дорогое. Я лично за электронное голосование. Вот, например так же думает наш основатель Олег Мальцев\n" +
            "https://www.youtube.com/watch?v=kDd7nxaBt24\n" +
            "Ну ничего, рано или поздно мы построим новую модель развития национального общества вместе. Итак, средняя стоимость выборов на сегодняшний день в рублях:\n\n" +
            emoji(":dollar:") + " " + "Городские (муниципальные) 3-10 млн. в зависимости от территории\n\n" +
            emoji(":dollar:") + " " + "Законодательное собрание области 15 – 25 млн.\n\n" +
            emoji(":dollar:") + " " + "Выборы мэра (главы города, округа) 30 – 200 млн. в зависимости от численности населения\n\n" +
            emoji(":dollar:") + " " + "Губернаторские считается отдельно на каждый регион\n\n" +
            emoji(":dollar:") + " " + "Депутат государственной думы 100 – 200 млн.\n\n" +
            "Готов?\n " +
            "Жми заказать звонок специалиста" + " " + emoji(":phone:")),
    BRIEFING_MESSAGE(emoji(":information_source:") + " " + "Технология партия существует благодаря формуле «разделяй и властвуй», только с миловидным предлогом «плюрализм мнений».⠀\n" +
            "⠀\n" +
            "Многопартийность нашей системы власти связана с требованием элиты сохранить власть путём разделения общественных объединений и движений. ⠀\n" +
            "⠀\n" +
            "Недостаток таких общественных групп в том, что их лидерами выбирают несостоявшихся личностей. Которые в свою очередь могут действовать только с оглядкой на исполнительную власть. ⠀\n" +
            "⠀\n" +
            "Поэтому вы не видите никакой пользы от партийных проектов и общественных групп. Более того, элита с ними играет, как кошка с мышкой. ⠀\n" +
            "⠀\n" +
            "Например, чтобы не собирать подписи для выдвижения своего кандидата от той или иной партии, ей необходимо хотя бы в каком-либо законодательном собрании любого региона РФ набрать на выборах 5%. \n" +
            "Таких партий в России 13! Вы знаете все? А знаете почему вы их не знаете? Да потому что политику нельзя рекламировать. Это закрытый клуб, а значит это выгодно! Так а чё вы сидите? ⠀\n" +
            "⠀\n" +
            "Если так ревностно власть имущие относятся к конкуренции, то у дела нет конкуренции. Начните заниматься делом и вы поймёте, что политика, это образ мышления и ничего более и бояться её не нужно. ⠀\n" +
            "⠀\n" +
            "Успех в партийном строительстве лежит только в опоре на интересы народа без оглядки на Администрацию Президента. Обращайтесь ко мне за своими 5%."),
    BRIEFING_MESSAGE_LOBBY(emoji(":information_source:") + " " + "Поскольку в российском законодательстве так до сих пор и не приняты никакие нормативно-правовые акты, касающиеся деятельности лоббистов, мы в этой сфере действуем на основании ФЗ - №193 от 27 июля 2010 г и ФЗ - №273 от 25 декабря 2008 г. \n" +
            "\n" +
            "Как правило, многие граждане нашей страны из разных сфер жизни, считают, что в каких-то регионах страны жизнь у людей лучше, в каких-то хуже. На самом деле она везде одинакова! Наша жизнь пронизана единой карающей, а не предостерегающей системой управления, с минимальными полномочиями у субъектов и с максимальными у центра.");

    private String botMessage;

    BotMessage(String notMessage) {
        this.botMessage = notMessage;
    }

    public String getBotMessage() {
        return botMessage;
    }

}
