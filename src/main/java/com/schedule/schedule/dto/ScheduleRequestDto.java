package com.schedule.schedule.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author : yong
 * @packageName : com.schedule.schedule.dto
 * @fileName : ScheduleRequestDto
 * @date : 3/30/25
 * @description :
 */
@RequiredArgsConstructor
@Getter
public class ScheduleRequestDto {
    private final String userName;
    private final String title;
    private final String contents;
}
