package com.example.service;

import com.example.entity.UserEntity;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void registrationUser(Update update) {
        UserEntity userToSave = new UserEntity();
        User telegramUser = update.getMessage().getFrom();

        userToSave.setTelegramId(telegramUser.getId());
        userToSave.setUserName(telegramUser.getUserName());
        userToSave.setFirstName(telegramUser.getFirstName());
        userToSave.setLastName(telegramUser.getLastName());
        userToSave.setAnsweredRegion(false);
        userToSave.setInputPhone(false);
        userRepository.save(userToSave);
    }

    public void saveUser(UserEntity userEntity) {
        userRepository.save(userEntity);
    }

    public UserEntity findUserEntityByTelegramId(Integer telegramId) {
        return userRepository.findUserEntityByTelegramId(telegramId);
    }

    public Boolean userExists(Update update) {
        return userRepository.findUserEntityByTelegramId(update.getMessage().getFrom().getId()) != null;
    }

}
