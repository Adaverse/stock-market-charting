package com.example.stockmarketcharting.stockmarketcharting.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.stockmarketcharting.stockmarketcharting.repository.SectorRepository;
import com.example.stockmarketcharting.stockmarketcharting.entity.Sector;

public class SectorService {

	@Autowired
	SectorRepository repository;
	
	public Sector saveProduct(Sector sector) {
		return repository.save(sector);
	}	
	
}
