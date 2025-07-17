package com.ityj.spring.tx.controller;

import com.ityj.spring.annotation.config.MyConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class StudentControllerAnnotationTest {

    @Test
    public void testFullAnnotation() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfiguration.class);
        StudentController studentController  = context.getBean(StudentController.class);
        studentController.batchAdd();
    }

}
