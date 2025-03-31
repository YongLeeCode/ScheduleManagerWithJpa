package com.schedule.schedule.service;

import com.schedule.schedule.dto.ScheduleRequestDto;
import com.schedule.schedule.dto.ScheduleResponseDto;
import com.schedule.schedule.entity.Schedule;
import com.schedule.schedule.repository.ScheduleRepository;
import com.schedule.user.entity.User;
import com.schedule.user.repository.UserRepository;
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
    private final ScheduleRepository scheduleRepository;
    private final UserRepository userRepository;

    // 스케쥴 생성
    public ScheduleResponseDto createSchedule(ScheduleRequestDto dto) {
        User user = userRepository.findById(dto.getUserId()).orElseThrow();
        Schedule schedule = new Schedule(user, dto.getTitle(), dto.getContents());
        Schedule savedSchedule = scheduleRepository.save(schedule);

        return new ScheduleResponseDto(
                savedSchedule.getId(),
                savedSchedule.getTitle(),
                savedSchedule.getContents(),
                savedSchedule.getCreatedAt(),
                savedSchedule.getUpdatedAt(),
                savedSchedule.getUser().getId()
        );
    }

    // 스케쥴 전체 조회
    public List<ScheduleResponseDto> findAll() {
        List<Schedule> schedules = scheduleRepository.findAll();
        List<ScheduleResponseDto> responseDtos = new ArrayList<>();
        schedules.forEach(schedule -> responseDtos.add(
                new ScheduleResponseDto(
                        schedule.getId(),
                        schedule.getTitle(),
                        schedule.getContents(),
                        schedule.getCreatedAt(),
                        schedule.getUpdatedAt(),
                        schedule.getUser().getId()
                )
        ));
        return responseDtos;
    }

    // 스케쥴 id로 조회
    public ScheduleResponseDto findById(long id) {
        Schedule schedule = scheduleRepository.findById(id).orElseThrow();
        return new ScheduleResponseDto(
                schedule.getId(),
                schedule.getTitle(),
                schedule.getContents(),
                schedule.getCreatedAt(),
                schedule.getUpdatedAt(),
                schedule.getUser().getId()
        );
    }

    // 스케쥴 업데이트
    public ScheduleResponseDto updateById(long id, ScheduleRequestDto dto) {
        Schedule schedule = scheduleRepository.findById(id).orElseThrow();
        schedule.update(dto.getTitle(), dto.getContents());

        scheduleRepository.save(schedule);
        return new ScheduleResponseDto(
                schedule.getId(),
                schedule.getTitle(),
                schedule.getContents(),
                schedule.getCreatedAt(),
                schedule.getUpdatedAt(),
                schedule.getUser().getId()
        );
    }

    public String deleteById(long id) {
        Schedule schedule = scheduleRepository.findById(id).orElseThrow();
        scheduleRepository.deleteById(id);

        return schedule.getTitle();
    }
}
