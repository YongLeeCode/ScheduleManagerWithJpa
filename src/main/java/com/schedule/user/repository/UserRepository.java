package com.schedule.user.repository;

import com.schedule.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author : yong
 * @packageName : com.schedule.user.repository
 * @fileName : UserRepository
 * @date : 3/31/25
 * @description :
 */
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByPassword(String password);
}
