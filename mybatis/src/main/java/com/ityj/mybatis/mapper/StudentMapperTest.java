package com.ityj.mybatis.mapper;


import com.ityj.mybatis.entity.Student;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.List;

public class StudentMapperTest {

    @Test
    public void insert() throws Exception {
        Student student = new Student();
        student.setAge(33);
        student.setHeight(182);
        student.setName("Jack2");
        student.setGender("男");
        student.setBirthday(new Date(System.currentTimeMillis()));

        File file = ResourceUtils.getFile("classpath:mybatis-config.xml");
        FileInputStream fileInputStream = new FileInputStream(file);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(fileInputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        int insert = studentMapper.insert(student);
        System.out.println("insert = " + insert);
    }

    @Test
    public void queryAllStudent() throws Exception {
        File file = ResourceUtils.getFile("classpath:mybatis-config.xml");
        FileInputStream fileInputStream = new FileInputStream(file);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(fileInputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = studentMapper.queryAllStudent();
        System.out.println("students = " + students);

        List<Student> students2 = studentMapper.queryAllStudent();
        System.out.println("students2 = " + students2);
    }


}