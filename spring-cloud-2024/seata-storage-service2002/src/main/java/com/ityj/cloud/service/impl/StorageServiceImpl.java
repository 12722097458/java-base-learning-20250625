package com.ityj.cloud.service.impl;

import com.ityj.cloud.mapper.StorageMapper;
import com.ityj.cloud.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class StorageServiceImpl implements StorageService {

    @Autowired
    private StorageMapper storageMapper;

    @Override
    public void decrease(Long productId, Integer count) {
        log.info("------->storage-service中扣减库存开始 productId:{}, count:{}", productId, count);
        int result = storageMapper.decrease(productId, count);
        if (result == 0) {
            throw new RuntimeException("AccountServiceImpl update failed - no data is updated!");
        }
        log.info("------->storage-service中扣减库存结束");
    }
}
