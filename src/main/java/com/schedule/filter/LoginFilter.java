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
    }
}
