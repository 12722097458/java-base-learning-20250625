package com.ityj.ai.controller;

import com.ityj.ai.utils.DateTimeTools;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class ToolCallingController {

    @Autowired
    @Qualifier("qwenChatClient")
    private ChatClient chatClient;

    @RequestMapping("call")
    public Flux<String> callDirectly(@RequestParam(name = "msg", defaultValue = "现在几点了") String msg) {
        return chatClient.prompt().user(msg).stream().content();
    }


    @RequestMapping("callWithTool")
    public Flux<String> callWithTool(@RequestParam(name = "msg", defaultValue = "现在几点了") String msg) {
        return chatClient.prompt()
                .tools(new DateTimeTools())
                .user(msg).stream().content();
    }




}
