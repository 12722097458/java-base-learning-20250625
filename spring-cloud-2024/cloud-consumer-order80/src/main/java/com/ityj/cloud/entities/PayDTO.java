package com.ityj.cloud.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PayDTO implements Serializable
{
    private Integer id;
    //支付流水号
    private String payNo;
    //订单流水号
    private String orderNo;
    //用户账号ID
    private Integer userId;
    //交易金额
    private BigDecimal amount;

    @JsonFormat(pattern = "yyyyMMdd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    @JsonFormat(pattern = "yyyyMMdd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;
}