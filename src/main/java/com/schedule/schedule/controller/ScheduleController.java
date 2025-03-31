package com.schedule.schedule.controller;

import com.schedule.schedule.dto.ScheduleRequestDto;
import com.schedule.schedule.dto.ScheduleResponseDto;
import com.schedule.schedule.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : yong
 * @packageName : com.schedule.schedule.controller
 * @fileName : ScheduleController
 * @date : 3/30/25
 * @description :
 */
@RestController
@RequestMapping("/schedule")
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService service;

    @PostMapping
    public ResponseEntity<ScheduleResponseDto> create(@RequestBody ScheduleRequestDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createSchedule(dto));
    }
}
