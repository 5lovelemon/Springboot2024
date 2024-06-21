package com.example.demo.model.po;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Order { // 訂單主檔
	private Integer orderid; // 訂單編號
	private Integer userid; // 用戶編號
	private String created_at; // 訂單日期
	private List<Item> items = new CopyOnWriteArrayList<>(); // 訂單項目(明細)
	private Integer total_price; // 總計
}