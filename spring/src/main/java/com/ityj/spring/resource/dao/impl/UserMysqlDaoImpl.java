package com.ityj.spring.resource.dao.impl;

import com.ityj.spring.resource.dao.UserDao;
import org.springframework.stereotype.Repository;

@Repository("resourceUserMysqlDaoImpl")
public class UserMysqlDaoImpl implements UserDao {
    @Override
    public void add() {
        System.out.println("resourceUserMysqlDaoImpl.add()...");
    }
}
