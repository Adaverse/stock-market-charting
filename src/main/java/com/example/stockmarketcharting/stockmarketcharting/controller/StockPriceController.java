package com.example.stockmarketcharting.stockmarketcharting.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.stockmarketcharting.stockmarketcharting.entity.Company;
import com.example.stockmarketcharting.stockmarketcharting.entity.CompanyCode;
import com.example.stockmarketcharting.stockmarketcharting.entity.StockExchange;
import com.example.stockmarketcharting.stockmarketcharting.entity.StockPrice;
import com.example.stockmarketcharting.stockmarketcharting.service.CompanyCodeService;
import com.example.stockmarketcharting.stockmarketcharting.service.StockExchangeService;
import com.example.stockmarketcharting.stockmarketcharting.service.StockPriceService;

@RestController
@CrossOrigin(origins = "*")
public class StockPriceController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	StockPriceService stockPriceService;
	
	@Autowired
	CompanyCodeService companyCodeService;
	
	@Autowired
	StockExchangeService stockExchangeService;
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-YYYY");
	
	@PostMapping("/addStockPrice")
	public String addStockPrice(@RequestBody List<StockPrice> stockPrice) {
		int _companyCode;
//		 CompanyCode companyCode;
//		StockExchange stockExchange;
		for(StockPrice _stockPrice : stockPrice) {
			_companyCode = _stockPrice.getCompanyCode().getCompanyCode();
			CompanyCode companyCode = companyCodeService.findByCompanyCode(_companyCode);
			_stockPrice.setCompanyCode(companyCode);
			StockExchange stockExchange = stockExchangeService.getByStockExchangeName(_stockPrice.getStockExchange().getStockExchangeName());
			_stockPrice.setStockExchange(stockExchange);
			stockPriceService.saveStockPrice(_stockPrice);
		}
		return "Saved";
	}
	
	@GetMapping("/getCompanyStockPrice/{companyCode}/{from}/{to}")
	public List<StockPrice> getCompanyStockPrice(@PathVariable int companyCode, @PathVariable String from, @PathVariable String to) throws ParseException{
		Date _from = sdf.parse(from);
		Date _to = sdf.parse(to);
		CompanyCode _companyCode = companyCodeService.findByCompanyCode(companyCode);
		return stockPriceService.getStockPriceByDates(_from, _to, _companyCode.getId());
	}
}
