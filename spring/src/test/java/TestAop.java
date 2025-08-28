import com.ityj.spring.aop.service.Calculator;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAop {

    private static final Logger log = LoggerFactory.getLogger(TestAop.class);

    @Test
    public void testAop_anno() {  //@After("pt()")  不生效的话用一个controller， 直接调用就好了
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean-aop.xml");
        Calculator calculator = context.getBean("calculatorImpl", Calculator.class);
        int add = calculator.add(1, 2);
        System.out.println("add = " + add);
    }

    @Test
    public void testAop_xml() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean-aop-xml.xml");
        Calculator calculator = context.getBean("calculatorImpl", Calculator.class);
        int add = calculator.add(1, 2);
        System.out.println("add = " + add);
    }
}
