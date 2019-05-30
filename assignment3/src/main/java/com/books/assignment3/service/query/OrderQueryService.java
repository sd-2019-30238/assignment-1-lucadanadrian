package com.books.assignment3.service.query;

import com.books.assignment3.dao.OrderDAO;
import com.books.assignment3.model.database.BookOrder;
import com.books.assignment3.model.database.User;
import com.books.assignment3.model.query.BookOrderQueryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class OrderQueryService {
    private OrderDAO orderDAO;

    @Autowired
    public OrderQueryService(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }
    public List<BookOrderQueryDTO> getOrdersForAnUserByEmail(String email){
        List<BookOrder> bookOrders = orderDAO.selectOrdersByUsersEmail(email);
        List<BookOrderQueryDTO> bookOrderQueryDTOS = new ArrayList<>();
        for(BookOrder bookOrder: bookOrders){
            BookOrderQueryDTO bookOrderQueryDTO = new BookOrderQueryDTO();
            bookOrderQueryDTO.setId(bookOrder.getId());
            bookOrderQueryDTO.setBook(bookOrder.getBook());
            bookOrderQueryDTO.setUser(bookOrder.getUser());
            bookOrderQueryDTOS.add(bookOrderQueryDTO);
        }
        return bookOrderQueryDTOS;
    }
}
