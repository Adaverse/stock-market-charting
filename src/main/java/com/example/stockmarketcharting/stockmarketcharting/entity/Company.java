package com.example.stockmarketcharting.stockmarketcharting.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Company {

	@Id
	@GeneratedValue
	private int id;
	
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
    
    @ManyToMany
    private List<StockExchange> stockExchanges = new ArrayList<>();
    
    @OneToMany(mappedBy = "company")
    private List<StockPrice> stockPrices = new ArrayList<>();
  
    @OneToOne
    private Sector sector;

	public Company(float turnOver, String ceo, String boardDirectors, String briefWriteup, Ipo ipo,
			List<StockExchange> stockExchanges, List<StockPrice> stockPrices, Sector sector) {
		super();
		this.turnOver = turnOver;
		this.ceo = ceo;
		this.boardDirectors = boardDirectors;
		this.briefWriteup = briefWriteup;
		this.ipo = ipo;
		this.stockExchanges = stockExchanges;
		this.stockPrices = stockPrices;
		this.sector = sector;
	}

	public Company(float turnOver, String ceo, String boardDirectors, String briefWriteup) {
		super();
		this.turnOver = turnOver;
		this.ceo = ceo;
		this.boardDirectors = boardDirectors;
		this.briefWriteup = briefWriteup;
	}

	public Company() {
		super();
		// TODO Auto-generated constructor stub
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

	public List<StockExchange> getStockExchanges() {
		return stockExchanges;
	}
	
	public void addStockExchange(StockExchange stockExchange) {
		this.stockExchanges.add(stockExchange);
	}

	public List<StockPrice> getStockPrices() {
		return stockPrices;
	}
	
	public void addStockPrice(StockPrice stockPrice) {
		this.stockPrices.add(stockPrice);
	}

	public Ipo getIpo() {
		return ipo;
	}

	public void setIpo(Ipo ipo) {
		this.ipo = ipo;
	}

	public Sector getSector() {
		return sector;
	}

	public void setSector(Sector sector) {
		this.sector = sector;
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", turnOver=" + turnOver + ", ceo=" + ceo + ", boardDirectors=" + boardDirectors
				+ ", briefWriteup=" + briefWriteup + ", ipo=" + ipo + "]";
	}
    
}
