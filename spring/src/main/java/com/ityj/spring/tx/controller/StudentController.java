package com.ityj.spring.tx.controller;

import com.ityj.spring.tx.entity.Student;
import com.ityj.spring.tx.service.StudentService;
import com.ityj.spring.tx.service.impl.Service2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private Service2 service2;

    public void addAndUpdate() {
        Student student = new Student();
        student.setName("first");
        student.setAge(23);
        student.setGender("unknown");
        studentService.addAndUpdate(student);
    }

    public void batchAdd() {
        List<Student> list = new ArrayList<>();
        Student student = new Student();
        student.setName("first");
        student.setAge(23);
        student.setGender("unknown");

        Student student2 = new Student();
        student2.setName("second");
        student2.setAge(33);
        student2.setGender("unknown");
        list.add(student);
        list.add(student2);
        service2.batchAdd(list);
    }


}
