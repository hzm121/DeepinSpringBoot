package com.hzm.shop;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.stereotype.Repository;
@SpringBootApplication()

@MapperScan(basePackages = "com"
        , sqlSessionTemplateRef = "sqlSessionTemplate"
        , sqlSessionFactoryRef = "sqlSessionFactory"
        , annotationClass = Repository.class
)


public class ShopApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(ShopApplication.class, args);
    }
@Override
protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
    return application.sources(ShopApplication.class);
}
}
