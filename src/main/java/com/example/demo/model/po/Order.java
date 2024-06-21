package com.example.demo.model.po;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("order")
public class Order {

    @Id
    @Column("orderid")
    private Integer orderId;

    @Column("userid")
    private Integer userId;

    @Column("cakeid")
    private Integer cakeId;

    @Column("quantity")
    private Integer quantity;

    @Column("order_status")
    private String orderStatus;

    @Column("total_price")
    private Integer totalPrice;

    @Column("created_at")
    private LocalDateTime created_at;
    
    // Getters 和 Setters
    
    public Integer getOrderId() {
    	return orderId;
    }
    
    public void setOrderId(Integer orderId) {
    	this.orderId = orderId;
    }
    
    public Integer getUserId() {
    	return userId;
    }
    
    public void setUserId() {
    	this.userId = userId;
    }
    
    public Integer getCakeId() {
    	return cakeId;
    }
    
    public void setCakeId() {
    	this.cakeId = cakeId;
    }
}