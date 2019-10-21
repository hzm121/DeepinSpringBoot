//package com.config;
//
//import com.dao.UserDao;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.mapper.MapperFactoryBean;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;

/**
 * 手动配置装配Mybatis接口（开发中一般使用@MapperScan）
 */
//@Configuration
//public class MybatisCoinfig {
//    @Autowired
//    SqlSessionFactory sqlsessionFactory = null;
//    @Bean
//    public MapperFactoryBean<UserDao> initUserDao(){
//        MapperFactoryBean<UserDao> bean = new MapperFactoryBean<>();
//        bean.setMapperInterface(UserDao.class);
//        bean.setSqlSessionFactory(sqlsessionFactory);
//        return bean;
//    }
//}
