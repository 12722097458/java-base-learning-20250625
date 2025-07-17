package com.ityj.spring.tx.service.impl;

import com.ityj.spring.tx.dao.StudentDao;
import com.ityj.spring.tx.entity.Student;
import com.ityj.spring.tx.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class Service2 {

    @Autowired
    private StudentService studentService;

    @Transactional
    public int batchAdd(List<Student> list) {
        for (int i = 0; i < list.size(); i++) {
            studentService.addAndUpdate(list.get(i));
        }
        return 100;
    }
}
