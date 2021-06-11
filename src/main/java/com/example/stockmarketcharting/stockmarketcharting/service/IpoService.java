package com.example.stockmarketcharting.stockmarketcharting.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.stockmarketcharting.stockmarketcharting.entity.Ipo;
import com.example.stockmarketcharting.stockmarketcharting.repository.IpoRespository;

@Service
public class IpoService {

	@Autowired
	IpoRespository repository;
	
	public Ipo saveIpo(Ipo ipo) {
		return repository.save(ipo);
	}
	
	public Ipo updateIpo(Ipo ipo) {
		Ipo existingIpo = repository.findById(ipo.getId()).orElse(null);
		existingIpo.setPricePerShare(ipo.getPricePerShare());
		existingIpo.setTotalShares(ipo.getTotalShares());
		existingIpo.setOpenDateTime(ipo.getOpenDateTime());
		existingIpo.setRemarks(ipo.getRemarks());
		return repository.save(existingIpo);
	}
	
	public List<Ipo> getIpos() {
		return repository.findAll();
	}
	
}
