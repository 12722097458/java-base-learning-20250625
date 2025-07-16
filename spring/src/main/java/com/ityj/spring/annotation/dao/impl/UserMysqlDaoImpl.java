package com.ityj.spring.annotation.dao.impl;

import com.ityj.spring.annotation.dao.UserDao;
import org.springframework.stereotype.Repository;

@Repository
public class UserMysqlDaoImpl implements UserDao {
    @Override
    public void add() {
        System.out.println("UserMysqlDaoImpl.add()...");
    }
}
