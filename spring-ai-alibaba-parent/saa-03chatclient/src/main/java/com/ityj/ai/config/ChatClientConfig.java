package com.ityj.ai.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChatClientConfig {

    @Bean
    public ChatClient getChatClient(ChatModel dashScopeChatModel) {
        return ChatClient.builder(dashScopeChatModel).build();
    }

}
