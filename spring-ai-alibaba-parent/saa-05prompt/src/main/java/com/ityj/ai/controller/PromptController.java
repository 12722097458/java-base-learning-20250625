package com.ityj.ai.controller;

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

@Slf4j
@RestController
public class PromptController {

    @Autowired
    private ChatClient qwenChatClient;

    // http://localhost:8085/prompt/system?content=%E8%83%8C%E8%AF%B5%E4%B8%80%E9%A6%96%E5%8F%A4%E8%AF%97  被system限制，只能回答数学问题
    // http://localhost:8085/prompt/system?content=3%E5%8A%A03
    @GetMapping("/prompt/system")
    public Flux<String> systemAndUser(@RequestParam(value = "content", defaultValue = "你是谁？") String content) {
        return qwenChatClient.prompt()
                .system("你是一个数学老师，只能回答数学问题。非数学问题请回答：我只被允许回答数学问题，没办法处理您的请求！")
                .user(content)
                .stream().content();
    }

    @GetMapping("/prompt/assistant")
    public String assistant(@RequestParam(value = "content", defaultValue = "你是谁？") String content) {
        AssistantMessage assistantMessage = qwenChatClient.prompt()
                .user(content)
                .call()
                .chatResponse().getResult().getOutput();
        System.out.println("assistantMessage = " + assistantMessage);  // messageType=ASSISTANT
        return assistantMessage.getText();
    }

    @GetMapping("/prompt/tool")
    public String tool(@RequestParam(value = "city", defaultValue = "南阳") String city) {
        String answer = qwenChatClient.prompt()
                .user(city + "未来3天天气情况如何?")
                .call()
                .chatResponse()
                .getResult()
                .getOutput()
                .getText();

        ToolResponseMessage toolResponseMessage =
                new ToolResponseMessage(
                        List.of(new ToolResponseMessage.ToolResponse("1","获得天气",city)
                        )
                );

        String toolResponse = toolResponseMessage.getText();
        String result = answer + toolResponse;
        return result;
    }



}
