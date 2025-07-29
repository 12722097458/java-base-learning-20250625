package com.ityj.springboot.mapper;

import com.ityj.springboot.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class StudentMapperTest {

    @Autowired
    private StudentMapper studentMapper;

    @Test
    public void testQuery() {
        List<Student> students = studentMapper.queryByName("Jack");
        System.out.println("students = " + students);
    }

}