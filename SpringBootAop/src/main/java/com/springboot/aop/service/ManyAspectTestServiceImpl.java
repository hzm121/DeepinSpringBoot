package com.springboot.aop.service;

import org.springframework.stereotype.Service;

@Service
public class ManyAspectTestServiceImpl implements ManyAspectTestService{
    @Override
    public void manyAspectTest() {
        System.out.println("多个切面的场景练习");
    }
}
