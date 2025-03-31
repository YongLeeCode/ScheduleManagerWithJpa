package com.schedule.user.repository;

import com.schedule.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author : yong
 * @packageName : com.schedule.user.repository
 * @fileName : UserRepository
 * @date : 3/31/25
 * @description :
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
