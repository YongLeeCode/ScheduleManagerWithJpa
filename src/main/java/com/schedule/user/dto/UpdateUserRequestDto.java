package com.schedule.user.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author : yong
 * @packageName : com.schedule.user.dto
 * @fileName : UpdateUserRequestDto
 * @date : 3/31/25
 * @description :
 */
@RequiredArgsConstructor
@Getter
public class UpdateUserRequestDto {
    @NotBlank
    @Pattern(regexp = "^(?!.* {2})[0-9a-zA-Z가-힣 ]{2,10}$")
    private final String name;
}
