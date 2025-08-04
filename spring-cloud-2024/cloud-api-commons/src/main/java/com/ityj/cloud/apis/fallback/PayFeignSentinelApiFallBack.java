package com.ityj.cloud.apis.fallback;

import com.ityj.cloud.apis.PayFeignSentinelApi;
import com.ityj.cloud.response.ResultData;
import com.ityj.cloud.response.ReturnCodeEnum;
import org.springframework.stereotype.Component;

@Component
public class PayFeignSentinelApiFallBack implements PayFeignSentinelApi {

    @Override
    public ResultData getPayByOrderNo(String orderNo) {
        return ResultData.fail(ReturnCodeEnum.RC500.getCode(),"对方服务宕机或不可用，Openfeign FallBack服务降级o(╥﹏╥)o");
    }

}
