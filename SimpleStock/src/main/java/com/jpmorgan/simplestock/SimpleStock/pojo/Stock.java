package com.jpmorgan.simplestock.SimpleStock.pojo;

import com.jpmorgan.simplestock.SimpleStock.enums.StockType;

public class Stock {
	private String symbol;
	private StockType type;
	private Double lastDividend;
	private Double fixedDividend;
	private Double parValue;
	private Double lastPrice;


	public Stock(String symbol, StockType type, Double lastDividend, Double fixedDividend, Double parValue) {
		super();
		this.symbol = symbol;
		this.type = type;
		this.lastDividend = lastDividend;
		this.fixedDividend = fixedDividend;
		this.parValue = parValue;
	}
	public Double getLastPrice() {
		return lastPrice;
	}

	public void setLastPrice(Double lastPrice) {
		this.lastPrice = lastPrice;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public StockType getType() {
		return type;
	}

	public void setType(StockType type) {
		this.type = type;
	}

	public Double getLastDividend() {
		return lastDividend;
	}

	public void setLastDividend(Double lastDividend) {
		this.lastDividend = lastDividend;
	}

	public Double getFixedDividend() {
		return fixedDividend;
	}

	public void setFixedDividend(Double fixedDividend) {
		this.fixedDividend = fixedDividend;
	}

	public Double getParValue() {
		return parValue;
	}

	public void setParValue(Double parValue) {
		this.parValue = parValue;
	}



	@Override
	public String toString() {
		return "Stock [symbol=" + symbol + ", type=" + type + ", lastDividend=" + lastDividend + ", fixedDividend="
				+ fixedDividend + ", parValue=" + parValue + ", lastPrice=" + lastPrice + "]";
	}
	/**
	 * Given any price as input, calculate the dividend yield
	 * @param price
	 * @return dividend yield
	 */
	public Double dividend(Double price) {
		if (price > 0.0) {
			switch (this.getType()) {
			case COMMON:
				return this.getLastDividend() / price;
			case PREFERRED:
				return this.getFixedDividend() * this.getParValue() / price;
			default:
				return 0.0;
			}
		}
		return 0.0;
	}

	/**
	 * Given any price as input, calculate the P/E Ratio
	 * @param price
	 * @return P/E Ratio
	 */
	public Double PERatio(Double price) {
		return price / this.getLastDividend();
	}

}
