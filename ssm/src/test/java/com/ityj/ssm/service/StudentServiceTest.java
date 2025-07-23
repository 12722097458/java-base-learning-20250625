package com.ityj.ssm.service;

import com.ityj.ssm.etity.Student;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentServiceTest {

    @Autowired  // 默认类型查找， 找不到按名字
    private StudentService studentService2Impl;

    @Resource // 默认名字查找， 找不到按类型
    private Student studentServiceImpl;  // BeanNotOfRequiredTypeException: Bean named 'studentServiceImpl' is expected to be of type 'com.ityj.ssm.etity.Student' but was actually of type 'com.ityj.ssm.service.impl.StudentServiceImpl'

    @Test
    public void testAutowired() {
        System.out.println("studentService = " + studentService2Impl);
        System.out.println("studentServiceImpl = " + studentServiceImpl);
    }
}