package com.ityj.ai.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.messages.Message;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.chat.prompt.SystemPromptTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.Map;

@Slf4j
@RestController
public class PromptTemplateController {

    @Autowired
    private ChatClient qwenChatClient;

    // http://localhost:8085/promptTemplate?topic=%E6%80%AA%E5%85%BD&count=200
    @GetMapping("/promptTemplate")
    public Flux<String> promptTemplate(@RequestParam(value = "topic") String topic, @RequestParam(value = "count") int count) {
        PromptTemplate promptTemplate = new PromptTemplate("请给我讲一个关于{topic}的故事，字数控制在{count}内!");
        Prompt prompt = promptTemplate.create(Map.of("topic", topic, "count", count));
        return qwenChatClient.prompt(prompt)
                .stream().content();
    }

    // http://localhost:8085/systemPromptTemplate?subject=%E5%BE%8B%E5%B8%88&content=3%E5%8A%A03
    // http://localhost:8085/systemPromptTemplate?subject=%E5%BE%8B%E5%B8%88&content=%E6%B3%95%E5%BE%8B%E5%AD%A6%E4%B9%A0%E8%B7%AF%E7%BA%BF
    @GetMapping("/systemPromptTemplate")
    public Flux<String> systemPromptTemplate(@RequestParam(value = "subject") String subject,
                                             @RequestParam(value = "content") String content) {
        SystemPromptTemplate systemPromptTemplate = new SystemPromptTemplate("你是一个{subject}方面的专家，拒绝回答{subject}之外的问题！");
        Message systemMessage = systemPromptTemplate.createMessage(Map.of("subject", subject));
        UserMessage userMessage = new UserMessage(content);
        Prompt prompt = new Prompt(systemMessage, userMessage);
        return qwenChatClient.prompt(prompt)
                .user(content)
                .stream().content();
    }

}
