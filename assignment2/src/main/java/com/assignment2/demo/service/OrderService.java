package com.assignment2.demo.service;

import com.assignment2.demo.dao.OrderDAO;
import com.assignment2.demo.model.BookOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class OrderService {
    private OrderDAO orderDAO;

    @Autowired
    public OrderService(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    public List<BookOrder> getOrdersForAnUserByEmail(String email) {
        return orderDAO.selectOrdersByUsersEmail(email);
    }
}
