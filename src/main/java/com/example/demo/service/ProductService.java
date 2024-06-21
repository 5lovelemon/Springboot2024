package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ProductDao;
import com.example.demo.model.po.Cake;

@Service
public class ProductService {

    @Autowired
    private ProductDao productDao;

    public List<Cake> findAllProducts() {
        return productDao.findAllProducts();
    }

    public Optional<Cake> findById(Integer id) {
        return productDao.findById(id);
    }
}