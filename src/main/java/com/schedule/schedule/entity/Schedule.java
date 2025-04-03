package com.schedule.schedule.entity;

import com.schedule.common.BaseEntity;
import com.schedule.reply.entity.Reply;
import com.schedule.user.entity.User;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

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

    private String title;

    private String contents;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "reply_id")
    private List<Reply> replies;

    public Schedule() {
    }

    public Schedule(User user, String title, String contents) {
        this.user = user;
        this.title = title;
        this.contents = contents;
    }

    public void update(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }
}
