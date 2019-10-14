package com.deepinspringboot.db.controller;

import com.deepinspringboot.db.pojo.User;
import com.deepinspringboot.db.service.iml.JdbcTemplUserServiceIml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @Autowired
    public JdbcTemplUserServiceIml userService = null;
    @RequestMapping("/index")
    public String IndexController(){
        User user = userService.getUser(1L);
        System.out.println(user);
        return "index";
    }
}
