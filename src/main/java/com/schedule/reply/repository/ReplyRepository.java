package com.schedule.reply.repository;

import com.schedule.reply.entity.Reply;
import com.schedule.schedule.entity.Schedule;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.data.jpa.repository.JpaRepository;
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

}
