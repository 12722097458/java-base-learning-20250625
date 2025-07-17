package com.ityj.spring.tx.dao;


import com.ityj.spring.tx.entity.Student;

public interface StudentDao {

    int add(Student student);
    int update(Student student);

}
