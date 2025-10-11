package com.ityj.ai.config;

import com.alibaba.cloud.ai.dashscope.api.DashScopeApi;
import com.alibaba.cloud.ai.dashscope.chat.DashScopeChatModel;
import com.alibaba.cloud.ai.dashscope.chat.DashScopeChatOptions;
import jakarta.annotation.Resource;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MultiModelConfig {

    public static final String QWEN_MODEL = "qwen3-max";
    public static final String DEEPSEEK_MODEL = "deepseek-v3.2-exp";

    @Value("${spring.ai.dashscope.api-key}")
    private String apiKey;
    @Value("${spring.ai.dashscope.base-url}")
    private String baseUrl;

    @Bean("qwenChatModel")
    public ChatModel getQwenChatModel() {
        return DashScopeChatModel.builder()
                .dashScopeApi(DashScopeApi.builder().apiKey(apiKey)
//                        .baseUrl(baseUrl)  TODO 配置了https://dashscope.aliyuncs.com/compatible-mode/v1会报错 org.springframework.ai.retry.NonTransientAiException: 404 -
                        .build()
                )
                .defaultOptions(DashScopeChatOptions.builder().withModel(QWEN_MODEL).build()).build();
    }

    @Bean("deepseekChatModel")
    public ChatModel getDeepseekChatModel() {
        return DashScopeChatModel.builder()
                .dashScopeApi(DashScopeApi.builder().apiKey(apiKey)
//                        .baseUrl(baseUrl)  TODO 配置了https://dashscope.aliyuncs.com/compatible-mode/v1会报错 org.springframework.ai.retry.NonTransientAiException: 404 -
                                .build()
                )
                .defaultOptions(DashScopeChatOptions.builder().withModel(DEEPSEEK_MODEL).build()).build();
    }

    @Bean("qwenChatClient")
    public ChatClient getQwenChatClient(@Autowired @Qualifier(value = "qwenChatModel")ChatModel qwenChatModel) {
        return ChatClient.builder(qwenChatModel).build();
    }

    @Bean("deepseekChatClient")
    public ChatClient getDeepSeekChatClient(@Autowired @Qualifier(value = "deepseekChatModel") ChatModel deepseekChatModel) {
        return ChatClient.builder(deepseekChatModel).build();
    }

}
