package com.config;

import com.entity.UsersEntity;
import com.exception.TokenInvalidExeption;
import com.service.JwtTokenService;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by KAI on 1/30/18.
 */
@Component
public class JwtFilter implements Filter {

    @Autowired
    private JwtTokenService jwtTokenService;

    @Autowired
    private UserService userService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String authorization = request.getHeader("Authorization");
        if (authorization != null && authorization.contains("Bearer")) {
            String token = authorization.substring("Bearer ".length());
            try {
                String userId = jwtTokenService.verifyToken(token);
                UsersEntity usersEntity = userService.getUserById(Integer.parseInt(userId));
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(usersEntity.getEmail(), usersEntity.getPassword());
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                filterChain.doFilter(servletRequest, servletResponse);
            } catch (TokenInvalidExeption tokenInvalidExeption) {
                HttpServletResponse response = (HttpServletResponse) servletResponse;
                response.sendRedirect("/401");
                return;
            }
        } else {
            HttpServletResponse response = (HttpServletResponse) servletResponse;
            response.sendRedirect("/401");
            return;
        }
    }



    @Override
    public void destroy() {

    }
}
