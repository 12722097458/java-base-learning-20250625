import com.ityj.spring.annotation.bean.Student;
import com.ityj.spring.annotation.config.MyConfiguration;
import com.ityj.spring.annotation.controller.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

public class AnnotationTest {


    @Test
    public void beanCreate() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean-annotation.xml");
        Student student = context.getBean("student", Student.class);
        System.out.println("student = " + student);
    }

    @Test
    public void testAutowired() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean-annotation.xml");
        UserController userController = context.getBean("userController", UserController.class);
        userController.add();
    }


    @Test
    public void testResource() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean-annotation.xml");
        com.ityj.spring.resource.controller.UserController userController = context.getBean("resourceUserController", com.ityj.spring.resource.controller.UserController.class);
        userController.add();
    }


    @Test
    public void testFullAnnotation() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfiguration.class);
        UserController userController = context.getBean("userController", UserController.class);
        userController.add();
    }


}
