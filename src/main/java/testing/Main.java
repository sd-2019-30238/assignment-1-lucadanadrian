package testing;

import connection.Connection;
import dao.BookDAO;
//import dao.OrderDAO;
import dao.OrderDAO;
import dao.StaffDAO;
import dao.UserDAO;
import model.Book;
import model.BookOrder;
import model.Staff;
import model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Main {
    public static void main(String[] args){
        ApplicationContext appContext = new AnnotationConfigApplicationContext(Connection.class);
        UserDAO users = appContext.getBean("userDAO",UserDAO.class);
        BookDAO book = appContext.getBean("bookDAO",BookDAO.class);
        StaffDAO staff=appContext.getBean("staffDAO", StaffDAO.class);
        OrderDAO orders =appContext.getBean("orderDAO",OrderDAO.class);

//        users.insertTable(new User(4,"user@email1","nume1","prenume1","asd"));
//        users.insertTable(new User(2,"user@email2","nume2","prenume2","pass2"));
//        users.insertTable(new User(3,"user@email3","nume3","prenume3","pass3"));


//        orders.insertOrder(new BookOrder(2,new User(1,"user@email1","nume1","prenume1","pass1"),new Book(1,"titlu1","author1","gen1","release1",1,1),1));
//        orders.insertOrder(new BookOrder(1,new User(1,"user@email1","nume1","prenume1","pass1"),new Book(1,"titlu1","author1","gen1","release1",1,1),2));

//        orders.updateOrder(new BookOrder(1,new User(1,"user@email1","nume1","prenume1","pass1"),new Book(2,"titlu1","author1","gen1","release1",1,1)));


//        book.insertTable(new Book(1,"titlu1","author1","gen1","release1",1,1));
//        book.insertTable(new Book(2,"titlu2","author2","gen2","release2",2,2));
//        book.insertTable(new Book(3,"titlu3","author3","gen3","release3",3,3));


//        staff.insertStaff(new Staff(1,"email1","pass1"));
//        staff.insertStaff(new Staff(2,"email2","pass2"));
//        staff.insertStaff(new Staff(3,"email3","pass3"));

//        System.out.println(users.selectById(2));
//        System.out.println(book.selectById(2));
//        System.out.println(staff.selectStaffById(2));
//
//        System.out.println(users.selectAll());
//        System.out.println(book.selectAll());
//        System.out.println(staff.selectAll());

//        orders.deleteOrder(3);
//        users.deleteFromTable(7);
//        staff.deleteStaff(3);
        book.deleteFromTable(4);

//        System.out.println(orders.selecOrders());

    }
}


