package com.example.constant;

public enum Admin {

    LOAD("Напишите сообщение или прикрепите фото");

    private String message;

    Admin(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

    


