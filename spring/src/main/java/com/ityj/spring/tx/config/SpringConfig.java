package com.ityj.spring.tx.config;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Map;

@Configuration
@ComponentScan(basePackages = "com.ityj.spring.tx")
@EnableTransactionManagement
public class SpringConfig {

    @Bean
    public DataSource getDataSource() throws Exception {
        Map<String, String> map = Map.of("driverClassName", "com.mysql.cj.jdbc.Driver",
                "url", "jdbc:mysql://192.168.137.110/mydb?serverTimezone=EST",
                "username", "root",
                "password", "root",
                "initialSize", "5");
        return DruidDataSourceFactory.createDataSource(map);
    }

    @Bean
    public JdbcTemplate getJdbcTemplate(DataSource dataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.setDataSource(dataSource);
        return jdbcTemplate;
    }

    @Bean
    public DataSourceTransactionManager getDataSourceTransactionManager(DataSource dataSource) {
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource);
        return dataSourceTransactionManager;
    }


}
