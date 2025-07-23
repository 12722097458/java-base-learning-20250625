package com.ityj.ssm.etity;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;

@SpringBootTest
class StudentTest {

    @Autowired
    private Student student;

    @Autowired
    private DataSource dataSource;

    @Test
    public void testStudent() {
        System.out.println("student = " + student);
    }

    @Test
    public void testDataSource() {
        System.out.println("dataSource = " + dataSource);
    }
  
}