package com.ityj.cloud.mapper;

import com.ityj.cloud.entities.Account;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface AccountMapper extends Mapper<Account> {

    /**
     * @param userId
     * @param money  本次消费金额
     */
    int decrease(@Param("userId") Long userId, @Param("money") Long money);

}