package com.ityj.ssm.config;

import com.ityj.ssm.etity.Dog;
import com.ityj.ssm.etity.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
// @Component Lite模式，创建了新的bean
public class StudentConfig {

    @Bean
    public Dog dog() {
        Dog dog = new Dog();
        System.out.println("dog = " + dog);
        return dog;
    }

    @Bean(initMethod = "initMethod", destroyMethod = "destroyMethod")
    public Student student() {
        Student student = new Student();
        student.setDog(dog());
        System.out.println("student.getDog() = " + student.getDog());
        return student;
    }
}
