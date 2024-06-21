package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.po.Cake;

public interface ProductDao {
    List<Cake> findAllProducts();
    Optional<Cake> findById(Integer id);
}