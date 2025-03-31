package com.schedule.schedule.service;

import com.schedule.schedule.dto.ScheduleRequestDto;
import com.schedule.schedule.dto.ScheduleResponseDto;
import com.schedule.schedule.entity.Schedule;
import com.schedule.schedule.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
    public ScheduleResponseDto createSchedule(ScheduleRequestDto dto) {
        Schedule schedule = new Schedule(dto.getUserName(), dto.getTitle(), dto.getContents());
        Schedule savedSchedule = scheduleRepository.save(schedule);

        return new ScheduleResponseDto(
                savedSchedule.getId(),
                savedSchedule.getUserName(),
                savedSchedule.getTitle(),
                savedSchedule.getContents(),
                savedSchedule.getCreatedAt(),
                savedSchedule.getUpdatedAt()
        );
    }
}
