package com.ityj.mybatis.mapper;

import com.ityj.mybatis.entity.Student;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface StudentMapper {

    int insert(Student student);
    List<Student> queryAllStudent();
}
