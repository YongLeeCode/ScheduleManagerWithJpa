package com.schedule.schedule.service;

import com.schedule.schedule.dto.ScheduleRequestDto;
import com.schedule.schedule.dto.ScheduleResponseDto;
import com.schedule.schedule.entity.Schedule;
import com.schedule.schedule.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author : yong
 * @packageName : com.schedule.schedule.service
 * @fileName : ScheduleService
 * @date : 3/30/25
 * @description :
 */
@Service
@RequiredArgsConstructor
public class ScheduleService {
    private final ScheduleRepository repository;

    // 스케쥴 생성
    public ScheduleResponseDto createSchedule(ScheduleRequestDto dto) {
        Schedule schedule = new Schedule(dto.getUserId(), dto.getTitle(), dto.getContents());
        Schedule savedSchedule = repository.save(schedule);

        return new ScheduleResponseDto(
                savedSchedule.getId(),
                savedSchedule.getTitle(),
                savedSchedule.getContents(),
                savedSchedule.getCreatedAt(),
                savedSchedule.getUpdatedAt(),
                savedSchedule.getUserId()
        );
    }

    // 스케쥴 전체 조회
    public List<ScheduleResponseDto> findAll() {
        List<Schedule> schedules = repository.findAll();
        List<ScheduleResponseDto> responseDtos = new ArrayList<>();
        schedules.forEach(schedule -> responseDtos.add(
                new ScheduleResponseDto(
                        schedule.getId(),
                        schedule.getTitle(),
                        schedule.getContents(),
                        schedule.getCreatedAt(),
                        schedule.getUpdatedAt(),
                        schedule.getUserId()
                )
        ));
        return responseDtos;
    }

    // 스케쥴 id로 조회
    public ScheduleResponseDto findById(long id) {
        Schedule schedule = repository.findById(id).orElseThrow();
        return new ScheduleResponseDto(
                schedule.getId(),
                schedule.getTitle(),
                schedule.getContents(),
                schedule.getCreatedAt(),
                schedule.getUpdatedAt(),
                schedule.getUserId()
        );
    }

    // 스케쥴 업데이트
    public ScheduleResponseDto updateById(long id, ScheduleRequestDto dto) {
        Schedule schedule = repository.findById(id).orElseThrow();
        schedule.update(dto.getTitle(), dto.getContents());

        repository.save(schedule);
        return new ScheduleResponseDto(
                schedule.getId(),
                schedule.getTitle(),
                schedule.getContents(),
                schedule.getCreatedAt(),
                schedule.getUpdatedAt(),
                schedule.getUserId()
        );
    }

    public String deleteById(long id) {
        Schedule schedule = repository.findById(id).orElseThrow();
        repository.deleteById(id);

        return schedule.getTitle();
    }
}
