package com.schedule.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.PatternMatchUtils;

import java.io.IOException;
import java.util.Arrays;

/**
 * @author : yong
 * @packageName : com.schedule.filter
 * @fileName : LoginFilter
 * @date : 3/31/25
 * @description :
 */
@Slf4j
public class LoginFilter implements Filter {
    private final String[] WHITE_LIST = {"/user/login", "/user/signup"};
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String requestURI = request.getRequestURI();
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        Cookie[] cookies = request.getCookies();
        // 1. 로그인
        // 서버에서는 인가를 위한 어떤 값을 내려준다. (어떤값? JWT Token, Token, SessionId, ...)
        // 내려줄떄는 어떤 방식들이 있을까? -> 백엔드에서는 해당 값을 어떻게 Statefull 하게 제공을 할까?
        // Stateful => 서버 메모리에 저장, 데이터베이스에 저장.

        // Batch Job

        // 로컬 세션, 쿠키, 응답 바디(Response Body)
        // 클라이언트(브라우저, 앱)는 어떻게 그 값을 가져다가 제어를 할까?
        // 세션 or 쿠키 -> 백엔드에서

        //Cookie cookie = new Cookie("COOKIE", "1234");
        //        cookie.setMaxAge(60 * 60);

        // HttpSession session = request.getSession();
        // session.set(..)

        // 브라우저에 해당 쿠키나 세션에 해당 값이 들어가진다.

        // 클라이언트가 또 다른 로긍니 아닌 다른 요청 보냄. (세션 or 쿠키)
        // 세션이나 쿠키에 담긴 값을 전달을한다.


        // 토큰

        // 쿠키를 사용
        if (!isWhiteList(requestURI)) {
            Cookie cookie = getCookie(cookies);
            if (cookie == null) {
                throw new RuntimeException("로그인 해야합니다.");
            }
            log.info("로그인 상태입니다~");

            request.setAttribute("userId", cookie.getValue());
            response.addCookie(cookie);
        }

        filterChain.doFilter(servletRequest, response);
    }

    private boolean isWhiteList(String uri) {
        return PatternMatchUtils.simpleMatch(WHITE_LIST, uri);
    }

    private Cookie getCookie(Cookie[] cookies) {
        for (Cookie myCookie : cookies) {
            if (myCookie.getName().equals("COOKIE")) {
                return myCookie;
            }
        }
        return null;
    }
}
