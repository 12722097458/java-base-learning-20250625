package com.ityj.cloud.service;

import com.ityj.cloud.entities.Pay;

import java.util.List;

public interface PayService {

    int insert(Pay pay);
    int deleteById(int id);
    int updateById(Pay pay);
    Pay queryById(int id);
    List<Pay> queryAll();


}
