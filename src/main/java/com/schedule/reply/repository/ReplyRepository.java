package com.schedule.reply.repository;

import com.schedule.reply.entity.Reply;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author : yong
 * @packageName : com.schedule.reply.repository
 * @fileName : ReplyRepository
 * @date : 4/2/25
 * @description :
 */
@Repository
public interface ReplyRepository extends JpaRepository<Reply, Long> {

    @Query("SELECT r FROM Reply r WHERE r.schedule.id = :scheduleId")
    Page<Reply> findAllReplyWithSchedule(@Param("scheduleId") long scheduleId, Pageable pageable);

}
