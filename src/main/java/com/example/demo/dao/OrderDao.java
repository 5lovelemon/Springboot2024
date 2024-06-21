package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.po.Order;

public interface OrderDao {
    List<Order> findAllOrders();
    Optional<Order> findById(Integer id);
    int createOrder(Order order);
}