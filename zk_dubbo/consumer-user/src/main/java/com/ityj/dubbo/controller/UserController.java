package com.ityj.dubbo.controller;

import com.ityj.dubbo.service.TicketService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @DubboReference
    private TicketService ticketService;

    // http://localhost:8888/ticket/7
    @GetMapping("/ticket/{ticketNo}")
    public String buyTicket(@PathVariable("ticketNo") String ticketNo) {
        return ticketService.getTicket(ticketNo);
    }

}
