package com.schedule.user.service;

import com.schedule.user.dto.*;
import com.schedule.user.entity.User;
import com.schedule.user.repository.UserRepository;
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
        if(user.getPassword().equals(dto.getPassword())) {
            return new UserResponseDto(user.getId(), user.getName(), user.getEmail(), user.getCreatedAt(), user.getUpdatedAt());
        }
        return null;
    }

    public CreateUserResponseDto createUser(CreateUserRequestDto dto) {
        User user = repository.save(new User(dto.getName(), dto.getEmail(), dto.getPassword()));
        return new CreateUserResponseDto(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getCreatedAt(),
                user.getUpdatedAt()
        );
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
