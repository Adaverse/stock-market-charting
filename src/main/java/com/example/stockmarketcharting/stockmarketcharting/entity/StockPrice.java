package com.example.stockmarketcharting.stockmarketcharting.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity(name = "STOCK_PRICE")
public class StockPrice {

	@Id
	@GeneratedValue
	private int id;
	
//	@ManyToOne
//	private Company company;
	
	@ManyToOne
	private StockExchange stockExchange;
	
	@Column(nullable = false)
	private float stockPrice;
	
	@Column(nullable = false)
	private Date date;
	
	@ManyToOne
	private CompanyCode companyCode;

	public float getStockPrice() {
		return stockPrice;
	}

	public void setStockPrice(float stockPrice) {
		this.stockPrice = stockPrice;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getId() {
		return id;
	}

//	@JsonBackReference(value = "stockPrice-company")
//	public Company getCompany() {
//		return company;
//	}

	@JsonBackReference(value = "stockPrice-stockExchange")
	public StockExchange getStockExchange() {
		return stockExchange;
	}

//	public void setCompany(Company company) {
//		this.company = company;
//	}

	public void setStockExchange(StockExchange stockExchange) {
		this.stockExchange = stockExchange;
	}

	@JsonBackReference(value = "stockPrice-companyCode")
	public CompanyCode getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(CompanyCode companyCode) {
		this.companyCode = companyCode;
	}

	public StockPrice(float stockPrice, Date date) {
		super();
		this.stockPrice = stockPrice;
		this.date = date;
	}

	public StockPrice(Company company, StockExchange stockExchange, float stockPrice, Date date, String time,
			CompanyCode companyCode) {
		super();
		this.stockExchange = stockExchange;
		this.stockPrice = stockPrice;
		this.date = date;
		this.companyCode = companyCode;
	}

	public StockPrice() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "StockPrice [id=" + id  + ", stockPrice=" + stockPrice + ", date="
				+ date + "]";
	}

}
