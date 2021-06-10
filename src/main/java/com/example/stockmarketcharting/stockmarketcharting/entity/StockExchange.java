package com.example.stockmarketcharting.stockmarketcharting.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class StockExchange {

	@Id
	@GeneratedValue
	private int id;
	
	@Column(nullable = false, unique = true)
    private String stockExchangeName;
	
    @Column(nullable = false)
    private String brief;
    
    @Column(nullable = false)
    private String address;
    
    @Column()
    private String remarks;
    
    @ManyToMany
    private List<Ipo> ipo = new ArrayList<>();
    
    @ManyToMany(mappedBy = "stockExchanges")
    private List<Company> companies = new ArrayList<>();
    
    @OneToMany(mappedBy = "stockExchange")
    private List<StockPrice> stockPrices = new ArrayList<>();

	public String getStockExchangeName() {
		return stockExchangeName;
	}

	public void setStockExchangeName(String stockExchangeName) {
		this.stockExchangeName = stockExchangeName;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public int getId() {
		return id;
	}

	public List<Ipo> getIpo() {
		return ipo;
	}

	public void addIpo(Ipo ipo) {
		this.ipo.add(ipo);
	}

	public List<Company> getCompanies() {
		return companies;
	}

	public void addCompany(Company company) {
		this.companies.add(company);
	}

	public List<StockPrice> getStockPrices() {
		return stockPrices;
	}

	public void addStockPrice(StockPrice stockPrice) {
		this.stockPrices.add(stockPrice);
	}

	public StockExchange(String stockExchangeName, String brief, String address, String remarks) {
		super();
		this.stockExchangeName = stockExchangeName;
		this.brief = brief;
		this.address = address;
		this.remarks = remarks;
	}

	public StockExchange() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "StockExchange [id=" + id + ", stockExchangeName=" + stockExchangeName + ", brief=" + brief
				+ ", address=" + address + ", remarks=" + remarks + "]";
	}

}
