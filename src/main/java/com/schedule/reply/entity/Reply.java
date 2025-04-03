package com.schedule.reply.entity;

import com.schedule.common.BaseEntity;
import com.schedule.schedule.entity.Schedule;
import com.schedule.user.entity.User;
import jakarta.persistence.*;
import lombok.Getter;

/**
 * @author : yong
 * @packageName : com.schedule.reply.entity
 * @fileName : Reply
 * @date : 4/2/25
 * @description :
 */
@Entity
@Getter
public class Reply extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String contents;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    //FetchJoin사용
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "schedule_id", nullable = false)
    private Schedule schedule;

    public Reply() {}

    public Reply(String contents, User user, Schedule schedule) {
        this.contents = contents;
        this.user = user;
        this.schedule = schedule;
    }

    public void updateReply(String contents) {
        this.contents = contents;
    }
}
