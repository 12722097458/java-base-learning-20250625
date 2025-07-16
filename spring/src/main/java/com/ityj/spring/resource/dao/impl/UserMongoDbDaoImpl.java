package com.ityj.spring.resource.dao.impl;

import com.ityj.spring.resource.dao.UserDao;
import org.springframework.stereotype.Repository;

@Repository("resourceUserMongoDbDaoImpl")
public class UserMongoDbDaoImpl implements UserDao {
    @Override
    public void add() {
        System.out.println("resourceUserMongoDbDaoImpl.add()...");
    }
}
