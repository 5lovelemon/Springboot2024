package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.dto.UserDto;
import com.example.demo.model.dto.UserUpdateDto;
import com.example.demo.model.po.User;
import com.example.demo.service.UserService;

@Controller
@RequestMapping
public class UserController {

    @Autowired
    private UserService userService;
    
    // 用戶註冊頁面
    @GetMapping("/account")
    public String showRegisterForm() {
        return "account";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute UserDto userDto, Model model) {
        String message = userService.createUser(userDto);
        model.addAttribute("message", message);
        if (message.equals("註冊成功")) {
            return "redirect:/cake"; // 跳回到首页
        } else {
            return "account"; // 保留在注册页面
        }
    }
    
    // 用戶修改頁面
    @GetMapping("/updatePassword")
    public String showUpdatePasswordForm(Model model) {
        model.addAttribute("userUpdateDto", new UserUpdateDto());
        return "updatePassword";
    }

    @PostMapping("/updatePassword")
    public String updatePassword(@ModelAttribute UserUpdateDto userUpdateDto, Model model) {
        String message = userService.updateUser(userUpdateDto);
        model.addAttribute("message", message);
        return "updatePassword"; // 保留在修改密码页面
    }

    // 用戶登入頁面
    @GetMapping("/cname")
    public String showLoginForm(Model model) {
        return "cname";
    }

    @PostMapping("/cname")
    public String login(@RequestParam String email, @RequestParam String password, Model model) {
        Optional<User> userOpt = userService.getUserByEmail(email);
        if (userOpt.isPresent() && userOpt.get().getPassword().equals(password)) {
            return "redirect:/cake"; // 登录成功，跳转到首页
        } else {
            model.addAttribute("message", "登录失败，用户名或密码错误");
            return "cname"; // 登录失败，保留在登录页面
        }
    }
}