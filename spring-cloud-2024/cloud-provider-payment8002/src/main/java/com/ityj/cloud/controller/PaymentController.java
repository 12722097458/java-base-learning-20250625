package com.ityj.cloud.controller;

import com.ityj.cloud.entities.Pay;
import com.ityj.cloud.entities.PayDTO;
import com.ityj.cloud.service.PayService;
import com.ityj.cloud.response.ResultData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
public class PaymentController {

    @Autowired
    private PayService payService;


    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/pay/getAll")
    public ResultData<List<PayDTO>> queryAll() {
        List<Pay> data = payService.queryAll();
        List<PayDTO> result = new ArrayList<>();
        for (Pay datum : data) {
            PayDTO payDTO = new PayDTO();
            BeanUtils.copyProperties(datum, payDTO);
            result.add(payDTO);
        }
        return ResultData.success(result);
    }

    @GetMapping("/pay/get/{id}")
    public ResultData<PayDTO> queryById(@PathVariable("id") Integer id) {
        if (id < 0) {
            throw new RuntimeException("id should greater than 0");
        }
        Pay pay = payService.queryById(id);
        PayDTO payDTO = new PayDTO();
        BeanUtils.copyProperties(pay, payDTO);
        log.info("payDTO is : {}", payDTO);
        return ResultData.success(payDTO);
    }

    @PostMapping(value = "/pay/add")
    public ResultData<String> addPay(@RequestBody Pay pay){
        int i = payService.insert(pay);
        log.info("插入成功 : {}", i);
        return ResultData.success("成功插入记录，返回值："+i);
    }
    @DeleteMapping(value = "/pay/del/{id}")
    public ResultData<Integer> deletePay(@PathVariable("id") Integer id) {
        return ResultData.success(payService.deleteById(id));
    }
    @PutMapping(value = "/pay/update")
    public ResultData<String> updatePay(@RequestBody PayDTO payDTO){
        Pay pay = new Pay();
        BeanUtils.copyProperties(payDTO, pay);
        int i = payService.updateById(pay);
        return ResultData.success("成功修改记录，返回值：" + i);
    }

    @GetMapping(value = "/pay/consul/config")
    public ResultData<String> listConfig(@Value("${consulConfig.value}") String consulConfigName){
        return ResultData.success("configName from cunsul: " + consulConfigName + ", port:" + serverPort);
    }




}
