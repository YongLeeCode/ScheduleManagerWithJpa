package com.schedule.schedule.controller;

import com.schedule.schedule.dto.CreateScheduleRequestDto;
import com.schedule.schedule.dto.UpdateScheduleRequestDto;
import com.schedule.schedule.dto.ScheduleResponseDto;
import com.schedule.schedule.service.ScheduleService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : yong
 * @packageName : com.schedule.schedule.controller
 * @fileName : ScheduleController
 * @date : 3/30/25
 * @description :
 */
@RestController
@RequestMapping("/schedules")
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService service;

    @PostMapping
    public ResponseEntity<ScheduleResponseDto> create(@Valid @RequestBody CreateScheduleRequestDto dto, HttpServletRequest req) {
        long userId = Long.parseLong((String) req.getAttribute("userId"));
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createSchedule(dto, userId));
    }

    @GetMapping
    public ResponseEntity<List<ScheduleResponseDto>> findAll(HttpServletRequest req) {
        long userId = Long.parseLong((String) req.getAttribute("userId"));
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll(userId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> findById(@PathVariable long id, HttpServletRequest req) {
        long userId = Long.parseLong((String) req.getAttribute("userId"));
        return ResponseEntity.status(HttpStatus.OK).body(service.findById(id, userId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> update(@PathVariable long id, @Valid @RequestBody UpdateScheduleRequestDto dto, HttpServletRequest req) {
        long userId = Long.parseLong((String) req.getAttribute("userId"));
        return ResponseEntity.status(HttpStatus.OK).body(service.updateById(id, dto, userId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable long id, HttpServletRequest req) {
        long userId = Long.parseLong((String) req.getAttribute("userId"));
        String response = service.deleteById(id, userId) + " 스케쥴은 정상적으로 삭제되었습니다.";
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
