package com.ityj.spring.tx.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(locations = "classpath:bean-tx.xml")
public class StudentControllerTest {

    @Autowired
    private StudentController studentController;


    @Test
    public void testTx() {
        studentController.addAndUpdate();  // 			List<Object> chain = this.advised.getInterceptorsAndDynamicInterceptionAdvice(method, targetClass);

    }


    // Propagation.REQUIRES_NEW 会新建一个事务， 单词成功就成功
    //
    @Test
    public void testPro() {
        studentController.batchAdd();
    }


}
