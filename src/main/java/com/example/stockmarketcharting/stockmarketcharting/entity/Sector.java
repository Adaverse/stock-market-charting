package com.example.stockmarketcharting.stockmarketcharting.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Sector {

	@Id
	@GeneratedValue
	private int id;

	@Column(nullable = false, unique = true)
    private String sectorName;
    
    @Column(nullable = false)
    private String brief;
    
    @OneToOne(mappedBy = "sector", fetch=FetchType.LAZY)
    private Company company;
    
    public String getSectorName() {
		return sectorName;
	}

	public void setSectorName(String sectorName) {
		this.sectorName = sectorName;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public int getId() {
		return id;
	}

	@JsonManagedReference
	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Sector(String sectorName, String brief) {
		super();
		this.sectorName = sectorName;
		this.brief = brief;
	}

	public Sector(String sectorName, String brief, Company company) {
		super();
		this.sectorName = sectorName;
		this.brief = brief;
		this.company = company;
	}

	public Sector() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Sector [id=" + id + ", sectorName=" + sectorName + ", brief=" + brief + "]";
	}
}
