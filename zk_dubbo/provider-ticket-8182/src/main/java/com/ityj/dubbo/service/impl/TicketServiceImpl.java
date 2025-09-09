package com.ityj.dubbo.service.impl;

import com.ityj.dubbo.service.TicketService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@DubboService  //服务发送出去
@Component
public class TicketServiceImpl implements TicketService {

    @Value("${server.port}")
    private String serverPort;

    @Override
    public String getTicket(String ticketNo) throws InterruptedException {
        System.out.println(ticketNo);
        System.out.println(new Date());
        if ("-1".equals(ticketNo)) {
            TimeUnit.SECONDS.sleep(5);
        }
        return "Dubbo provider TicketServiceImpl......" + ticketNo + "; serverPort: " + serverPort;
    }
}
