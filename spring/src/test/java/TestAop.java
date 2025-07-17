import com.ityj.spring.aop.service.Calculator;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAop {

    private static final Logger log = LoggerFactory.getLogger(TestAop.class);

    @Test
    public void testBefore() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean-aop.xml");
        Calculator calculator = context.getBean("calculatorImpl", Calculator.class);
        int add = calculator.add(1, 2);
        System.out.println("add = " + add);
    }

}
