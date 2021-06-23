package com.example.stockmarketcharting.stockmarketcharting.dto;

public class IpoDto {

	private float pricePerShare;
	private Long totalShares;
	private String openDateTime;
	private String remarks;
	private String companyName;
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
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public IpoDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
