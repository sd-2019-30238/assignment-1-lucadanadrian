package bll;

import connection.Connection;
import dao.UserDAO;
import model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class UserBLL {
    ApplicationContext appContext = new AnnotationConfigApplicationContext(Connection.class);
    UserDAO users = appContext.getBean("userDAO",UserDAO.class);

    public UserBLL(){
    }
    public User findById(int id){
        return users.selectById(id);
    }

    public List<User> selectAllClients(){
        return users.selectAll();
    }

    public void insertUser(User user){
        users.insertTable(user);
    }
    public void updateUser(User user){
        users.insertTable(user);
    }

    public void deleteUser(int id){
        users.deleteFromTable(id);
    }
}
