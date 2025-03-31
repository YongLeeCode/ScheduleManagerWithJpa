package com.schedule.user.controller;

import com.schedule.user.dto.CreateUserRequestDto;
import com.schedule.user.dto.CreateUserResponseDto;
import com.schedule.user.dto.UpdateUserRequestDto;
import com.schedule.user.dto.UserResponseDto;
import com.schedule.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * @author : yong
 * @packageName : com.schedule.user.controller
 * @fileName : UserController
 * @date : 3/31/25
 * @description :
 */
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService service;

    @PostMapping
    public ResponseEntity<CreateUserResponseDto> create(@RequestBody CreateUserRequestDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createUser(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> findById(@PathVariable long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDto> update(@PathVariable long id, @RequestBody UpdateUserRequestDto dto) {
        return ResponseEntity.status(HttpStatus.OK).body(service.update(id, dto));
    }
}
