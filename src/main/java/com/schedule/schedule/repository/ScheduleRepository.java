package com.schedule.schedule.repository;

import com.schedule.reply.entity.Reply;
import com.schedule.schedule.entity.Schedule;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author : yong
 * @packageName : com.schedule.schedule.repository
 * @fileName : ScheduleRepository
 * @date : 3/30/25
 * @description :
 */
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

//    @Query(value = "SELECT r FROM Reply r " +
//            "WHERE r.schedule_id = :scheduleId"
//            )
//    List<Reply> findAllReplyWithSchedule(@Param("schedule_id") long scheduleId);

    @Query("SELECT r FROM Reply r WHERE r.schedule.id = :scheduleId")
    List<Reply> findAllReplyWithSchedule(@Param("scheduleId") long scheduleId);

}
