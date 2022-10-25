package test;

import com.atguigu.spring.pojo.Student;
import com.atguigu.spring.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IOCTest {
    @Test
    public void test(){
        ApplicationContext ioc=new ClassPathXmlApplicationContext("ApplicationContext.xml");
        Student studentOne = (Student) ioc.getBean("studentOne");
        System.out.println(studentOne);
    }
    @Test
    public void test1(){
        ApplicationContext ioc=new ClassPathXmlApplicationContext("ApplicationContext.xml");
        Student studentOne = ioc.getBean("studentTwo",Student.class);
        System.out.println(studentOne);
    }
    @Test
    public void test3(){
        ApplicationContext ioc=new ClassPathXmlApplicationContext("ApplicationContext.xml");
        Student studentOne = ioc.getBean("studentThree",Student.class);
        System.out.println(studentOne);
    }
    @Test
    public void test4(){
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("spring-lifecycle.xml");
        User bean = ioc.getBean(User.class);
        System.out.println(bean);
        ioc.close();
    }
}
