package com.example.AOPDemo.aspect;

import com.example.AOPDemo.dto.Student;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    @Before("execution(* com.example.AOPDemo.service.StudentService.createStudent(..))")
    public void logBeforeMethod(){
        System.out.println("Student is going to be saved");
    }

    @AfterReturning( value = "execution(* com.example.AOPDemo.service.StudentService.createStudent(..))", returning = "student")
    public void logAfterReturningMethod(Student student){
        student.setName("Yasir");
        student.setEmail("yasir1@gmail.com");
        System.out.println("Student Modified");
    }

    @AfterThrowing( value = "execution(* com.example.AOPDemo.service.StudentService.createStudent(..))", throwing = "ex")
    public void logAfterThrowingMethod(Throwable ex){
        System.out.println(ex.getClass().getName());
        System.out.println(ex.getMessage());
    }

    @After( value = "execution(* com.example.AOPDemo.service.StudentService.createStudent(..))")
    public void logAfterMethod(){
        System.out.println("After method execution whether exception or not");
    }

    @Around( value = "execution(* com.example.AOPDemo.service.StudentService.createStudent(..))")
    public Object logAroundMethod(ProceedingJoinPoint joinPoint){
        System.out.println("Before Target method");

        try{
            Object result = joinPoint.proceed();
//            student.setName("Yasir");
//            student.setEmail("yasir1@gmail.com");
            return result;
        }catch (Throwable _){

        }finally {
            System.out.println("After Taget method");
        }
        return null;

    }


}
