package com.ityj.jdbc;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.jupiter.api.Test;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

public class C3P0PoolTest {

    @Test
    public void testC3p0Pool() throws SQLException, PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://192.168.137.110/sys?serverTimezone=EST");
        dataSource.setUser("root");
        dataSource.setPassword("root");
//        dataSource.setMaxPoolSize();
//        dataSource.setInitialPoolSize();
        System.out.println("dataSource = " + dataSource);
        Connection connection = dataSource.getConnection();
        System.out.println("connection = " + connection);
    }


    /*
    *   public ComboPooledDataSource(String configName) {
        super(configName);
    }
    * 可以通过xml配置资源， 直接加载dataSource
    *
    * */


}
