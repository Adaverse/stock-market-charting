package com.example.stockmarketcharting.stockmarketcharting.response;

public class Response {

	private String status;
	private String detail;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public Response(String status, String detail) {
		super();
		this.status = status;
		this.detail = detail;
	}
	
}
