package com.jpmorgan.simplestock.SimpleStock.pojo;



import java.util.Date;

import com.jpmorgan.simplestock.SimpleStock.enums.TradeType;

public class Trade {
	private TradeType type;
	private Integer quantity;
	private Double price;
	private Date date;
	private Stock stock;

	public Trade(Stock stock, TradeType type, Integer quantity, Double price, Date date) {
		super();
		this.type = type;
		this.quantity = quantity;
		this.price = price;
		this.stock = stock;
		this.date = date;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public TradeType getType() {
		return type;
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	public void setType(TradeType type) {
		this.type = type;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Trade [type=" + type + ", quantity=" + quantity + ", price=" + price + ", date=" + date + ", stock="
				+ stock + "]";
	}

}
