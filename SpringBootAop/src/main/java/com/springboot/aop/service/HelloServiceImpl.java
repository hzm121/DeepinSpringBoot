package com.springboot.aop.service;

import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService{

    @Override
    public void sayHello(String name) {
        if (name == null){
            throw new IllegalArgumentException("name为空");
        }
        System.out.println("Hello"+name);
    }
}
