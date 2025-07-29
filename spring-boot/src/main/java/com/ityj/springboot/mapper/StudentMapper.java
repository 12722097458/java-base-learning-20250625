package com.ityj.springboot.mapper;

import com.ityj.springboot.entity.Student;
import org.apache.ibatis.annotations.Param;


import java.util.List;

public interface StudentMapper {

    List<Student> queryByName(@Param("name") String name);

}
