package com.jpmorgan.simplestock.SimpleStock.managers;

import java.util.ArrayList;

import com.jpmorgan.simplestock.SimpleStock.pojo.Trade;

public class TradeManager implements TradeManagerInterface {
	private static TradeManager instance;
	private ArrayList<Trade> trades = new ArrayList<Trade>();

	private TradeManager() {
	}

	public static TradeManager getInstance() {
		if (instance == null) {
			instance = new TradeManager();
		}
		return instance;
	}

	public ArrayList<Trade> getTrades() {
		return this.trades;
	}

	public void recordTrade(Trade trade) {
		this.trades.add(trade);
	}

}
