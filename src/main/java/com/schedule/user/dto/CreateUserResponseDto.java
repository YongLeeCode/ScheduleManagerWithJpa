package com.schedule.user.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.sql.Timestamp;

/**
 * @author : yong
 * @packageName : com.schedule.user.dto
 * @fileName : CreateUserResponseDto
 * @date : 3/31/25
 * @description :
 */
@RequiredArgsConstructor
@Getter
public class CreateUserResponseDto {
    private final long id;
    private final String name;
    private final String email;
    private final Timestamp createdAt;
    private final Timestamp updatedAt;
}
