package com.schedule.reply.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.sql.Time;
import java.sql.Timestamp;

/**
 * @author : yong
 * @packageName : com.schedule.reply.dto
 * @fileName : ReplyResponseDto
 * @date : 4/2/25
 * @description :
 */
@RequiredArgsConstructor
@Getter
public class ReplyResponseDto {
    private final long replyId;
    private final String reply;
    private final Timestamp createdAt;
    private final Timestamp updatedAt;
    private final long userId;
    private final long scheduleId;
}
