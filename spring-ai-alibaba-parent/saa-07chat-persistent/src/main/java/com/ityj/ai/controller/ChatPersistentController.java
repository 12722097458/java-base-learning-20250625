package com.ityj.ai.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.function.Consumer;

import static org.springframework.ai.chat.memory.ChatMemory.CONVERSATION_ID;

@Slf4j
@RestController
public class ChatPersistentController {

    @Autowired
    private ChatClient qwenChatClient;

    // http://localhost:8087/chat/persistent?userId=1001&content=%E5%86%8D%E5%8A%A01
    @GetMapping("/chat/persistent")
    public Flux<String> chatStream(@RequestParam(value = "content", defaultValue = "你是谁？") String content,
                                   @RequestParam(value = "userId") String userId) {
        return qwenChatClient.prompt()
                .user(content)
                .advisors(new Consumer<ChatClient.AdvisorSpec>() {
                    @Override
                    public void accept(ChatClient.AdvisorSpec advisorSpec) {
                        advisorSpec.param(CONVERSATION_ID, userId);   // redis结构是list,  key是 spring_ai_alibaba_chat_memory:1001
                    }
                })
                .stream().content();
    }



}
