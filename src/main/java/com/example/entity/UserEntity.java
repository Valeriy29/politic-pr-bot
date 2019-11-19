package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class UserEntity {

    @Id
    @Column (name = "user_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    @Column(name = "telegram_id")
    private Integer telegramId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "answered_region")
    private Boolean answeredRegion;

    @Column(name = "input_phone")
    private Boolean inputPhone;

    @Column(name = "input_description")
    private Boolean inputDescription;

    @Column(name = "section")
    private String section;

    @OneToMany(mappedBy = "userEntity")
    private Set<UserMessageEntity> messages;
}
