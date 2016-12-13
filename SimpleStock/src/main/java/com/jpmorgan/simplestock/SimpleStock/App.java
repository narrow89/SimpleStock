package com.jpmorgan.simplestock.SimpleStock;

import java.util.Date;
import java.util.Map;
import java.util.Random;

import com.jpmorgan.simplestock.SimpleStock.enums.StockType;
import com.jpmorgan.simplestock.SimpleStock.enums.TradeType;
import com.jpmorgan.simplestock.SimpleStock.managers.StockManager;
import com.jpmorgan.simplestock.SimpleStock.managers.TradeManager;
import com.jpmorgan.simplestock.SimpleStock.pojo.Stock;
import com.jpmorgan.simplestock.SimpleStock.pojo.Trade;

public class App {
	public static void main(String[] args) {
		StockManager stockManager = StockManager.getInstance();
		TradeManager tradeManager = TradeManager.getInstance();

		stockManager.addStock(new Stock("TEA", StockType.COMMON, 0.0, null, 100.0));
		stockManager.addStock(new Stock("POP", StockType.COMMON, 8.0, null, 100.0));
		stockManager.addStock(new Stock("ALE", StockType.COMMON, 23.0, null, 60.0));
		stockManager.addStock(new Stock("GIN", StockType.PREFERRED, 8.0, 2.0, 100.0));
		stockManager.addStock(new Stock("JOE", StockType.COMMON, 13.0, null, 250.0));

		for (Map.Entry<String, Stock> stock : stockManager.getStocks().entrySet()) {
			for (int i = 0; i < 5; i++) {
				Random rnd = new Random();
				/* Buy Stock */
				int quantity = rnd.nextInt(100 - 1) + 1;
				double price = rnd.nextDouble() * (10 - 1) + 1;
				Trade trade = new Trade(stock.getValue(), TradeType.BUY, quantity, price, new Date());
				tradeManager.recordTrade(trade);
				stock.getValue().setLastPrice(price);
				System.out.format("RecordTrade,Symbol: %s, Type: %s, quantity: %d, price: %f \n",
						stock.getValue().getSymbol(), TradeType.BUY, quantity, price);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				/* Sell Stock */
				quantity = rnd.nextInt(100 - 1) + 1;
				price = rnd.nextDouble() * (10 - 1) + 1;
				trade = new Trade(stock.getValue(), TradeType.SELL, quantity, price, new Date());
				tradeManager.recordTrade(trade);
				stock.getValue().setLastPrice(price);
				System.out.format("RecordTrade,Symbol: %s, Type: %s, quantity: %d, price: %f \n",
						stock.getValue().getSymbol(), TradeType.SELL, quantity, price);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			/* Calculate dividend yield */
			System.out.println(stock.getValue().getLastPrice());
			double dividend = stock.getValue().dividend(stock.getValue().getLastPrice());
			System.out.println("Dividend yield: " + dividend);

			/* Calculate P/E Ratio */
			double peratio = stock.getValue().PERatio(stock.getValue().getLastPrice());
			System.out.println("P/E Ratio: " + peratio);

			double volumeWeightedStockPrice = stockManager
					.calculateVolumeWeightedStockPrice(stock.getValue().getSymbol());
			System.out.format("Volume Weighted Stock Price for %s is %f \n", stock.getValue().getSymbol(),
					volumeWeightedStockPrice);

		}

		double allShareIndex = stockManager.getAllShareIndex();
		System.out.println("GBCD All Share Index: " + allShareIndex);

	}
}
