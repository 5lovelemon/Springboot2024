package com.example.demo.model.dto;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import com.example.demo.model.po.Cake;
import com.example.demo.model.po.Item;
import com.example.demo.model.po.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
	private Integer orderid; // 訂單編號
	private String created_at; // 訂單日期
	
	//關聯欄位
	private User user; // 用戶資料
	private Item item; // 訂單細目
}