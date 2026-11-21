package com.example.interceptorDemo.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class LoggingInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler){

        // request and response are same as filters
        // we can get headers
        // we can get method or URI

        if(handler instanceof HandlerMethod handlerMethod){
            String controllerName = handlerMethod.getBeanType().getName();
            String methodName = handlerMethod.getMethod().getName();

            System.out.println("Controller Name: "+controllerName);
            System.out.println("Method Name: "+methodName);
            System.out.println("preHandle called");
        }
        return true;

    }

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response,
                           Object handler,
                               ModelAndView modelAndView){
        System.out.println("postHandle called");
    }

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response,
                                Object handler,
                                Exception ex){
        System.out.println("afterCompletion called");
    }
}
