package com.example.constant;

public enum Admin {

    ADMIN_TELEGRAM_ID("370678219"),
    BASIC_URL("https://api.telegram.org/bot%s/sendMessage?chat_id=%s&text=%s"),
//    TOKEN("842868136:AAE3lu7F7gxNBCa_5OyuHmuIzvOYTFlKrRo"),
//    BOT_NAME("politic_pr_bot")
    TOKEN("920411958:AAEjN4VyKGZYkoKZalvdIfhD0PROnFGtwL0"),
    BOT_NAME("dating_zp_bot"),
    EMAIL("info@rccompany.ru");

    private String constant;

    Admin(String constant) {
        this.constant = constant;
    }

    public String getConstant() {
        return constant;
    }
}
