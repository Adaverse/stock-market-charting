package com.example.stockmarketcharting.stockmarketcharting.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	@GeneratedValue
	private int id;
	
    @Column(nullable = false, unique = true)
    private String email;
    
    @Column(nullable = false, unique = true)
    private String username;
    
	@Column(nullable = false)
    private String password;
	
	@Column(nullable = false, unique = true, length=10)
    private Long mobileNumber;
    
	@Column(nullable = false)
    private boolean confirmed;
	
	@Column(nullable = false)
    private boolean isAdmin;
    
    public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
    
    public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String email, String username, String password, Long mobileNumber, boolean confirmed) {
		super();
		this.email = email;
		this.username = username;
		this.password = password;
		this.mobileNumber = mobileNumber;
		this.confirmed = confirmed;
	}

	public User(int id, String email, String username, String password, Long mobileNumber, boolean confirmed,
			boolean isAdmin) {
		super();
		this.id = id;
		this.email = email;
		this.username = username;
		this.password = password;
		this.mobileNumber = mobileNumber;
		this.confirmed = confirmed;
		this.isAdmin = isAdmin;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", username=" + username + ", password=" + password
				+ ", mobileNumber=" + mobileNumber + ", confirmed=" + confirmed + ", isAdmin=" + isAdmin + "]";
	}
    
    public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public boolean isConfirmed() {
		return confirmed;
	}

	public void setConfirmed(boolean confirmed) {
		this.confirmed = confirmed;
	}

	public int getId() {
		return id;
	}
}
