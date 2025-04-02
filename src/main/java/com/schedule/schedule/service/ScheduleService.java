package com.schedule.schedule.service;

import com.schedule.handler.AccessDeniedException;
import com.schedule.schedule.dto.CreateScheduleRequestDto;
import com.schedule.schedule.dto.UpdateScheduleRequestDto;
import com.schedule.schedule.dto.ScheduleResponseDto;
import com.schedule.schedule.entity.Schedule;
import com.schedule.schedule.repository.ScheduleRepository;
import com.schedule.user.entity.User;
import com.schedule.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
    public ScheduleResponseDto createSchedule(CreateScheduleRequestDto dto, long userId) {
        User user = userRepository.findById(userId).orElseThrow();
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
    public List<ScheduleResponseDto> findAll(long userId) {
        User user = userRepository.findById(userId).orElseThrow();
        List<Schedule> schedules = scheduleRepository.findAll();
        List<ScheduleResponseDto> responseDtos = new ArrayList<>();
        schedules.stream().filter(schedule -> schedule.getUser().getId() == user.getId()).forEach(schedule -> responseDtos.add(
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
    public ScheduleResponseDto findById(long scheduleId, long userId) {
        User user = userRepository.findById(userId).orElseThrow();
        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow();
        if(user.getId() == schedule.getUser().getId()) {
            return new ScheduleResponseDto(
                    schedule.getId(),
                    schedule.getTitle(),
                    schedule.getContents(),
                    schedule.getCreatedAt(),
                    schedule.getUpdatedAt(),
                    schedule.getUser().getId()
            );
        } else {
            throw new AccessDeniedException(user.getName() + "님의 스케쥴이 아닙니다.");
        }
    }

    // 스케쥴 업데이트
    public ScheduleResponseDto updateById(long scheduleId, UpdateScheduleRequestDto dto, long userId) {
        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow();
        schedule.update(dto.getTitle(), dto.getContents());
        User user = userRepository.findById(userId).orElseThrow();
        if(user.getId() == schedule.getUser().getId()) {
            scheduleRepository.save(schedule);
            return new ScheduleResponseDto(
                    schedule.getId(),
                    schedule.getTitle(),
                    schedule.getContents(),
                    schedule.getCreatedAt(),
                    schedule.getUpdatedAt(),
                    schedule.getUser().getId()
            );
        } else {
            throw new AccessDeniedException(user.getName() + "님이 수정할 수 없는 스케쥴입니다.");
        }


    }

    @Transactional
    public String deleteById(long scheduleId, long userId) throws AccessDeniedException {
        User user = userRepository.findById(userId).orElseThrow();
        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow();
        if(user.getId() == schedule.getUser().getId()) {
            scheduleRepository.deleteById(scheduleId);
            return schedule.getTitle();
        } else {
            throw new AccessDeniedException(user.getName() + "님이 삭제하실 수 없는 스케쥴입니다.");
        }
    }
}
