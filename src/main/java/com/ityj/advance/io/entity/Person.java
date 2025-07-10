package com.ityj.advance.io.entity;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@ToString
@Data
// 1. 必须实现implements Serializable， 否则写出时报错NotSerializableException
// 2. 必须指定唯一序列号serialVersionUID， 否则修改Person.java文件后，再次读取数据是会报错   java.io.InvalidClassException:
// 3. 当前类的所有属性必须都是可序列化的
public class Person implements Serializable {

    private  static final long serialVersionUID = 42324234232L;

    private transient String name;
    private static int age;
    private int sss;

    // private Account account;// Account必须也是Serializable
}
