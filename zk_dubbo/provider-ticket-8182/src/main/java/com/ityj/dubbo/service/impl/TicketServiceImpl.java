package com.ityj.dubbo.service.impl;

import com.ityj.dubbo.service.TicketService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@DubboService  //服务发送出去
@Component
public class TicketServiceImpl implements TicketService {

    @Value("${server.port}")
    private String serverPort;

    @Override
    public String getTicket(String ticketNo) {
        return "Dubbo provider TicketServiceImpl......" + ticketNo + "; serverPort: " + serverPort;
    }
}
