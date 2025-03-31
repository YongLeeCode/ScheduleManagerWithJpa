package com.schedule.user.dto;

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
    private final String name;
}
