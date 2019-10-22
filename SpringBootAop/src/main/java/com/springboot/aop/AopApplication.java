package com.springboot.aop;

import com.springboot.aop.aspect.MyAspect;
import com.springboot.aop.aspect.MyAspect1;
import com.springboot.aop.aspect.MyAspect2;
import com.springboot.aop.aspect.MyAspect3;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class AopApplication {
@Bean(name = "myAspect")
public MyAspect initMyAspect (){
    return new MyAspect();
}
@Bean("myAspect1")
public MyAspect1 initMyAspect1(){return new MyAspect1();}
@Bean("myAspect2")
public MyAspect2 initMyAspect2(){return new MyAspect2();}
@Bean("myAspect3")
public MyAspect3 initMyAspect3(){return new MyAspect3();}
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(AopApplication.class, args);
//        MyAspect myAspect = (MyAspect)context.getBean("myAspect");
    }

}
