package com.jpmorgan.simplestock.SimpleStock.managers;

import java.util.HashMap;

import com.jpmorgan.simplestock.SimpleStock.pojo.Stock;

public interface StockManagerInterafce {
	public HashMap<String, Stock> getStocks();
	public void addStock(Stock stock);
}
