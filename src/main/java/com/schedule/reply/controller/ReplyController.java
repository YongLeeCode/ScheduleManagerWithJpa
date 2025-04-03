package com.schedule.reply.controller;

import com.schedule.reply.dto.CreateReplyRequestDto;
import com.schedule.reply.dto.FindReplyResponseDto;
import com.schedule.reply.dto.ReplyResponseDto;
import com.schedule.reply.service.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : yong
 * @packageName : com.schedule.reply.controller
 * @fileName : ReplyController
 * @date : 4/2/25
 * @description :
 */
@RestController
@RequestMapping("/reply")
@RequiredArgsConstructor
public class ReplyController {
    private final ReplyService service;

    @PostMapping("/{userId}/{scheduleId}")
    public ResponseEntity<ReplyResponseDto> addReply(@RequestBody CreateReplyRequestDto dto, @PathVariable long userId, @PathVariable long scheduleId) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.addReply(dto, scheduleId, userId));
    }

    @GetMapping("/{scheduleId}")
    public ResponseEntity<List<FindReplyResponseDto>> findAllBySchedule(@PathVariable long scheduleId) {
        return ResponseEntity.status(HttpStatus.OK).body(service.findAllBySchedule(scheduleId));
    }
}
