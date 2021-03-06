package com.example.stockmarketcharting.stockmarketcharting.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity(name = "COMPANY")
public class Company {

	@Id
	@GeneratedValue
	private int id;
	
	@Column(nullable = false, unique = true)
	private String companyName;
	
    @Column(nullable = false)
    private float turnOver;
    
    @Column(nullable = false)
    private String ceo;

	@Column(nullable = false)
    private String boardDirectors;
    
    @Column(nullable = false)
    private String briefWriteup;
    
    @OneToOne
    private Ipo ipo;
    
    @JsonIgnore
    @ManyToMany
    private List<StockExchange> stockExchanges = new ArrayList<>(); 
    
//    @OneToMany(mappedBy = "company", fetch=FetchType.LAZY)
//    private List<StockPrice> stockPrices = new ArrayList<>();
  
    @ManyToOne
    private Sector sector;
    
    @OneToMany(mappedBy = "company", fetch=FetchType.LAZY)
    private List<CompanyCode> companyCodes = new ArrayList<>();

	public Company(String companyName, float turnOver, String ceo, String boardDirectors, String briefWriteup, Ipo ipo,
			List<StockExchange> stockExchanges, Sector sector) {
		super();
		this.companyName = companyName;
		this.turnOver = turnOver;
		this.ceo = ceo;
		this.boardDirectors = boardDirectors;
		this.briefWriteup = briefWriteup;
		this.ipo = ipo;
		this.stockExchanges = stockExchanges;
//		this.stockPrices = stockPrices;
		this.sector = sector;
	}

	public Company(String companyName, float turnOver, String ceo, String boardDirectors, String briefWriteup) {
		super();
		this.companyName = companyName;
		this.turnOver = turnOver;
		this.ceo = ceo;
		this.boardDirectors = boardDirectors;
		this.briefWriteup = briefWriteup;
	}
	
	public Company(String companyName, float turnOver, String ceo, String boardDirectors, String briefWriteup, Ipo ipo) {
		super();
		this.companyName = companyName;
		this.turnOver = turnOver;
		this.ceo = ceo;
		this.boardDirectors = boardDirectors;
		this.briefWriteup = briefWriteup;
		this.ipo = ipo;
	}
	
	public Company(String companyName, float turnOver, String ceo, String boardDirectors, String briefWriteup, List<StockExchange> stockExchanges) {
		super();
		this.companyName = companyName;
		this.turnOver = turnOver;
		this.ceo = ceo;
		this.boardDirectors = boardDirectors;
		this.briefWriteup = briefWriteup;
		this.stockExchanges = stockExchanges;
	}

	public Company() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public float getTurnOver() {
		return turnOver;
	}

	public void setTurnOver(float turnOver) {
		this.turnOver = turnOver;
	}

	public String getCeo() {
		return ceo;
	}

	public void setCeo(String ceo) {
		this.ceo = ceo;
	}

	public String getBoardDirectors() {
		return boardDirectors;
	}

	public void setBoardDirectors(String boardDirectors) { 
		this.boardDirectors = boardDirectors;
	}

	public String getBriefWriteup() {
		return briefWriteup;
	}

	public void setBriefWriteup(String briefWriteup) {
		this.briefWriteup = briefWriteup;
	}

	public int getId() {
		return id;
	}

//	@JsonManagedReference(value = "company-stockExchange")
	public List<StockExchange> getStockExchanges() {
		return stockExchanges;
	}
	
	public void addStockExchange(StockExchange stockExchange) {
		this.stockExchanges.add(stockExchange);
	}
	
	public void setStockExchange(List<StockExchange> stockExchanges) {
		this.stockExchanges = stockExchanges;
	}

//	@JsonManagedReference(value = "stockPrice-company")
//	public List<StockPrice> getStockPrices() {
//		return stockPrices;
//	}
	
//	public void addStockPrice(StockPrice stockPrice) {
//		this.stockPrices.add(stockPrice);
//	}

	@JsonBackReference(value = "company-ipo")
	public Ipo getIpo() {
		return ipo;
	}

	public void setIpo(Ipo ipo) {
		this.ipo = ipo;
	}

	@JsonBackReference(value = "company-sector")
	public Sector getSector() {
		return sector;
	}

	public void setSector(Sector sector) {
		this.sector = sector;
	}

	@JsonManagedReference(value = "companyCode-company")
	public List<CompanyCode> getCompanyCode() {
		return companyCodes;
	}
	
	public void addCompanyCode (CompanyCode companyCode) {
		this.companyCodes.add(companyCode);
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", turnOver=" + turnOver + ", ceo=" + ceo + ", boardDirectors=" + boardDirectors
				+ ", briefWriteup=" + briefWriteup + " StockExhchange " + stockExchanges  + "]";
	}
	
}
