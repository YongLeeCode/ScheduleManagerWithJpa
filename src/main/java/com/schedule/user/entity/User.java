package com.schedule.user.entity;

import com.schedule.common.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;

import java.sql.Timestamp;

/**
 * @author : yong
 * @packageName : com.schedule.user.entity
 * @fileName : User
 * @date : 3/31/25
 * @description :
 */
@Entity
@Getter
public class User extends BaseEntity {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String email;

    public User() {}

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
