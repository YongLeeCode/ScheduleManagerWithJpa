package com.schedule.user.repository;

import com.schedule.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author : yong
 * @packageName : com.schedule.user.repository
 * @fileName : UserRepository
 * @date : 3/31/25
 * @description :
 */
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
