package com.controller;

import com.pojo.User;
import com.service.UserService;
import com.service.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {
    @Autowired
    UserService userService = null;

    @ResponseBody
    @RequestMapping("/")
    public String indexController(){
        User user = userService.getUserById(1L);
        return "index";
    }
}
