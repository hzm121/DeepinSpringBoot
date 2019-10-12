package com.springboot.aop.controller;

import com.springboot.aop.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

    @Autowired
    private HelloService2 helloService = null;
    @Autowired
    public ManyAspectTestService manyAspectTestService = null;
    //private HelloService helloService = null;
    @RequestMapping("/index")
    @ResponseBody
    public String sayHello() {
        String name = "hzm";
       ParamValidator paramValidator = (ParamValidator)helloService;
        if(paramValidator.valididate(name)){
            helloService.sayHello(name);
        }
        return "Hello";
    }
    @RequestMapping("/manyAspect")
    @ResponseBody
    public String manyAspectTest(){
//        String name = "";
//        ParamValidator validator = (ParamValidator) this.manyAspectTestService;
//        if (validator.valididate(name)){
            manyAspectTestService.manyAspectTest();
//        }
        return "manyAspect";
    }
}
