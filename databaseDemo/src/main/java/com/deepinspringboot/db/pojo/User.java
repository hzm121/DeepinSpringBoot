package com.deepinspringboot.db.pojo;

import com.deepinspringboot.db.enums.SexEnum;

public class User {
    private Long id = null;
    private String userName = null;
    private SexEnum sex = null;
    private String note = null;

    @Override
    public String toString() {
        return id+"--"+userName+"---"+sex+"----"+note;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public SexEnum getSex() {
        return sex;
    }

    public void setSex(SexEnum sex) {
        this.sex = sex;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
