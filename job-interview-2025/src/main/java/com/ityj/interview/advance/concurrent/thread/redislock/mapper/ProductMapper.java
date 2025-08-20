package com.ityj.interview.advance.concurrent.thread.redislock.mapper;

import org.apache.ibatis.annotations.Param;

public interface ProductMapper {

    int getBalance(@Param("productId") int productId);
    int updateBalance(@Param("productId") int productId, @Param("newBalance") int newBalance);

}
