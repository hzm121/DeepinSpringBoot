package com.springboot.aop.service;

import org.springframework.stereotype.Service;

@Service
public class HelloService2 {

    public void sayHello(String name) {
        if (name == null){
            throw new IllegalArgumentException("name为空");
        }
        System.out.println("HelloService2"+name);
    }
}
