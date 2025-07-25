package com.ityj.springboot.springboot;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;

@Slf4j
@SpringBootTest
class ApplicationTests {


    @Autowired
    private DataSource dataSource;

    @Test
    void testDataSource() {
        // 默认HikariDataSource (null)
        System.out.println(dataSource);
        // 添加配置  就切换为com.alibaba.druid.pool.DruidDataSource
        // 或添加一个配置bean  DruidDataSource    @Configuration
    }

    @Test
    void testLog() {
        log.debug("debug....");
        log.info("info....");
        log.warn("warn....");
    }

}
