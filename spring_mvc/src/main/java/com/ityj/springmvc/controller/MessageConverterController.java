package com.ityj.springmvc.controller;

import com.ityj.springmvc.entity.User;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Instant;
import java.util.List;

@Controller
public class MessageConverterController {

    @PostMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String requestBody) {
        System.out.println("requestBody = " + requestBody);  // requestBody = id=123&newName=ssdf
        return "success";
    }

    @GetMapping("/testRequestEntity")
    public String testRequestBody(RequestEntity<String> requestEntity) {
        System.out.println("requestEntity = " + requestEntity);  // requestEntity = <GET http://localhost:8080/spring_mvc/testRequestEntity,[host:"localhost:8080", connection:"keep-alive", sec-ch-ua:""Not)A;Brand";v="8", "Chromium";v="138", "Google Chrome";v="138"", sec-ch-ua-mobile:"?0", sec-ch-ua-platform:""Windows"", upgrade-insecure-requests:"1", user-agent:"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/138.0.0.0 Safari/537.36", accept:"text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7", sec-fetch-site:"none", sec-fetch-mode:"navigate", sec-fetch-user:"?1", sec-fetch-dest:"document", accept-encoding:"gzip, deflate, br, zstd", accept-language:"zh-CN,zh;q=0.9"]>
        return "success";
    }


    // HTTP状态 406 - 不可接收  需要引入jackson包来进行对象json转换
    @GetMapping("/testResponseBody")
    @ResponseBody
    public User testResponseBody() {
        System.out.println("testResponseBody...");
//        int a = 1/0;
        User user = new User();
        user.setUsername("Jack");
        user.setHobby(List.of("A", "B"));
        return user;
    }

    @GetMapping("/testDownload")
    public ResponseEntity<byte[]> testDownload(HttpServletRequest request) throws IOException {
        System.out.println("testDownload...");
        ServletContext servletContext = request.getServletContext();
        String path = servletContext.getRealPath("/imgs/http.png");
        System.out.println("path = " + path);
        FileInputStream fileInputStream = new FileInputStream(path);

        MultiValueMap<String, String> httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Disposition", "attachment;filename=http.png");
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(fileInputStream.readAllBytes(), httpHeaders, HttpStatus.OK);
        fileInputStream.close();
        return responseEntity;
    }

    // 需要配置一个文件解析器StandardServletMultipartResolver(spring6)，否则空指针  // todo
    @PostMapping("/testUpload")
    public String testUpload(@RequestPart("fileUpload") MultipartFile fileUpload) throws IOException {
        String originalFilename = fileUpload.getOriginalFilename();
        fileUpload.transferTo(new File(originalFilename));
        return "success";
    }

    @RequestMapping(path = "/fileUploadSpringMVC")
    public String fileUploadSpringMVC(HttpServletRequest request, MultipartFile fileUpload) throws Exception {
        //MultipartFile fileUpload表示springMVC已经将需要上传的文件封装好了，只需要配置上传路径上传即可
        System.out.println("文件上传 fileUploadSpringMVC。。。");
        // 1. 设置上传的路径
        String uploadPath = request.getSession().getServletContext().getRealPath("/uploads/");
        // 判断要上传路径是否存在
        File file = new File(uploadPath);
        if (!file.exists()) {
            file.mkdirs();
        }
        // 2. 获取上传的名字
        String originalFilename = fileUpload.getOriginalFilename();
        String fileName = Instant.now().toEpochMilli() + "_" + originalFilename;

        // 3. 上传
        fileUpload.transferTo(new File(uploadPath, fileName));

        System.out.println("文件上传成功！");
        return "success";
    }
}
