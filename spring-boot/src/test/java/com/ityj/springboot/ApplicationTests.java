package com.ityj.springboot;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;
import com.ityj.springboot.entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import javax.sql.DataSource;

@Slf4j
@SpringBootTest
class ApplicationTests {


    @Autowired
    private DataSource dataSource;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;


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

    @Test
    void testRedis() {
        ValueOperations<String, String> stringStringValueOperations = stringRedisTemplate.opsForValue();
        stringStringValueOperations.set("testKey", "Jack");


        String res = stringStringValueOperations.get("testKey");

        log.info("complete: " + res);
    }

    @Test
    void testYmlFormat() throws JsonProcessingException {
        Student student = new Student();
        student.setAge(33);
        student.setHeight(182);
        student.setName("Jack2");
        student.setGender("男");

        YAMLFactory yamlFactory = new YAMLFactory().disable(YAMLGenerator.Feature.WRITE_DOC_START_MARKER);

        ObjectMapper objectMapper = new ObjectMapper(yamlFactory);
        String res = objectMapper.writeValueAsString(student);
        log.info("complete: " + res);
    }

}
