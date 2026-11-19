package com.example.filterDemo.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Component
@Order(1)
public class AuthenticationFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        long startTime = System.currentTimeMillis();

        String token = httpServletRequest.getHeader("token");
        String apiKey = httpServletRequest.getHeader("x-api-key");

        if(token == null || !token.equals("12345")){
            httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        if(apiKey == null || !apiKey.equals("secret123")){
            httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            httpServletResponse.setContentType("application/json");
            httpServletResponse.getWriter().write(
                    "{\"message\": \"API key is missing or invalid\"}"
            );
            return;
        }

        try{
            filterChain.doFilter(servletRequest,servletResponse);
        }finally {
            long duration = System.currentTimeMillis()-startTime;
            System.out.println("Duration: "+duration);
        }
    }
}
