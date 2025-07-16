import com.ityj.spring.entity.LifeCycleBean;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

public class LifeCycleBeanTest {

    private static final Logger log = LoggerFactory.getLogger(LifeCycleBeanTest.class);

    @Test
    public void beanLifeCycle() throws SQLException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean-lifecycle.xml");
        LifeCycleBean entity = context.getBean("lifeCycleBean", LifeCycleBean.class);
        System.out.println("6 bean实例创建完成。。entity = " + entity);
        // 测试bean生命周期
        context.close();
    }

}
