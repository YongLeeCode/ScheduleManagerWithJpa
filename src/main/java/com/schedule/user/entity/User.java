package com.schedule.user.entity;

import com.schedule.common.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import org.hibernate.validator.constraints.UniqueElements;

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

    @Column(unique = true)
    private String email;

    private String password;

    public User() {}

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public void update(String name) {
        this.name = name;
    }
}
