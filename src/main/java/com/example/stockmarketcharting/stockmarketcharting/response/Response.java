package com.example.stockmarketcharting.stockmarketcharting.response;

public class Response {

	private boolean status;
	private String detail;
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public Response(boolean status, String detail) {
		super();
		this.status = status;
		this.detail = detail;
	}
	
}
