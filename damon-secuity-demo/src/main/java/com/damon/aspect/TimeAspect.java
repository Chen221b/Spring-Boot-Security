package com.damon.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Date;

@Aspect
@Component
public class TimeAspect {

    @Around("execution(* com.damon.controller.PersonController.*(..))")
    public Object handlePersonControllerMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = new Date().getTime();
        System.out.println(String.format("%s start", getClass()));
        Object obj = joinPoint.proceed();
        System.out.println(String.format("%s cost %f", getClass(), (float)(new Date().getTime() - start)));
        return obj;
    }
}
