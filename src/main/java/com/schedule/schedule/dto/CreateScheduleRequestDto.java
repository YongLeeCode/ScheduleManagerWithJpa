package com.schedule.schedule.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.Range;

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
    @NotBlank
    @Size(max = 10, min = 3)
    private final String title;

    @NotBlank
    @Size(max = 256, min = 10)
    private final String contents;
}
