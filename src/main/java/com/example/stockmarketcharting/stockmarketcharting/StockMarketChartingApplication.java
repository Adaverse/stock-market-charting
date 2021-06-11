package com.example.stockmarketcharting.stockmarketcharting;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.stockmarketcharting.stockmarketcharting.entity.Ipo;
import com.example.stockmarketcharting.stockmarketcharting.entity.Sector;
import com.example.stockmarketcharting.stockmarketcharting.entity.StockExchange;
import com.example.stockmarketcharting.stockmarketcharting.entity.StockPrice;
import com.example.stockmarketcharting.stockmarketcharting.entity.Company;
import com.example.stockmarketcharting.stockmarketcharting.entity.CompanyCode;
import com.example.stockmarketcharting.stockmarketcharting.repository.CompanyCodeRepository;
import com.example.stockmarketcharting.stockmarketcharting.repository.CompanyRepository;
import com.example.stockmarketcharting.stockmarketcharting.repository.IpoRespository;
import com.example.stockmarketcharting.stockmarketcharting.repository.SectorRepository;
import com.example.stockmarketcharting.stockmarketcharting.repository.StockExchangeRepository;
import com.example.stockmarketcharting.stockmarketcharting.repository.StockPriceRepository;


@SpringBootApplication
public class StockMarketChartingApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	SectorRepository sectorRespository;
	
	@Autowired
	StockPriceRepository stockPriceRepository;
	
	@Autowired
	StockExchangeRepository stockExchangeRepository;
	
	@Autowired
	IpoRespository ipoRepository;
	
	@Autowired
	CompanyRepository companyRepository;
	
	@Autowired
	CompanyCodeRepository companyCodeRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(StockMarketChartingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Sector sector = new Sector("Heath Sector", "It takes care of the problems");
		sectorRespository.save(sector);
		
		StockExchange stockExchange = new StockExchange("BSE", "Primary", "7th Street, near New Mall, Bombay", "Very Important");
		stockExchangeRepository.save(stockExchange);
		
		StockPrice stockPrice = new StockPrice((float)20.12, "20-2-12", "8:13 AM");
		stockPrice.setStockExchange(stockExchange);
		stockPriceRepository.save(stockPrice);
		
		Ipo ipo = new Ipo((float)10, 100L, "20-2-2013, 9:15 AM", "High valued!");
		ipoRepository.save(ipo);
		
		Company company = new Company((float)200000000, "Mahesh Singh", "Rahul Bisnoy, Ashu Bisig, Mahesh Singh", "It is working pretty well.", ipo, Arrays.asList(stockExchange), Arrays.asList(stockPrice), sector);
		companyRepository.save(company);
		
		stockPrice.setCompany(company);
		stockPriceRepository.save(stockPrice);
		
//		ipo.addStockExchange(stockExchange);
//		ipoRepository.save(ipo);
//		the above didn't work
		
		stockExchange.addIpo(ipo);
		stockExchangeRepository.save(stockExchange);
		
		CompanyCode companyCode = new CompanyCode(500101);
		companyCode.setCompany(company);
		companyCode.setStockExchange(stockExchange);
		companyCodeRepository.save(companyCode);
	}

}
