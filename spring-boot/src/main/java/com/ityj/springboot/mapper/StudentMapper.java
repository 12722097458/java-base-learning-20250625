package com.ityj.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ityj.springboot.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


import java.util.List;

public interface StudentMapper  extends BaseMapper<Student> {

    List<Student> queryByName(@Param("name") String name);
    List<Student> queryByDymaticTableName(@Param("name") String name);

}
