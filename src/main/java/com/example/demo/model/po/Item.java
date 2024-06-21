package com.example.demo.model.po;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class Item { // 訂單項目(明細)
	private Integer orderid; // 訂單編號
	private Integer cakeid; // 蛋糕編號
	private Integer quantity; // 訂購數量
	private Integer subtotal; // 小計
}
