package com.ityj.ai.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@Slf4j
@RestController
public class ChatClientController {

    @Autowired
    private ChatModel chatModel;

    @Autowired
    private ChatClient chatClient;

    @GetMapping("/chatModel")
    public String chatModel(@RequestParam(value = "content", defaultValue = "你是谁？") String content) {
        return chatModel.call(content);
    }

    @GetMapping("/chatClient")   // chatClient用的是链式编程，扩展性更强。不过底层还是要依赖chatModel
    public Flux<String> chatClient(@RequestParam(value = "content", defaultValue = "你是谁？") String content) {
        return chatClient.prompt(content).stream().content();
    }

}
