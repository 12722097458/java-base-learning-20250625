package com.ityj.ai.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.image.ImageModel;
import org.springframework.ai.image.ImageOptionsBuilder;
import org.springframework.ai.image.ImagePrompt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class Text2ImageController {

    @Autowired
    private ImageModel imageModel;

    // http://localhost:8087/chat/persistent?userId=1001&content=%E5%86%8D%E5%8A%A01
    @GetMapping("/imageModel")
    public String chatStream(@RequestParam(value = "content", defaultValue = "生成一只萨摩耶图片") String content) {
        return imageModel.call(new ImagePrompt(content))
                .getResult().getOutput().getUrl();
    }

}
