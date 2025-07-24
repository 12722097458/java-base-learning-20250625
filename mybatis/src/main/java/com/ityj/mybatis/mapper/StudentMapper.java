package com.ityj.mybatis.mapper;

import com.ityj.mybatis.entity.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface StudentMapper {

    int insert(Student student);
    List<Student> queryAllStudent();
    List<Student> queryByName(@Param("name") String name, @Param("age") int age);
    List<Student> queryLikeName(@Param("name") String name);
    List<Student> queryByIDList(@Param("ids") List<Integer> ids);

    List<Student> queryByProperty(@Param("student") Student student);

}
