package com.example.AOPDemo.aspect;

import com.example.AOPDemo.annotation.TrackExecutionTime;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SimpleAspect {

//    @Before("execution(String com.example.AOPDemo.service.StudentService.getStudents(String))")
//    public void beforeIntercept(){
//        System.out.println("Method Intercepted");
//    }

    @Around("@annotation(trackExecutionTime)")
    public Object calculateExecutionTime(ProceedingJoinPoint joinPoint, TrackExecutionTime trackExecutionTime) throws Throwable {
        Long start = System.currentTimeMillis();

        try {
            return joinPoint.proceed();
        }finally {
            Long endTime = System.currentTimeMillis();
            Long duration = endTime-start;
            String operation = trackExecutionTime.operation();

            String methodName = joinPoint.getSignature().getName();
            if(methodName.isBlank()){
                methodName = joinPoint.getSignature().getName();
            }

            long threshold = trackExecutionTime.warnAfter();
            if(duration>=threshold){
                System.out.println("Threshold warning --> "+"Time Taken by "+methodName+": "+duration);
            }
            else{
                System.out.println("Time Taken by "+methodName+": "+duration);
            }
        }
    }
}
