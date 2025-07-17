package com.ityj.spring.tx.service.impl;

import com.ityj.spring.tx.dao.StudentDao;
import com.ityj.spring.tx.entity.Student;
import com.ityj.spring.tx.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;


    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public int addAndUpdate(Student student) {
        studentDao.add(student);

        if ("second".equals(student.getName())) {
            int a = 1 / 0;
        }

        int update = studentDao.update(student);
        return update;
    }
}
