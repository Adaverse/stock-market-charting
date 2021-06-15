package com.example.stockmarketcharting.stockmarketcharting.service;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.stockmarketcharting.stockmarketcharting.entity.StockPrice;
import com.example.stockmarketcharting.stockmarketcharting.repository.StockPriceRepository;

@Service
public class StockPriceService {
	
	@Autowired
	StockPriceRepository repository;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public StockPrice saveStockPrice(StockPrice stockPrice) {
		return repository.save(stockPrice);
	}
	
	public List<StockPrice> getStockPriceByDates(Date from, Date to, int companyCodeId){
		List<StockPrice> stockPrice = repository.getStockPriceByDates(from, to, companyCodeId);
		for(StockPrice s : stockPrice) {
			logger.info("****************************loggin****************************");
			logger.info(s.toString());
		}
		return repository.getStockPriceByDates(from, to, companyCodeId);
	}
	
}
