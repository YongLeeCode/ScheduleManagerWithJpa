package com.schedule.schedule.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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
public class UpdateScheduleRequestDto {
    private final long userId;

    @NotBlank
    @Size(max = 10, min = 3)
    private final String title;

    @NotBlank
    @Size(max = 256, min = 10)
    private final String contents;
}
