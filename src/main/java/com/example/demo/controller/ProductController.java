package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.po.Product;
import com.example.demo.service.ProductService;
import com.example.demo.service.ShoppingService;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ShoppingService shoppingService;

    @GetMapping("/products")
    public String listProducts(Model model) {
        model.addAttribute("products", productService.findAllProducts());
        return "products";
    }

    @PostMapping("/add-to-cart")
    public String addToCart(@RequestParam Integer cakeId, @RequestParam Integer quantity, Model model) {
        Product cake = productService.findById(cakeId).orElseThrow(() -> new RuntimeException("Product not found"));
        cake.setQuantity(quantity);
        shoppingService.addToCart(cake);
        return "redirect:/products";
    }

    @GetMapping("/cart")
    public String viewCart(Model model) {
        model.addAttribute("cartItems", shoppingService.getCakesInCart());
        model.addAttribute("totalPrice", shoppingService.calculateTotalPrice());
        return "cart";
    }

    @PostMapping("/update-quantity")
    public String updateQuantity(@RequestParam Integer cakeId, @RequestParam Integer quantity) {
        shoppingService.updateQuantity(cakeId, quantity);
        return "redirect:/cart";
    }

    @PostMapping("/remove-from-cart")
    public String removeFromCart(@RequestParam Integer cakeId) {
        shoppingService.removeFromCart(cakeId);
        return "redirect:/cart";
    }

    @PostMapping("/clear-cart")
    public String clearCart() {
        shoppingService.clearCart();
        return "redirect:/cart";
    }
}