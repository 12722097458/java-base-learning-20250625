package com.ityj.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
public class HelloController {

    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }

    @PostMapping("/testUpload")
    public String testUpload(@RequestParam("fileUpload") MultipartFile fileUpload) throws IOException {
        String originalFilename = fileUpload.getOriginalFilename();
        fileUpload.transferTo(new File(originalFilename));
        return "success";
    }
}
