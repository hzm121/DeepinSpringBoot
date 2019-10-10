package com.springboot.aop.controller;

import com.springboot.aop.service.HelloService;
import com.springboot.aop.service.HelloServiceImpl;
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
        helloService.sayHello("hzm");
        return "Hello";
    }
}
