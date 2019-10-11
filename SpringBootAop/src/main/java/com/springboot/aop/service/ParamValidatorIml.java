package com.springboot.aop.service;

import org.springframework.util.StringUtils;

public class ParamValidatorIml implements ParamValidator{
    @Override
    public boolean valididator(String name) {
        System.out.println("引入参数校验");
        return name!= null&&!StringUtils.isEmpty(name);
    }
}
