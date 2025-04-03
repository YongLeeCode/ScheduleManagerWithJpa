package com.schedule.reply.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.sql.Timestamp;

/**
 * @author : yong
 * @packageName : com.schedule.reply.dto
 * @fileName : FindReplyResponseDto
 * @date : 4/3/25
 * @description :
 */
@RequiredArgsConstructor
@Getter
public class FindReplyResponseDto {
    private final long replyId;
    private final String reply;
    private final Timestamp createdAt;
    private final Timestamp updatedAt;
    private final String userName;
}
