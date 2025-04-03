package com.schedule.reply.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author : yong
 * @packageName : com.schedule.reply.dto
 * @fileName : CreateReplyRequestDto
 * @date : 4/2/25
 * @description :
 */
@RequiredArgsConstructor
@Getter
public class CreateReplyRequestDto {
    private final String contents;
}
