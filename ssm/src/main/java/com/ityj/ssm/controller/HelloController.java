package com.ityj.ssm.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
public class HelloController {

    @GetMapping("/ping")
    public String ping() {
        System.out.println("HelloController.ping()......");
        return "pong";
    }

    @PostMapping("/testUpload")
    public String testUpload(@RequestPart("fileUpload") MultipartFile fileUpload) throws IOException {
        String originalFilename = fileUpload.getOriginalFilename();
        System.out.println("originalFilename = " + originalFilename);
        fileUpload.transferTo(new File("D:\\workspace-latest\\file-upload\\" + originalFilename));
        return "success";
    }
}
