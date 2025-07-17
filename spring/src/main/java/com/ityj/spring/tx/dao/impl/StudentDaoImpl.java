package com.ityj.spring.tx.dao.impl;

import com.ityj.spring.tx.dao.StudentDao;
import com.ityj.spring.tx.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public class StudentDaoImpl implements StudentDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int add(Student student) {
        String sql = "insert into student (name, age, gender) values (?, ?, ?);";
        int insert = jdbcTemplate.update(sql, student.getName(), student.getAge(), student.getGender());
        return insert;
    }

    @Override
    public int update(Student student) {
        String sql = "update  student set name = ? where name = ?;";
        int update = jdbcTemplate.update(sql, new Date(), student.getName());
        return 0;
    }
}
