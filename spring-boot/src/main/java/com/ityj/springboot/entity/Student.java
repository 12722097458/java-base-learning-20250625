package com.ityj.springboot.entity;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

@JacksonXmlRootElement
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