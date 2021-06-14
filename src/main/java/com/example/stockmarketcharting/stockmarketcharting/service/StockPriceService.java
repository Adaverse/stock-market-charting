package com.example.stockmarketcharting.stockmarketcharting.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.stockmarketcharting.stockmarketcharting.entity.StockPrice;
import com.example.stockmarketcharting.stockmarketcharting.repository.StockPriceRepository;

@Service
public class StockPriceService {
	
	@Autowired
	StockPriceRepository repository;

	public StockPrice saveStockPrice(StockPrice stockPrice) {
		return repository.save(stockPrice);
	}
	
}
