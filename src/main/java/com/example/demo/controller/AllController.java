package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AllController {
    
    // 顯示蛋糕首頁
	@GetMapping({"/cake", "/"})
    public String showCakePage() {
        return "cake"; // 返回蛋糕首頁
    }
    
    // 顯示全部蛋糕頁面
    @GetMapping("/all")
    public String showAllCakesPage() {
        return "all"; // 返回全部蛋糕頁面
    }
    
    // 顯示購物須知
    @GetMapping("/shoppingnote")
    public String showShoppingPage() {
        return "shoppingnote"; // 返回購物須知頁面
    }
}

