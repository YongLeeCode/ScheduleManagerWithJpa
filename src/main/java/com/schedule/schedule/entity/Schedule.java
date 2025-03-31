package com.schedule.schedule.entity;

import com.schedule.common.BaseEntity;
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

    private long userId;

    public Schedule() {
    }

    public Schedule(long userId, String title, String contents) {
        this.userId = userId;
        this.title = title;
        this.contents = contents;
    }

    public void update(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }
}
