package com.assignment2.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;


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
//        users.insertTable(new User("user@email565","nume1","prenume1","asd",0));

//        User user= new User("email","name","first","pass",0);
//        System.out.println(user.getEmail());
//    }

}
