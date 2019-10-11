package com.springboot.aop.controller;

import com.springboot.aop.service.HelloService;
import com.springboot.aop.service.HelloServiceImpl;
import com.springboot.aop.service.ParamValidator;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {
    @Autowired
    private HelloService helloService = null;
    @RequestMapping("/index")
    @ResponseBody
    public String sayHello() {
        String name = null;
        ParamValidator paramValidator = (ParamValidator)helloService;
        if(paramValidator.valididator(name)){
            helloService.sayHello(name);
        }
        return "Hello";
    }
}
