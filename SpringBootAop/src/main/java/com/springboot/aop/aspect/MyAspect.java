package com.springboot.aop.aspect;

import com.springboot.aop.service.ParamValidator;
import com.springboot.aop.service.ParamValidatorIml;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Aspect
public class MyAspect {
    @DeclareParents(value = "com.springboot.aop.service.HelloServiceImpl",defaultImpl = ParamValidatorIml.class)
    public ParamValidator paramValidator;

    @Pointcut("execution(* com.springboot.aop.service.HelloServiceImpl.sayHello(..))")
    public void pointCut(){

    }
    @Before("pointCut()")
    public void before(){
        System.out.println("before"+"-------"+ LocalDateTime.now().toString());
    }
    @Around("pointCut()")
    public void arround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("beforeArround");
        joinPoint.proceed();
        System.out.println("afterArround");
    }
    @After("pointCut()")
    public void after(){
        System.out.println("after"+"-------"+ LocalDateTime.now().toString());
    }
    @AfterReturning("pointCut()")
    public void afterReturning(){
        System.out.println("afterReturning"+"-------"+ LocalDateTime.now().toString());
    }
    @AfterThrowing("pointCut()")
    public void afterThrowing(){
        System.out.println("afterThrowing"+"-------"+ LocalDateTime.now().toString());
    }
}
