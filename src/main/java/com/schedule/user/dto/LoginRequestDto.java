package com.schedule.user.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author : yong
 * @packageName : com.schedule.user.dto
 * @fileName : LoginRequestDto
 * @date : 4/1/25
 * @description :
 */
@RequiredArgsConstructor
@Getter
public class LoginRequestDto {
    private final String email;
    private final String password;
}
