package com.example.demo.controller;

import com.example.demo.model.po.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account1")
public class AccountController {

//    @GetMapping
//    public String showRegistrationForm(@ModelAttribute("user") User user) {
//        return "register"; // 返回注册页面的视图名称
//    }

//    @PostMapping
//    public String handleAccountCreation(@ModelAttribute User user) {
//        // 处理用户注册逻辑
//        // 例如保存用户到数据库
//        return "redirect:/success"; // 重定向到成功页面
//    }
}