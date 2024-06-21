package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.service.OrderService;
import com.example.demo.service.ShoppingService;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ShoppingService shoppingService;

    @GetMapping("/orders")
    public String listOrders(Model model) {
        model.addAttribute("orders", orderService.findAllOrders());
        return "orders";
    }

    @PostMapping("/create-order")
    public String createOrder(@RequestParam Integer userId, Model model) {
        orderService.createOrder(userId);
        return "redirect:/orders";
    }
}