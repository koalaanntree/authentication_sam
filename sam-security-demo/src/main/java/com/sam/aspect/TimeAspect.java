package com.sam.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @Author: huangxin
 * @Date: Created in 下午4:22 2018/2/26
 * @Description:
 */
@Aspect
@Component
public class TimeAspect {

    @Around("execution(* com.sam.controller.UserController.*(..))")
    public Object handleControllerMethod(ProceedingJoinPoint pjp) throws Throwable {

        System.out.println("time aspect start");

        Object[] args = pjp.getArgs();

        for (Object arg : args) {
            System.out.println("arg is "+arg);
        }

        long start = System.currentTimeMillis();

        Object proceed = pjp.proceed();

        System.out.println("time aspect 耗时："+(System.currentTimeMillis()-start));

        System.out.println("time aspect end");

        return proceed;
    }
}
