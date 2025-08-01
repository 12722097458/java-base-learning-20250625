package com.ityj.cloud.apis;

import com.ityj.cloud.entities.Pay;
import com.ityj.cloud.entities.PayDTO;
import com.ityj.cloud.response.ResultData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(value = "cloud-payment-service")
public interface PayFeignApi {

    @GetMapping("/pay/getAll")
    ResultData<List<PayDTO>> queryAll();

    @GetMapping("/pay/get/{id}")
    ResultData<PayDTO> queryById(@PathVariable("id") Integer id);

    @PostMapping(value = "/pay/add")
    ResultData<String> addPay(@RequestBody Pay pay);

    @GetMapping(value = "/pay/info")
    ResultData<String> info();


}
