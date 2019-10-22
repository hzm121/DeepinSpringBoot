package com;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Repository;
@SpringBootApplication()
@MapperScan(basePackages = "com.dao",
        sqlSessionFactoryRef = "sqlSessionFactory"
        ,sqlSessionTemplateRef = "sqlSessionTemplate",
        annotationClass = Repository.class

)
public class IyBatisDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(IyBatisDemoApplication.class, args);
    }

}

