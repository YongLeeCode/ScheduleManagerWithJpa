package com.schedule.schedule.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.sql.Timestamp;

/**
 * @author : yong
 * @packageName : com.schedule.schedule.dto
 * @fileName : ScheduleResponseDto
 * @date : 3/31/25
 * @description :
 */
@RequiredArgsConstructor
@Getter
public class ScheduleResponseDto {
    private final long id;
    private final String userName;
    private final String title;
    private final String contents;
    private final Timestamp createdAt;
    private final Timestamp updatedAt;
}
