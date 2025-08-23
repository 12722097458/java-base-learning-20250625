package com.ityj.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
public class HelloController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/ping")
    public String ping() {
        return "pong" + serverPort;
    }

    @PostMapping("/testUpload")
    public String testUpload(@RequestParam("fileUpload") MultipartFile fileUpload) throws IOException {
        String originalFilename = fileUpload.getOriginalFilename();
        fileUpload.transferTo(new File(originalFilename));
        return "success";
    }
}
