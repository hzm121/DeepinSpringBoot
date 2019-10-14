package com.springboot.controller;

import com.springboot.jpa.pojo.User;
import com.springboot.jpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class JpaController {
    @Autowired
    private UserRepository userRepository = null;
    @RequestMapping("/index")
    @ResponseBody
    public String index(Long id){
        User one = userRepository.findById(id).get();
        List<User> users = userRepository.findUsers("zm", "");
        String userNameLike = "%"+"hz"+"%";
        List<User> users2 = userRepository.findByUserNameLikeOrNoteLike("%hz%", "");
        return "index";
    }
}

