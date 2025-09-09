package com.ityj.dubbo.service.fallback;

import com.ityj.dubbo.service.TicketService;

public class TicketServiceFallback implements TicketService {
    @Override
    public String getTicket(String ticketNo) {
        return "失败了。。降级处理！";
    }
}
