package com.ityj.ai.controller;

import com.ityj.ai.entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.messages.AssistantMessage;
import org.springframework.ai.chat.messages.ToolResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

@Slf4j
@RestController
public class StructuredOutputController {

    @Autowired
    private ChatClient qwenChatClient;

    // http://localhost:8086/output?age=12&name=Jack
    @GetMapping("/output")
    public Student systemAndUser(@RequestParam(value = "age") int age,
                                      @RequestParam(value = "name") String name) {
        return qwenChatClient.prompt()
                .user(new Consumer<ChatClient.PromptUserSpec>() {
                    @Override
                    public void accept(ChatClient.PromptUserSpec promptUserSpec) {
                        promptUserSpec.text("我的学号是10002,今年{age}岁了，名字是{name}").params(Map.of("age", age, "name", name));
                    }
                }).call().entity(Student.class);
    }

}
