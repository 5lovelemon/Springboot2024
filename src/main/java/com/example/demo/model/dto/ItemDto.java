package com.example.demo.model.dto;

import com.example.demo.model.po.Cake;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemDto {
	private Integer orderid; // 訂單編號
	private Integer quantity; // 訂購數量
	private Integer subtotal; // 小計
	private Cake cake; // 蛋糕資料
}