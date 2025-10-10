package com.ityj.ai.config;

import com.alibaba.cloud.ai.dashscope.api.DashScopeApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

//@Configuration
// 无需配置类，项目启动后会自动配置，自动加载modelName，apiKey和baseUrl
// 其中modelName和baseUrl都有默认值
public class SaaConfig {

    @Value("${spring.ai.dashscope.chat.options.model}")
    private String modelName;
    @Value("${spring.ai.dashscope.api-key}")
    private String apiKey;
    @Value("${spring.ai.dashscope.base-url}")
    private String baseUrl;


    @Bean
    public DashScopeApi getDashScopeApi() {
        return DashScopeApi.builder()
                .apiKey(apiKey)
//                .baseUrl(baseUrl)  //默认baseUrl=DEFAULT_BASE_URL com.alibaba.cloud.ai.autoconfigure.dashscope.DashScopeConnectionProperties.DashScopeConnectionProperties
                .build();
    }

}
