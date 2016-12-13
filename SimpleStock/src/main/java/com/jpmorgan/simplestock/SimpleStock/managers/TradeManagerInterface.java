package com.jpmorgan.simplestock.SimpleStock.managers;

import java.util.ArrayList;

import com.jpmorgan.simplestock.SimpleStock.pojo.Trade;

public interface TradeManagerInterface {
	public ArrayList<Trade> getTrades();
	public void recordTrade(Trade trade);
}
