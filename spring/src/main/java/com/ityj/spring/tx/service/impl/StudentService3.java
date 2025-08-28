package com.ityj.spring.tx.service.impl;

import com.ityj.spring.tx.dao.StudentDao;
import com.ityj.spring.tx.entity.Student;
import com.ityj.spring.tx.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileNotFoundException;

@Service
public class StudentService3  {

    @Autowired
    private StudentDao studentDao;


    // 因为 Spring 事务默认只对 RuntimeException 和 Error 及其子类进行回滚。ArithmeticException 是 RuntimeException 的子类，所以即使你不配置 rollbackFor，它也会触发回滚。
    @Transactional(rollbackFor = FileNotFoundException.class, noRollbackFor = ArithmeticException.class)  // 开一个新车 REQUIRES_NEW
    public int addAndUpdate(Student student) throws Exception {
        studentDao.add(student);

     if ("second22".equals(student.getName())) {
         int a = 1 / 0;
     } else {
         throw new Exception("eee");
     }


        int update = studentDao.update(student);
        return update;
    }

    // @Transactional self-invocation (in effect, a method within the target object calling another method of the target object) does not lead to an actual transaction at runtime
    public int enterAddAndUpdate(Student student) throws Exception {
        return addAndUpdate(student);
    }

}
