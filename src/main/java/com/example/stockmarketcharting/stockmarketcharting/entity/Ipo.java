package com.example.stockmarketcharting.stockmarketcharting.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Ipo {

	@Id
	@GeneratedValue
	private int id;
	
	@Column(nullable = false)
    private float pricePerShare;
	
	@Column(nullable = false)
    private Long totalShares;
	
    @Column(nullable = false)
    private String openDateTime;
	
    @Column(nullable = false)
    private String remarks;
    
    @OneToOne(mappedBy="ipo")
    private Company company;
    
    @ManyToMany(mappedBy="ipo")
    private List<StockExchange> stockExchanges = new ArrayList<>();

	public float getPricePerShare() {
		return pricePerShare;
	}

	public void setPricePerShare(float pricePerShare) {
		this.pricePerShare = pricePerShare;
	}

	public Long getTotalShares() {
		return totalShares;
	}

	public void setTotalShares(Long totalShares) {
		this.totalShares = totalShares;
	}

	public String getOpenDateTime() {
		return openDateTime;
	}

	public void setOpenDateTime(String openDateTime) {
		this.openDateTime = openDateTime;
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

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public List<StockExchange> getStockExchanges() {
		return stockExchanges;
	}
	
	public List<StockExchange> addStockExchange() {
		return stockExchanges;
	}

	public Ipo(float pricePerShare, Long totalShares, String openDateTime, String remarks, Company company) {
		super();
		this.pricePerShare = pricePerShare;
		this.totalShares = totalShares;
		this.openDateTime = openDateTime;
		this.remarks = remarks;
		this.company = company;
	}

	public Ipo() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Ipo [id=" + id + ", pricePerShare=" + pricePerShare + ", totalShares=" + totalShares + ", openDateTime="
				+ openDateTime + ", remarks=" + remarks + ", company=" + company + "]";
	}
    
}