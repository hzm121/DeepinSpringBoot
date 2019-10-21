package com.service;

import com.dao.UserDao;
import com.pojo.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService, ApplicationContextAware {
    @Autowired
    UserDao userDao = null;

    private  ApplicationContext context = null;
    @Override
    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
        UserDao bean = context.getBean(UserDao.class);

    }
}
