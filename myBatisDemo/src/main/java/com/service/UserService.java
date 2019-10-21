package com.service;

import com.pojo.User;
import org.springframework.stereotype.Service;


public interface UserService {
    public User getUserById(Long id);
}
