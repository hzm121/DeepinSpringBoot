package com.springboot.aop.aspect;
import com.springboot.aop.service.ParamValidator;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;

@Aspect
@Order(1)
public class MyAspect1 {
    @Pointcut("execution(* com.springboot.aop.service.ManyAspectTestServiceImpl.manyAspectTest(..))")
    public void myPointcut(){

    }
//    @DeclareParents(value = "com.springboot.aop.service.ManyAspectTestServiceImpl",defaultImpl = ParamValidator.class)
//    public ParamValidator paramValidator;

    @Before("myPointcut()")
    public void before(){
        System.out.println("ManyAspects1-----before");
    }
    @After("myPointcut()")
    public void after(){
        System.out.println("ManyAspects1-----after");
    }
    @AfterReturning("myPointcut()")
    public void afterReturning(){
        System.out.println("ManyAspects1-----afterReturning");
    }
    @AfterThrowing("myPointcut()")
    public void afterThrowing(){
        System.out.println("ManyAspects1------afterThrowing");
    }

}
