package com.example.stockmarketcharting.stockmarketcharting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.stockmarketcharting.stockmarketcharting.entity.StockExchange;
import com.example.stockmarketcharting.stockmarketcharting.service.StockExchangeService;

@RestController
public class StockExchangeController {

	@Autowired
	StockExchangeService stockExchangeService;
	
	@PostMapping("/addStockExchange")
	public StockExchange addStockExchange(@RequestBody StockExchange stockExchange) {
		return stockExchangeService.saveStockExchange(stockExchange);
	}
}
