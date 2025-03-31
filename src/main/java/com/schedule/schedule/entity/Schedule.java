package com.schedule.schedule.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;

/**
 * @author : yong
 * @packageName : com.schedule.schedule.entity
 * @fileName : Schedule
 * @date : 3/30/25
 * @description :
 */
@Entity
@Getter
public class Schedule extends BaseEntity {
    @Id
    @GeneratedValue
    private Long id;

    private String userName;

    private String title;

    private String contents;

    public Schedule() {
    }

    public Schedule(String userName, String title, String contents) {
        this.userName = userName;
        this.title = title;
        this.contents = contents;
    }

    public void update(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }
}
