package com.schedule.user.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author : yong
 * @packageName : com.schedule.user.dto
 * @fileName : CreateUserRequestDto
 * @date : 3/31/25
 * @description :
 */
@RequiredArgsConstructor
@Getter
public class CreateUserRequestDto {
    private final String name;
    private final String email;
    private final String password;
}
