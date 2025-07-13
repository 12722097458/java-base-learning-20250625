package com.ityj.jdbc;

import com.ityj.jdbc.entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// Mysql数据库PreparedStatement  进行增删改查操作
@Slf4j
public class PrepareStatementTest {

    @Test
    public void testInsert() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.137.110/mydb?serverTimezone=EST", "root", "root");
        System.out.println("connection = " + connection);

        String sql = "insert into student (name, age, gender, birthday, comment) values (?, ?, ?, ?, ?);";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, "Michael");
        ps.setInt(2, 26);
        ps.setString(3, "男");
        ps.setDate(4, new Date(System.currentTimeMillis()));
        FileInputStream is = new FileInputStream(new File("src/main/resources/static/tt微信图片_20241230163708.jpg"));
        ps.setBlob(5, is);
        int count = ps.executeUpdate();
        System.out.println("count = " + count);
        is.close();
        ps.close();
        connection.close();
    }

    @Test
    public void testInsertTransaction() {
        Connection connection = null;
        PreparedStatement ps = null;
        FileInputStream is = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://192.168.137.110/mydb?serverTimezone=EST", "root", "root");
            System.out.println("connection = " + connection);

            System.out.println("当前的autoCommit值：" + connection.getAutoCommit());
            // mysql 默认是TRANSACTION_REPEATABLE_READ。 oracle是TRANSACTION_READ_COMMITTED
            // mysql要求更严格， 效率会低一点
            System.out.println("getTransactionIsolation = " + connection.getTransactionIsolation());
            connection.setAutoCommit(false);   // 1.  用于异常回滚，解决事务问题

            String sql = "insert into student (name, age, gender, birthday, comment) values (?, ?, ?, ?, ?);";
            ps = connection.prepareStatement(sql);
            ps.setString(1, "Michael");
            ps.setInt(2, 26);
            ps.setString(3, "男");
            ps.setDate(4, new Date(System.currentTimeMillis()));
            is = new FileInputStream(new File("src/main/resources/static/tt微信图片_20241230163708.jpg"));
            ps.setBlob(5, is);
            int count = ps.executeUpdate();

            int a = 1 / 0;

            connection.commit(); // 2.1 提交

            System.out.println("count = " + count);
        } catch (Exception e) {
            log.error("Error when handle code: ", e);
            try {
                connection.rollback();  // 2.2 异常回滚
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                ps.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }


    @Test
    public void testDelete() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.137.110/mydb?serverTimezone=EST", "root", "root");

        String sql = "delete from  student where name = ?;";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, "Jack");
        int count = ps.executeUpdate();
        System.out.println("count = " + count);
        ps.close();
        connection.close();
    }

    @Test
    public void testUpdate() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.137.110/mydb?serverTimezone=EST", "root", "root");

        String sql = "update student set age = ? where id = ?;";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, 28);
        ps.setInt(2, 1);
        int count = ps.executeUpdate();
        System.out.println("count = " + count);
        ps.close();
        connection.close();
    }

    @Test
    public void testQuery() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.137.110/mydb?serverTimezone=EST", "root", "root");

        String sql = "select count(*) from student";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet resultSet = ps.executeQuery();
        if (resultSet.next()) {
            System.out.println("resultSet count = " + resultSet.getInt(1));
        }


        String sql2 = "select name, age, gender, birthday, height  from student where id > ?";
        PreparedStatement ps2 = connection.prepareStatement(sql2);
        ps2.setInt(1, 1);
        ResultSet resultSet2 = ps2.executeQuery();
        List<Student> list = new ArrayList<>();
        while (resultSet2.next()) {
            Student student = new Student();
            student.setName(resultSet2.getString("name"));
            student.setAge(resultSet2.getInt("age"));
            student.setGender(resultSet2.getString("gender"));
            student.setBirthday(resultSet2.getDate("birthday"));
            student.setHeight(resultSet2.getDouble("height"));
            list.add(student);
        }
        System.out.println("list = " + list);

        ps.close();
        connection.close();
    }

}
