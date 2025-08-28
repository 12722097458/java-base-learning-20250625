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


    /*
    * 事务失效场景：
    * 1. public
    * 2. service里的事务方法自调用
    * 3. 抛的异常被catch了。 程序认为没有异常就结束了。
    * 4. 抛的异常不在rollbackfor 里。  默认是RuntimeException和Error,  如果抛出Exception, 就会失效
    * 5. 配置了no roll back for
    * 6. 数据库不支持事务
    * 7. 没有配置事务管理器
    *
    *
    * */
    @Test
    public void testTx_notworking() throws Exception {
        studentController.studentService3();

    }



    // Propagation.REQUIRES_NEW 会新建一个事务， 单词成功就成功
    //
    @Test
    public void testPro() {
        studentController.batchAdd();
    }


}
