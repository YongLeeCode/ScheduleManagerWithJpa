package com.schedule.user.controller;

import com.schedule.user.dto.*;
import com.schedule.user.service.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
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

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequestDto dto, HttpServletResponse response) {
        UserResponseDto result = service.login(dto);
        if(result != null) {
            Cookie cookie = new Cookie("COOKIE", String.valueOf(result.getId()));
            cookie.setMaxAge(60 * 60);
            cookie.setPath("/");
            response.addCookie(cookie);
            return ResponseEntity.status(HttpStatus.OK).body("로그인 성공! 토큰 발급되었습니다.");
        }
        return ResponseEntity.status(HttpStatus.OK).body("로그인 실패~");
    }

    @PostMapping("/signup")
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

    @DeleteMapping("/{id}")
    public ResponseEntity<UserResponseDto> delete(@PathVariable long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.delete(id));
    }
}
