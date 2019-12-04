package com.example.constant;

public enum Admin {

    ADMIN_TELEGRAM_ID("726914119"),
//    ADMIN_TELEGRAM_ID("370678219"),
    BASIC_URL("https://api.telegram.org/bot%s/sendMessage?chat_id=%s&text=%s"),
//    TOKEN("920411958:AAEjN4VyKGZYkoKZalvdIfhD0PROnFGtwL0"),
//    BOT_NAME("dating_zp_bot"),
    TOKEN("1030382648:AAGGAnO9R0qiHWnz4mhuql6dPxO_z4N6Y1Q"),
    BOT_NAME("polit_pr_bot"),
    EMAIL("info@rccompany.ru"),
    INSTAGRAM("https://www.instagram.com/politics\\_lobby"),
    FACEBOOK("https://www.facebook.com/maltsevolegbest"),
    VK("https://vk.com/id568684543"),
    YOU_TUBE("https://www.youtube.com/channel/UCCTRt3tWZL\\_7LSXwghXmfaQ?view\\_as=subscriber"),
    WEB_SITE("https://rccompany.ru");

    private String constant;

    Admin(String constant) {
        this.constant = constant;
    }

    public String getConstant() {
        return constant;
    }
}
