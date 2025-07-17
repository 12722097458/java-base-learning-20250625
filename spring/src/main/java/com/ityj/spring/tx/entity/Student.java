package com.ityj.spring.tx.entity;

import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

@Slf4j
@Data
@ToString
public class Student {
    private String name;
    private int age;
    private String gender;
    private Date birthday;
    private double height;
}
