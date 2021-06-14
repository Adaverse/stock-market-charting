package com.example.stockmarketcharting.stockmarketcharting.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.stockmarketcharting.stockmarketcharting.entity.StockExchange;
import com.example.stockmarketcharting.stockmarketcharting.repository.StockExchangeRepository;

@Service
public class StockExchangeService {

	@Autowired
	StockExchangeRepository repository;
	
	public StockExchange saveStockExchange (StockExchange stockExchange) {
		return repository.save(stockExchange);
	}
	
	public StockExchange getByStockExchangeName (String stockExchangeName) {
		return repository.findByStockExchangeName(stockExchangeName);
	}
	
}
