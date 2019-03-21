package testing;

import connection.Connection;
import dao.UserDAO;
import model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args){
        ApplicationContext appContext = new AnnotationConfigApplicationContext(Connection.class);
        UserDAO users = appContext.getBean("userDAO",UserDAO.class);
        users.insertTable(new User(1,"luca@test","luca","adrina","123"));
        System.out.println(users.selectAll());
    }
}
