package com.ityj.mybatis.mapper;


import com.ityj.mybatis.entity.Student;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileInputStream;
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
        //Thread.sleep(1000 * 60);

        List<Student> students2 = studentMapper.queryAllStudent();
        System.out.println("students2 = " + students2);
    }

    @Test
    public void queryByName() throws Exception {
        File file = ResourceUtils.getFile("classpath:mybatis-config.xml");
        FileInputStream fileInputStream = new FileInputStream(file);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(fileInputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = studentMapper.queryByName("Jack", 28);
        System.out.println("students = " + students);
    }

    @Test
    public void queryLikeName() throws Exception {
        File file = ResourceUtils.getFile("classpath:mybatis-config.xml");
        FileInputStream fileInputStream = new FileInputStream(file);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(fileInputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        // 10:16:45.792 [main] [DEBUG] com.ityj.mybatis.mapper.StudentMapper.queryLikeName:143 --- ==>  Preparing: select * from student where name like "%"?"%"
        //10:16:45.849 [main] [DEBUG] com.ityj.mybatis.mapper.StudentMapper.queryLikeName:143 --- ==> Parameters: Jack(String)
        List<Student> students = studentMapper.queryLikeName("Jack");
        System.out.println("students = " + students);
    }

    @Test
    public void queryByIDList() throws Exception {
        File file = ResourceUtils.getFile("classpath:mybatis-config.xml");
        FileInputStream fileInputStream = new FileInputStream(file);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(fileInputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        // 10:16:45.792 [main] [DEBUG] com.ityj.mybatis.mapper.StudentMapper.queryLikeName:143 --- ==>  Preparing: select * from student where name like "%"?"%"
        //10:16:45.849 [main] [DEBUG] com.ityj.mybatis.mapper.StudentMapper.queryLikeName:143 --- ==> Parameters: Jack(String)
        List<Student> students = studentMapper.queryByIDList(List.of(1, 3, 4, 2));
        System.out.println("students = " + students);
    }

    @Test
    public void secondCache() throws Exception {
        File file = ResourceUtils.getFile("classpath:mybatis-config.xml");
        FileInputStream fileInputStream = new FileInputStream(file);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(fileInputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = studentMapper.queryAllStudent();
        System.out.println("students = " + students);
        sqlSession.close();


        SqlSession sqlSession2 = sqlSessionFactory.openSession(true);
        StudentMapper studentMapper2 = sqlSession2.getMapper(StudentMapper.class);
        List<Student> students2 = studentMapper2.queryAllStudent();
        List<Student> students3 = studentMapper2.queryAllStudent();
        System.out.println("students2 = " + students2);
        System.out.println("students3 = " + students3);
    }


}