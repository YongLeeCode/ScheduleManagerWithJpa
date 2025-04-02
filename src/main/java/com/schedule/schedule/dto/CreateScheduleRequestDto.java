package com.schedule.schedule.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author : yong
 * @packageName : com.schedule.schedule.dto
 * @fileName : CreateScheduleRequestDto
 * @date : 4/1/25
 * @description :
 */
@RequiredArgsConstructor
@Getter
public class CreateScheduleRequestDto {
    private final String title;
    private final String contents;
}
