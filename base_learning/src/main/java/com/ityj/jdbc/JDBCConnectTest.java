package com.ityj.jdbc;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnectTest {

    @Test
    public void testConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.137.110/sys?serverTimezone=EST", "root", "root");
        System.out.println("connection = " + connection);
    }


}
