package com.ityj.springboot.mapper;

import com.ityj.springboot.config.MonthTableNameHandler;
import com.ityj.springboot.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class StudentMapperTest {

    @Autowired
    private StudentMapper studentMapper;

    @Test
    public void testQuery() {
        List<Student> students = studentMapper.queryByName("Jack");
        System.out.println("students = " + students);
    }

    @Test
    public void testDynamicQuery() {

        try {
            // Table 'mydb.t_stu_202509' doesn't exist
            String targetYearMonth = "202509"; // 从userLog中提取或计算
            MonthTableNameHandler.setData(targetYearMonth);
            List<Student> students = studentMapper.queryByDymaticTableName("Jack");
            System.out.println("students = " + students);
        } finally {
            MonthTableNameHandler.removeData();
        }

    }


}
