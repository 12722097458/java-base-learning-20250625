package com.ityj.cloud.service.impl;

import com.ityj.cloud.entities.Pay;
import com.ityj.cloud.mapper.PayMapper;
import com.ityj.cloud.service.PayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PayServiceImpl implements PayService {

    @Autowired
    private PayMapper payMapper;


    @Override
    public int insert(Pay pay) {
        return payMapper.insertSelective(pay);
    }

    @Override
    public int deleteById(int id) {
        return payMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateById(Pay pay) {
        return payMapper.updateByPrimaryKey(pay);
    }

    @Override
    public Pay queryById(int id) {
        return payMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Pay> queryAll() {
        return payMapper.selectAll();
    }
}
