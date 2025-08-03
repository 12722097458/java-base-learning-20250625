package com.ityj.cloud.controller;

import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.core.util.IdUtil;
import com.ityj.cloud.entities.Pay;
import com.ityj.cloud.response.ResultData;
import com.ityj.cloud.service.PayService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Enumeration;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class PayGateWayController
{
    @Resource
    PayService payService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/pay/gateway/get/{id}")
    public ResultData<Pay> getById(@PathVariable("id") Integer id)
    {
        Pay pay = payService.queryById(id);
        return ResultData.success(pay);
    }

    @GetMapping(value = "/pay/gateway/info")
    public ResultData<String> getGatewayInfo(HttpServletRequest request) {
        log.info("Input parameter gender : {}", request.getParameter("gender"));
        ThreadUtil.sleep(3, TimeUnit.SECONDS);
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            log.info("request Header {} : {}", headerName, request.getHeader(headerName));
        }
        return ResultData.success("port is : "+ serverPort +", gateway info test："+ IdUtil.simpleUUID());
    }
}


 

