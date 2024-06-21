package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.OrderDao;
import com.example.demo.model.po.Order;
import com.example.demo.model.po.Cake;

@Service
public class OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private ShoppingService shoppingService;

    public List<Order> findAllOrders() {
        return orderDao.findAllOrders();
    }

    public Order createOrder(Integer userId) {
        List<Cake> cartItems = shoppingService.getCakesInCart();
        int totalPrice = shoppingService.calculateTotalPrice();

        for (Cake cake : cartItems) {
            Order order = new Order();
            order.setUserId(userId);
            order.setCakeId(cake.getCakeid());
            order.setQuantity(cake.getQuantity());
            order.setOrderStatus("Pending");
            order.setTotalPrice(totalPrice);
            order.setCreatedAt(LocalDateTime.now());
            orderDao.createOrder(order);
        }

        shoppingService.clearCart();
        return null; // 返回订单信息，可以根据需要进行调整
    }
}