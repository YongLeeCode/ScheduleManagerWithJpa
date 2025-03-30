package com.schedule.schedule.repository;

import com.schedule.schedule.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author : yong
 * @packageName : com.schedule.schedule.repository
 * @fileName : ScheduleRepository
 * @date : 3/30/25
 * @description :
 */
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

}
