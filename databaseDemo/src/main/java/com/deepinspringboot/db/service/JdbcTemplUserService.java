package com.deepinspringboot.db.service;

import com.deepinspringboot.db.pojo.User;

import java.util.List;

public interface JdbcTemplUserService {
    public User getUser(Long id);
    public List<User> findUsers(String username,String note);
    public int insertUser(User user);
    public int updateUser(User user);
    public int deleteUser(Long id);

}
