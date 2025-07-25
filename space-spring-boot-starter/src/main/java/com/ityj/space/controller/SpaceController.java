package com.ityj.space.controller;

import com.ityj.space.service.SpaceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class SpaceController {

    @Autowired
    private SpaceService spaceService;

    @RequestMapping("/launch")
    public String launch() {
        return spaceService.launch();
    }


}
