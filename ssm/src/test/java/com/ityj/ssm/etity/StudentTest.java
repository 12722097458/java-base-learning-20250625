package com.ityj.ssm.etity;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
class StudentTest {

    @Autowired
    private Student student;

    @Test
    public void testStudent() {
        System.out.println("student = " + student);
    }
  
}