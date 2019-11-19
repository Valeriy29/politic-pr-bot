package com.example.repository;

import com.example.entity.UserMessageEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMessageRepository extends CrudRepository<UserMessageEntity, Long> {

}
