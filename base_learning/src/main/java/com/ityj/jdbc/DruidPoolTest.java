package com.ityj.jdbc;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.jupiter.api.Test;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.Map;

public class DruidPoolTest {

    @Test
    public void testDruid() throws Exception {
        Map<String, String> map = Map.of("driverClassName", "com.mysql.cj.jdbc.Driver",
                "url", "jdbc:mysql://192.168.137.110/sys?serverTimezone=EST",
                "username", "root",
                "password", "root",
                "initialSize", "5");  // com.alibaba.druid.pool.DruidDataSourceFactory.config
        DataSource dataSource = DruidDataSourceFactory.createDataSource(map);

        Connection connection = dataSource.getConnection();
        System.out.println("connection = " + connection);
    }
}
