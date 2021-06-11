package com.example.stockmarketcharting.stockmarketcharting.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class StockPrice {

	@Id
	@GeneratedValue
	private int id;
	
	@ManyToOne
	private Company company;
	
	@ManyToOne
	private StockExchange stockExchange;
	
	@Column(nullable = false)
	private float stockPrice;
	
	@Column(nullable = false)
	private String date;
	
	@Column(nullable = false)
	private String time;

	public float getStockPrice() {
		return stockPrice;
	}

	public void setStockPrice(float stockPrice) {
		this.stockPrice = stockPrice;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getId() {
		return id;
	}

	public Company getCompany() {
		return company;
	}

	public StockExchange getStockExchange() {
		return stockExchange;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public void setStockExchange(StockExchange stockExchange) {
		this.stockExchange = stockExchange;
	}

	public StockPrice(Company company, StockExchange stockExchange, float stockPrice, String date, String time) {
		super();
		this.company = company;
		this.stockExchange = stockExchange;
		this.stockPrice = stockPrice;
		this.date = date;
		this.time = time;
	}

	public StockPrice(float stockPrice, String date, String time) {
		super();
		this.stockPrice = stockPrice;
		this.date = date;
		this.time = time;
	}

	public StockPrice() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "StockPrice [id=" + id + ", company=" + company + ", stockExchange=" + stockExchange + ", stockPrice="
				+ stockPrice + ", date=" + date + ", time=" + time + "]";
	}
	
}
