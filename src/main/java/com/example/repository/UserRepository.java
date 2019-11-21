package com.example.repository;

import com.example.entity.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {

    UserEntity findUserEntityByTelegramId(Integer telegramId);
    
    @Query("SELECT u.telegramId FROM UserEntity u")
    List<Integer> getAllTelegramIds();
}
