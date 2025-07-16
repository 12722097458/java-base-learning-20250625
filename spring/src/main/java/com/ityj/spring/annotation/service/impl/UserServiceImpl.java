package com.ityj.spring.annotation.service.impl;

import com.ityj.spring.annotation.dao.UserDao;
import com.ityj.spring.annotation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    /*
    // Could not autowire. There is more than one bean of 'UserDao' type.
    *   Beans:
userMongoDbDaoImpl   (UserMongoDbDaoImpl.java)
userMysqlDaoImpl   (UserMysqlDaoImpl.java)
    * */
    @Autowired
    @Qualifier("userMongoDbDaoImpl")
    private UserDao userDao;

    @Override
    public void add() {
        System.out.println("UserServiceImpl.add()...");
        userDao.add();
    }
}
