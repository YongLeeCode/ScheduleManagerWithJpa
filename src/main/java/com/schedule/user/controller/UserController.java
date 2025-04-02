package com.schedule.user.controller;

import com.schedule.user.dto.*;
import com.schedule.user.service.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
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
    public ResponseEntity<String> login(@Valid @RequestBody LoginRequestDto dto, HttpServletResponse response) {
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
    public ResponseEntity<CreateUserResponseDto> create(@Valid @RequestBody CreateUserRequestDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createUser(dto));
    }

    @GetMapping
    public ResponseEntity<UserResponseDto> findById(HttpServletRequest req) {
        long userId = Long.parseLong((String) req.getAttribute("userId"));
        return ResponseEntity.status(HttpStatus.OK).body(service.findById(userId));
    }

    @PutMapping
    public ResponseEntity<UserResponseDto> update(HttpServletRequest req, @Valid @RequestBody UpdateUserRequestDto dto) {
        long userId = Long.parseLong((String) req.getAttribute("userId"));
        return ResponseEntity.status(HttpStatus.OK).body(service.update(userId, dto));
    }

    @DeleteMapping
    public ResponseEntity<UserResponseDto> delete(HttpServletRequest req) {
        long userId = Long.parseLong((String) req.getAttribute("userId"));
        return ResponseEntity.status(HttpStatus.OK).body(service.delete(userId));
    }
}
