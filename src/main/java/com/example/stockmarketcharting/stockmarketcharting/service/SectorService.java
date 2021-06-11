package com.example.stockmarketcharting.stockmarketcharting.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.stockmarketcharting.stockmarketcharting.repository.SectorRepository;
import com.example.stockmarketcharting.stockmarketcharting.entity.Sector;

public class SectorService {

	@Autowired
	SectorRepository repository;
	
	public Sector saveSector(Sector sector) {
		return repository.save(sector);
	}	
	
	public List<Sector> getSectors() {
		return repository.findAll();
	}
	
	public Sector findById(int id) {
		return repository.findById(id).orElse(null);
	}
	
}
