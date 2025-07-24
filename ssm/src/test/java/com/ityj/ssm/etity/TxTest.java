package com.ityj.ssm.etity;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.TransactionManager;

import javax.sql.DataSource;

@SpringBootTest
class TxTest {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private TransactionManager transactionManager;

    @Test
    public void testTransactionManager() {
        System.out.println("transactionManager = " + transactionManager);  // transactionManager = org.springframework.jdbc.support.JdbcTransactionManager@5b3518e1

    }

    @Test
    public void testDataSource() {
        System.out.println("dataSource = " + dataSource);  // dataSource = HikariDataSource (null)
    }
  
}