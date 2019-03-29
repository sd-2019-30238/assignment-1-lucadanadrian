package bll;

import connection.Connection;
import dao.OrderDAO;
import model.Book;
import model.BookOrder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class BookOrderBLL {
    ApplicationContext appContext = new AnnotationConfigApplicationContext(Connection.class);
    OrderDAO orders =appContext.getBean("orderDAO",OrderDAO.class);
    public BookOrderBLL(){
    }
    public BookOrder selectById(int id){
        return orders.selectByOrderId(id);
    }
    public List<BookOrder> selectAllOrers(){
        return orders.selecOrders();
    }
    public void insertBookOrder(BookOrder order){
        orders.insertOrder(order);
    }
    public void updateOrder(BookOrder order){
        orders.updateOrder(order);
    }
    public void deleteOrder(int id){
        orders.deleteOrder(id);
    }
}
