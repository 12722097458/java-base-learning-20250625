package com.ityj.springboot.config;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Map;

//@Configuration
public class MyConfig {

    @Bean
    public DataSource getDataSource() throws Exception {
        Map<String, String> map = Map.of("driverClassName", "com.mysql.cj.jdbc.Driver",
                "url", "jdbc:mysql://192.168.137.110/sys?serverTimezone=EST",
                "username", "root",
                "password", "root",
                "initialSize", "5");  // com.alibaba.druid.pool.DruidDataSourceFactory.config
        DataSource dataSource = DruidDataSourceFactory.createDataSource(map);
        return dataSource;
    }

}
