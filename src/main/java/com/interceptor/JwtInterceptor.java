package com.interceptor;

import com.entity.UsersEntity;
import com.exception.TokenInvalidExeption;
import com.service.JwtTokenService;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class JwtInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private JwtTokenService jwtTokenService;

    @Autowired
    private UserService userService;

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        String authorization = request.getHeader("Authorization");
        if (authorization != null && authorization.contains("Bearer")) {
            String token = authorization.substring("Bearer ".length());
            try {
                String userId = jwtTokenService.verifyToken(token);
                UsersEntity usersEntity = userService.getUserById(Integer.parseInt(userId));
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(usersEntity.getEmail(), usersEntity.getPassword());
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            } catch (TokenInvalidExeption tokenInvalidExeption) {
                response.sendRedirect("/401");
                return;
            }
        } else {
            response.sendRedirect("/401");
            return;
        }
    }
}
