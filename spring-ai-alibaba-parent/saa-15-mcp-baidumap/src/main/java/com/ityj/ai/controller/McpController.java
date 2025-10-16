package com.ityj.ai.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class McpController {

    @Autowired
    @Qualifier("qwenChatClient")
    private ChatClient chatClient;

    @Autowired
    @Qualifier("deepseekChatClient")
    private ChatClient deepseekChatClient;

    // http://localhost:8015/mcp?%E5%8D%97%E9%98%B3%E5%A4%A9%E6%B0%94%E6%80%8E%E4%B9%88%E6%A0%B7
    @RequestMapping("mcp")
    public Flux<String> mcp(@RequestParam(name = "msg", defaultValue = "北京天气怎么样") String msg) {
        return chatClient.prompt().user(msg).stream().content();
    }


    @RequestMapping("nomcp")
    public Flux<String> nomcp(@RequestParam(name = "msg", defaultValue = "北京天气怎么样") String msg) {
        return deepseekChatClient.prompt().user(msg).stream().content();
    }




}
