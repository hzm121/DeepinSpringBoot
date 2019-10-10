package com.springboot.aop.aspect;

import org.aspectj.lang.annotation.*;

import java.time.LocalDate;

@Aspect
public class MyAspect {
    @Pointcut("execution(* com.springboot.aop.service.HelloServiceImpl.sayHello(..))")
    public void pointCut(){

    }
    @Before("pointCut()")
    public void before(){
        System.out.println("before"+"-------"+ LocalDate.now().toString());
    }
    @After("pointCut()")
    public void after(){
        System.out.println("after"+"-------"+ LocalDate.now().toString());
    }
    @AfterReturning("pointCut()")
    public void afterReturning(){
        System.out.println("afterReturning"+"-------"+ LocalDate.now().toString());
    }
    @AfterThrowing("pointCut()")
    public void afterThrowing(){
        System.out.println("afterThrowing"+"-------"+ LocalDate.now().toString());
    }
}
