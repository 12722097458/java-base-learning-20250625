package com.ityj.ai.controller;

import com.alibaba.cloud.ai.autoconfigure.dashscope.DashScopeConnectionProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@Slf4j
@RestController
public class OllamaController {

    @Autowired
    @Qualifier("ollamaChatModel")
    private ChatModel chatModel;

    @Autowired
    private DashScopeConnectionProperties dashScopeConnectionProperties;

    @GetMapping("/ollamaChat")
    public Flux<String> ollamaChat(@RequestParam(value = "content", defaultValue = "你是谁？") String content) {
        log.info("chatModel is :{}", chatModel);
        log.info("chatStream input content is :{}, model is :{}, dashScopeConnectionProperties.baseUrl is :{}",
                content, chatModel.getDefaultOptions().getModel(), dashScopeConnectionProperties.getBaseUrl());
        return chatModel.stream(content);
    }

}
