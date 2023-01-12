package com.template.springboot.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class ParameterAop {

    @Pointcut("execution(* com.template.springboot.controller..*.*(..))")
    private void cut() {

    }

    @Before("cut()")
    public void before(JoinPoint joinPoint) {
        // Joinpoint 는 들어가는 지점에 대한 정보를 갖을 수 있는 객체이다.

        // Method 이름 출력
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        System.out.println(method.getName());

        Object[] args = joinPoint.getArgs();
        for (Object obj : args) {
            System.out.println("type : " + obj.getClass().getSimpleName());
            System.out.println("type : "+ obj);
        }
    }

    // returning 에는 내가 받고 싶은 객체의 이름을 넣어준다. (이는 method 의 parameter 명과 동일해야 한다.)
    @AfterReturning(value = "cut()", returning = "returnObj")
    public void afterReturn(JoinPoint joinPoint, Object returnObj) {
        System.out.println("Return obj");
        System.out.println(returnObj);
    }
}
