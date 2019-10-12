package com.springboot.aop.service;

import org.springframework.util.StringUtils;

public class ParamValidatorIml implements ParamValidator{
    @Override
    public boolean valididate(String name) {
        System.out.println("引入参数校验");
        return !StringUtils.isEmpty(name);
    }
}
