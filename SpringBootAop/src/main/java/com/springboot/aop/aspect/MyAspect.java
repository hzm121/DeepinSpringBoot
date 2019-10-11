package com.springboot.aop.aspect;

import com.springboot.aop.service.ParamValidator;
import com.springboot.aop.service.ParamValidatorIml;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Aspect
public class MyAspect {
    @DeclareParents(value = "com.springboot.aop.service.HelloService2",defaultImpl = ParamValidatorIml.class)
    public ParamValidator paramValidator;

    @Pointcut("execution(* com.springboot.aop.service.HelloServiceImpl.sayHello(..))")
    public void pointCut(){

    }
    @Before("pointCut() && args(name)")
    public void before(JoinPoint joinPoint,String name){
        System.out.println("获取的参数是:"+joinPoint.getArgs()[0].toString());
        System.out.println("传入的名字是"+name);
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
