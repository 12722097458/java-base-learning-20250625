package com.ityj.ai.config;

import com.alibaba.cloud.ai.dashscope.api.DashScopeApi;
import com.alibaba.cloud.ai.dashscope.chat.DashScopeChatModel;
import com.alibaba.cloud.ai.dashscope.chat.DashScopeChatOptions;
import com.alibaba.cloud.ai.memory.redis.RedisChatMemoryRepository;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.MessageWindowChatMemory;
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
                        .build()
                )
                .defaultOptions(DashScopeChatOptions.builder().withModel(QWEN_MODEL).build()).build();
    }

    @Bean("deepseekChatModel")
    public ChatModel getDeepseekChatModel() {
        return DashScopeChatModel.builder()
                .dashScopeApi(DashScopeApi.builder().apiKey(apiKey)
                                .build()
                )
                .defaultOptions(DashScopeChatOptions.builder().withModel(DEEPSEEK_MODEL).build()).build();
    }

    @Bean("qwenChatClient")
    public ChatClient getQwenChatClient(@Autowired @Qualifier(value = "qwenChatModel")ChatModel qwenChatModel,
                                        RedisChatMemoryRepository redisChatMemoryRepository) {

        MessageWindowChatMemory messageWindowChatMemory = MessageWindowChatMemory.builder()
                .maxMessages(10).chatMemoryRepository(redisChatMemoryRepository).build();
        return ChatClient.builder(qwenChatModel)
                .defaultAdvisors(MessageChatMemoryAdvisor.builder(messageWindowChatMemory).build())
                .build();
    }

    @Bean("deepseekChatClient")
    public ChatClient getDeepSeekChatClient(@Autowired @Qualifier(value = "deepseekChatModel") ChatModel deepseekChatModel,
                                            RedisChatMemoryRepository redisChatMemoryRepository) {
        MessageWindowChatMemory messageWindowChatMemory = MessageWindowChatMemory.builder()
                .maxMessages(10) // 保留最近10条聊天记录
                .chatMemoryRepository(redisChatMemoryRepository).build();
        return ChatClient.builder(deepseekChatModel)
                .defaultAdvisors(MessageChatMemoryAdvisor.builder(messageWindowChatMemory).build())
                .build();
    }


}
