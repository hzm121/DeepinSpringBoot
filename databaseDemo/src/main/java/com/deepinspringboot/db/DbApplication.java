package com.deepinspringboot.db;

import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.sql.DataSource;

@SpringBootApplication
public class DbApplication implements ApplicationContextAware {

    public static void main(String[] args) {
        SpringApplication.run(DbApplication.class, args);
    }

    /**
     * 该方法会在初始化的时候被调用，并获取spring IOC容器的上下文
     * @param applicationContext
     * @throws BeansException
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        DataSource bean = applicationContext.getBean(DataSource.class);
        System.out.println(bean);
        System.out.println("-------------------");
        System.out.println("ClassName："+bean.getClass().getName());
    }
}
