package com.example;

import com.example.entity.ElectionsEntity;
import com.example.entity.UserEntity;
import com.example.entity.UserMessageEntity;
import com.example.migration.ElectionsMigration;
import com.example.repository.ElectionsRepository;
import com.example.repository.UserMessageRepository;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SaveServiceTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ElectionsRepository electionsRepository;

    @Autowired
    private UserMessageRepository userMessageRepository;

    public void loadElections() {
        ElectionsMigration.loadElections().forEach(e -> electionsRepository.save(e));
    }

}
