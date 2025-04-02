package com.schedule.user.service;

import com.schedule.handler.DuplicateEmailException;
import com.schedule.handler.InvalidPasswordException;
import com.schedule.user.dto.*;
import com.schedule.user.entity.User;
import com.schedule.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author : yong
 * @packageName : com.schedule.user.service
 * @fileName : UserService
 * @date : 3/31/25
 * @description :
 */
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;

    public UserResponseDto login(LoginRequestDto dto) {
        User user = repository.findByEmail(dto.getEmail()).orElseThrow();

        if (user.getPassword().equals(dto.getPassword())) {
            return new UserResponseDto(user.getId(), user.getName(), user.getEmail(), user.getCreatedAt(), user.getUpdatedAt());
        } else {
            throw new InvalidPasswordException("비밀번호가 일치하지 않습니다. 다시 확인해주세요.");
        }
    }

    @Transactional
    public CreateUserResponseDto createUser(CreateUserRequestDto dto) {

        if (!repository.existsByEmail(dto.getEmail())) {
            User user = repository.save(new User(dto.getName(), dto.getEmail(), dto.getPassword()));
            return new CreateUserResponseDto(
                    user.getId(),
                    user.getName(),
                    user.getEmail(),
                    user.getCreatedAt(),
                    user.getUpdatedAt()
            );
        } else {
            throw new DuplicateEmailException("이미 존재하는 이메일입니다.");
        }

    }

    public UserResponseDto findById(long id) {
        User user = repository.findById(id).orElseThrow();
        return new UserResponseDto(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getCreatedAt(),
                user.getUpdatedAt()
        );
    }

    public UserResponseDto update(long id, UpdateUserRequestDto dto) {
        User user = repository.findById(id).orElseThrow();
        user.update(dto.getName());

        repository.save(user);
        return new UserResponseDto(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getCreatedAt(),
                user.getUpdatedAt()
        );
    }

    public UserResponseDto delete(long id) {
        User user = repository.findById(id).orElseThrow();
        repository.delete(user);
        return new UserResponseDto(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getCreatedAt(),
                user.getUpdatedAt()
        );
    }
}
