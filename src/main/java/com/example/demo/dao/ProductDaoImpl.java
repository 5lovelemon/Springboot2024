package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.model.po.Cake;

@Repository
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Cake> findAllProducts() {
        String sql = "SELECT * FROM product";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Cake.class));
    }

    @Override
    public Optional<Cake> findById(Integer id) {
        String sql = "SELECT * FROM product WHERE cakeid = ?";
        try {
            Cake cake = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Cake.class), id);
            return Optional.ofNullable(cake);
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}