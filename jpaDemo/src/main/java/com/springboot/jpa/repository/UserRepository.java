package com.springboot.jpa.repository;

import com.springboot.jpa.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {
    @Query("from user where user_name like concat('%',?1,'%') " +
            "and note like concat('%',?2,'%') ")
    public List<User> findUsers(String userName,String note);

    public List<User> findByUserNameLike(String userName);
    public List<User> findByUserNameLikeOrNoteLike(String userName,String note);
}
