package com.assignment2.demo;

import com.assignment2.demo.connection.Connection;
import com.assignment2.demo.dao.UserDAO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
//        User user= new User("email","name","first","pass",0);
//        System.out.println(user.getEmail());
    }
//    public static void main(String[] args) {
//        ApplicationContext appContext = new AnnotationConfigApplicationContext(Connection.class);
//        UserDAO users= appContext.getBean("userDAO", UserDAO.class);
//        System.out.println(users.selectById(2));
//      users.insertTable(new User("user@email565","nume1","prenume1","asd",0));

//        User user= new User("email","name","first","pass",0);
//        System.out.println(user.getEmail());
//    }

}
