package com.ityj.spring.resource.service.impl;

import com.ityj.spring.resource.dao.UserDao;
import com.ityj.spring.resource.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("resourceUserServiceImpl")
public class UserServiceImpl implements UserService {

    // y.NoUniqueBeanDefinitionException: No qualifying bean of type 'com.ityj.spring.resource.dao.UserDao' available: expected single matching bean but found 2: resourceUserMongoDbDaoImpl,resourceUserMysqlDaoImpl
    /*@Resource   // @Resource的name没有配置， 所以1. 先根据"userDao"去找bean， 没有找到  2. 再根据UserDao类型找  --》 找到两个。。所以报错
    private UserDao userDao;*/

    // 正确方式1
    @Resource
    private UserDao resourceUserMysqlDaoImpl;

    // 正确方式 2
    @Resource(name = "resourceUserMysqlDaoImpl")
    private UserDao userDao;

    @Override
    public void add() {
        System.out.println("resourceUserServiceImpl.add()...");
        System.out.println(userDao == resourceUserMysqlDaoImpl);
        userDao.add();
    }
}
