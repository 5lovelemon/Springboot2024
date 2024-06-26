package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class CakeController {
	// 顯示蛋糕首頁
		@GetMapping({"/cake", "/"}) // 多打 "/" 是默認入口點
	    public String showCakePage() {
	        return "cake"; // 返回蛋糕首頁
	    }
}
