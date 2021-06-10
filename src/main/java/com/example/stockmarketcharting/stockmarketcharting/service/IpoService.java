package com.example.stockmarketcharting.stockmarketcharting.service;

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
	
}
