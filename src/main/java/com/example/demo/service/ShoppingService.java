package com.example.demo.service;

import com.example.demo.model.po.Cake;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShoppingService {

    private List<Cake> cakesInCart = new ArrayList<>();

    public List<Cake> getCakesInCart() {
        return cakesInCart;
    }

    public void addToCart(Cake cake) {
        // 将商品添加到购物车，如果购物车中已有相同商品，则增加数量；否则添加新项目到购物车
        boolean found = false;
        for (Cake item : cakesInCart) {
            if (item.getCakeid().equals(cake.getCakeid())) {
                item.setQuantity(item.getQuantity() + cake.getQuantity());
                found = true;
                break;
            }
        }
        if (!found) {
            cakesInCart.add(cake);
        }
    }

    public void removeFromCart(Integer cakeId) {
        // 从购物车中移除指定编号的蛋糕项目
        cakesInCart.removeIf(cake -> cake.getCakeid().equals(cakeId));
    }

    public void clearCart() {
        // 清空购物车
        cakesInCart.clear();
    }

    public void updateQuantity(Integer cakeId, Integer newQuantity) {
        // 更新购物车中指定编号蛋糕项目的数量
        for (Cake cake : cakesInCart) {
            if (cake.getCakeid().equals(cakeId)) {
                cake.setQuantity(newQuantity);
                break;
            }
        }
    }

    public int calculateTotalPrice() {
        // 计算购物车中所有商品的总价格
        int totalPrice = 0;
        for (Cake cake : cakesInCart) {
            totalPrice += cake.getCakeprice() * cake.getQuantity();
        }
        return totalPrice;
    }
}
