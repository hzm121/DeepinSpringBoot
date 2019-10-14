package com.springboot.jpa.pojo;

import com.springboot.jpa.SexEnum;
import com.springboot.jpa.converter.SexConverter;

import javax.persistence.*;

//表明是一个实体类
@Entity(name = "user")
//定义映射的表
@Table(name = "t_user")
public class User {
    //标明主键
    @Id
    //主键策略，递增
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id = null;
    //定义属性和表的映射关系
    @Column(name = "user_name")
    private String userName = null;
    private String note = null;
    @Convert(converter = SexConverter.class)
    private SexEnum sex = null;
}
