package com.springboot.aop.aspect;

import com.springboot.aop.service.ParamValidator;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;

@Aspect
@Order(2)
public class MyAspect2 {
//    @DeclareParents(value = "com.springboot.aop.service.ManyAspectTestServiceImpl",defaultImpl = ParamValidator.class)
//    public ParamValidator paramValidator;
    @Pointcut("execution(* com.springboot.aop.service.ManyAspectTestServiceImpl.manyAspectTest(..))")
    public void myPointcut(){

    }
    @Before("myPointcut()")
    public void before(){
        System.out.println("ManyAspects2-----before");
    }
    @After("myPointcut()")
    public void after(){
        System.out.println("ManyAspects2-----after");
    }
    @AfterReturning("myPointcut()")
    public void afterReturning(){
        System.out.println("ManyAspects2-----afterReturning");
    }
    @AfterThrowing("myPointcut()")
    public void afterThrowing(){
        System.out.println("ManyAspects2------afterThrowing");
    }
}
