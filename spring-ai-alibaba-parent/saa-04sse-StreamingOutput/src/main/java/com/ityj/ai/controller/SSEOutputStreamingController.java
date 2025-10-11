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
public class SSEOutputStreamingController {

    @Autowired
    private ChatModel qwenChatModel;
    @Autowired
    private ChatModel deepseekChatModel;

    @Autowired
    private ChatClient qwenChatClient;
    @Autowired
    private ChatClient deepseekChatClient;


    @GetMapping("/chatModel/qwen")
    public Flux<String> qwenChatModel(@RequestParam(value = "content", defaultValue = "你是谁？") String content) {
        return qwenChatModel.stream(content);
    }
    @GetMapping("/chatModel/deepseek")
    public Flux<String> deepseekChatModel(@RequestParam(value = "content", defaultValue = "你是谁？") String content) {
        return deepseekChatModel.stream(content);
    }

    @GetMapping("/chatClient/qwen")
    public Flux<String> qwenChatClient(@RequestParam(value = "content", defaultValue = "你是谁？") String content) {
        return qwenChatClient.prompt(content).stream().content();
    }
    @GetMapping("/chatClient/deepseek")
    public Flux<String> deepseekChatClient(@RequestParam(value = "content", defaultValue = "你是谁？") String content) {
        return deepseekChatClient.prompt(content).stream().content();
    }

}
