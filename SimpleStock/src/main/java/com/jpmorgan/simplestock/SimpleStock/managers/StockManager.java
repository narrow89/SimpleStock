package com.jpmorgan.simplestock.SimpleStock.managers;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import com.jpmorgan.simplestock.SimpleStock.pojo.Stock;
import com.jpmorgan.simplestock.SimpleStock.pojo.Trade;

public class StockManager implements StockManagerInterafce {

	private static StockManager instance;
	private HashMap<String, Stock> stocks = new HashMap<String, Stock>();

	private StockManager() {
	}

	public static StockManager getInstance() {
		if (instance == null) {
			instance = new StockManager();
		}
		return instance;
	}

	public HashMap<String, Stock> getStocks() {
		return this.stocks;
	}

	public void addStock(Stock stock) {
		this.stocks.put(stock.getSymbol(), stock);
	}

	public Double calculateVolumeWeightedStockPrice(String symbol) {
		Date now = new Date();
		Date startTime = new Date(now.getTime() - (5 * 60 * 1000));
		ArrayList<Trade> trd = new ArrayList<Trade>();
		TradeManager tradeManager = TradeManager.getInstance();

		for (int j = tradeManager.getTrades().size() - 1; j >= 0; j--) {
			Trade trade = tradeManager.getTrades().get(j);
			if (trade.getStock().getSymbol() == symbol && trade.getDate().after(startTime)
					&& trade.getDate().before(now)) {
				trd.add(trade);
			}
		}

		Double volumeWeigthedStockPrice = 0.0;
		Integer totalQuantity = 0;

		for (Trade trade : trd) {
			totalQuantity += trade.getQuantity();
			volumeWeigthedStockPrice += trade.getPrice() * trade.getQuantity();
		}
		return volumeWeigthedStockPrice / totalQuantity;
	}

	public Double getAllShareIndex() {
		Double sumVolumeWeightedStockPrice = 0.0;
		for (Stock stock : this.stocks.values()) {
			sumVolumeWeightedStockPrice += calculateVolumeWeightedStockPrice(stock.getSymbol());
		}
		return Math.pow(sumVolumeWeightedStockPrice, 1.0 / stocks.size());
	}

}
