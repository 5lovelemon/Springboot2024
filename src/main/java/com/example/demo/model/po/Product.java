package com.example.demo.model.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product { // 蛋糕商品
    private Integer cakeid; // 商品蛋糕id
    private String cakename; // 蛋糕名稱
    private Integer cakeprice; // 蛋糕價格
    private Integer quantity; // 訂購蛋糕數量
    
    // Getters 和 Setters
    
    public Integer getCakeid() {
        return cakeid;
    }

    public void setCakeid(Integer cakeid) {
        this.cakeid = cakeid;
    }

    public String getCakename() {
        return cakename;
    }

    public void setCakename(String cakename) {
        this.cakename = cakename;
    }

    public Integer getCakeprice() {
        return cakeprice;
    }

    public void setCakeprice(Integer cakeprice) {
        this.cakeprice = cakeprice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}