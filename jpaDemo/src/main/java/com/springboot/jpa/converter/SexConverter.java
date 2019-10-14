package com.springboot.jpa.converter;

import com.springboot.jpa.SexEnum;

import javax.persistence.AttributeConverter;
import javax.persistence.Id;

public class SexConverter implements AttributeConverter<SexEnum, Integer> {


    @Override
    public Integer convertToDatabaseColumn(SexEnum sexEnum) {
        int id = sexEnum.getId();
        return id;
    }

    @Override
    public SexEnum convertToEntityAttribute(Integer integer) {
        SexEnum sex = SexEnum.getEnumById(integer);
        return sex;
    }
}
