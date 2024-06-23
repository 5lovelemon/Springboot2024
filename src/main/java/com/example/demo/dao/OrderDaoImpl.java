package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.model.po.Order;

@Repository
public class OrderDaoImpl implements OrderDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Order> findAllOrders() {
        String sql = "SELECT * FROM `order`";12
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Order.class));
    }

    @Override
    public Optional<Order> findById(Integer id) {
        String sql = "SELECT * FROM `order` WHERE orderid = ?";
        try {
            Order order = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Order.class), id);
            return Optional.ofNullable(order);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public int createOrder(Order order) {
        String sql = "INSERT INTO `order` (userid, cakeid, quantity, order_status, total_price, created_at) VALUES (?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, order.getUserId(), order.getCakeId(), order.getQuantity(), order.getOrderStatus(), order.getTotalPrice(), order.getCreatedAt());
    }
}