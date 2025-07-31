package com.ityj.cloud.controller;

import com.ityj.cloud.entities.Pay;
import com.ityj.cloud.entities.PayDTO;
import com.ityj.cloud.service.PayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
public class PaymentController {

    @Autowired
    private PayService payService;

    @GetMapping("/pay/getAll")
    public List<PayDTO> queryAll() {
        List<Pay> data = payService.queryAll();
        List<PayDTO> result = new ArrayList<>();
        for (Pay datum : data) {
            PayDTO payDTO = new PayDTO();
            BeanUtils.copyProperties(datum, payDTO);
            result.add(payDTO);
        }
        return result;
    }

    @GetMapping("/pay/getAllData")
    public List<Pay> queryAllData() {
        return payService.queryAll();
    }

    @GetMapping("/pay/get/{id}")
    public PayDTO queryById(@PathVariable("id") Integer id) {
        Pay pay = payService.queryById(id);
        PayDTO payDTO = new PayDTO();
        BeanUtils.copyProperties(pay, payDTO);
        log.info("payDTO is : {}", payDTO);
        return payDTO;
    }

    @PostMapping(value = "/pay/add")
    public String addPay(@RequestBody Pay pay){
        int i = payService.insert(pay);
        return "成功插入记录，返回值："+i;
    }
    @DeleteMapping(value = "/pay/del/{id}")
    public Integer deletePay(@PathVariable("id") Integer id) {
        return payService.deleteById(id);
    }
    @PutMapping(value = "/pay/update")
    public String updatePay(@RequestBody PayDTO payDTO){
        Pay pay = new Pay();
        BeanUtils.copyProperties(payDTO, pay);
        int i = payService.updateById(pay);
        return "成功修改记录，返回值："+i;
    }




}
