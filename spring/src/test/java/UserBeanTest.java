import com.alibaba.druid.pool.DruidDataSource;
import com.ityj.spring.entity.Account;
import com.ityj.spring.entity.User;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

public class UserBeanTest {

    private static final Logger log = LoggerFactory.getLogger(UserBeanTest.class);

    @Test
    public void testBeanCreated() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        // 1 根据名字
        Object user1 = context.getBean("user");
        // 2 根据类型
        // org.springframework.beans.factory.NoUniqueBeanDefinitionException: No qualifying bean of type 'com.ityj.spring.entity.User' available: expected single matching bean but found 2: user,user2
        //  <bean id="user" class="com.ityj.spring.entity.User"></bean>
        //    <bean id="user2" class="com.ityj.spring.entity.User"></bean>
//        User user2 = context.getBean(User.class);
        // 3 名字 + 类型
        User user3 = context.getBean("user", User.class);
        log.info("user1 = {}", user1);
        log.info("user3 = {}", user3);
    }

    @Test
    public void testDi_setter() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        User user = context.getBean("user", User.class);
        log.info("user = {}", user);
    }

    @Test
    public void testDi_constructor() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        User user = context.getBean("user2", User.class);
        log.info("user = {}", user);
    }

    @Test
    public void testDi_special_character() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        User user = context.getBean("user3", User.class);
        log.info("user = {}", user);  //  user = User{name='<>', age=34}

        User user4 = context.getBean("user4", User.class);
        log.info("user4 = {}", user4);  //  user4 = User{name=' a <> b ', age=23}
    }

    @Test
    public void testDi_object() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        User user = context.getBean("user5", User.class);
        log.info("user = {}", user);
    }

    @Test
    public void testDi_collection() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Account account = context.getBean("account2", Account.class);
        log.info("account = {}", account);  // account = Account{arr=[a, b, c], list=[1, 2, 3], map={k1=1, k2=2}}
    }


    @Test
    public void testDi_datasource() throws SQLException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        DruidDataSource dataSource = context.getBean("druidDataSource", DruidDataSource.class);
        log.info("dataSource = {} - {}", dataSource.getClass(), dataSource.getConnection());
    }


    @Test
    public void testDi_auto() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        User user = context.getBean("user_auto", User.class);
        System.out.println("user = " + user);  // user = User{name='Lucy', age=23, account=Account{arr=[a, b, c], list=null, map=null}}
    }

}
