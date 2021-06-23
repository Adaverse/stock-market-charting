package com.example.stockmarketcharting.stockmarketcharting.dto;

import java.util.List;

public class CompanyDto {

	String companyName;
	String ceo;
	float turnOver;
	String boardDirectors;
	String briefWriteup;
	List<String> stockExchangeNames;
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCeo() {
		return ceo;
	}
	public void setCeo(String ceo) {
		this.ceo = ceo;
	}
	public float getTurnOver() { 
		return turnOver;
	}
	public void setTurnOver(float turnOver) {
		this.turnOver = turnOver;
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
	public List<String> getStockExchangeNames() {
		return stockExchangeNames;
	}
	public void setStockExchangeNames(List<String> stockExchangeNames) {
		this.stockExchangeNames = stockExchangeNames;
	}
	public CompanyDto(String companyName, String ceo, float turnOver, String boardDirectors, String briefWriteup,
			List<String> stockExchangeNames) {
		super();
		this.companyName = companyName;
		this.ceo = ceo;
		this.turnOver = turnOver;
		this.boardDirectors = boardDirectors;
		this.briefWriteup = briefWriteup;
		this.stockExchangeNames = stockExchangeNames;
	}
	@Override
	public String toString() {
		return "companyDto [companyName=" + companyName + ", ceo=" + ceo + ", turnOver=" + turnOver
				+ ", boardDirectors=" + boardDirectors + ", briefWriteup=" + briefWriteup + ", stockExchangeNames="
				+ stockExchangeNames + "]";
	}
}
