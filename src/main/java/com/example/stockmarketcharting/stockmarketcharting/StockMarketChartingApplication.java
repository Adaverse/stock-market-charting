package com.example.stockmarketcharting.stockmarketcharting;

import java.text.SimpleDateFormat;
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
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-YYYY hh:mm:ss");
	
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
		
		StockExchange stockExchange1 = new StockExchange("NSE", "Primary", "8th Street, near New Mall, Bombay", "Very Critical");
		stockExchangeRepository.save(stockExchange1);
		
		StockPrice stockPrice = new StockPrice((float)20.12, sdf.parse("20-02-2012 10:30:00"));
		stockPrice.setStockExchange(stockExchange);
		stockPriceRepository.save(stockPrice);
		
		StockPrice stockPrice1 = new StockPrice((float)20.12, sdf.parse("20-02-2012 10:31:00"));
		stockPrice1.setStockExchange(stockExchange);
		stockPriceRepository.save(stockPrice1);
		
		StockPrice stockPrice2 = new StockPrice((float)20.12, sdf.parse("21-02-2012 10:31:00"));
		stockPrice2.setStockExchange(stockExchange);
		stockPriceRepository.save(stockPrice2);
		
		StockPrice stockPrice3 = new StockPrice((float)20.12, sdf.parse("22-02-2013 10:31:00"));
		stockPrice3.setStockExchange(stockExchange);
		stockPriceRepository.save(stockPrice3);
		
		StockPrice stockPrice4 = new StockPrice((float)20.12, sdf.parse("22-02-2014 10:31:00"));
		stockPrice4.setStockExchange(stockExchange);
		stockPriceRepository.save(stockPrice4);
		
		StockPrice stockPrice5 = new StockPrice((float)20.12, sdf.parse("22-02-2015 10:31:00"));
		stockPrice5.setStockExchange(stockExchange);
		stockPriceRepository.save(stockPrice5);
		
		Ipo ipo = new Ipo((float)10, 100L, "20-2-2013, 9:15 AM", "High valued!");
		Ipo ipo1 = new Ipo((float)100, 200L, "20-2-2021, 10:15 AM", "Mid valued!");
		ipoRepository.save(ipo);
		ipoRepository.save(ipo1);
		
		Company company = new Company("company1", (float)200000000, "Mahesh Singh", "Rahul Bisnoy, Ashu Bisig, Mahesh Singh", "It is working pretty well.", ipo, Arrays.asList(stockExchange), sector);
		companyRepository.save(company);
		
		Company company1 = new Company("company2", (float)200000000, "Mahesh Singh1", "Rahul Bisnoy1, Ashu Bisig1, Mahesh Singh1", "It is working pretty well.1");
		company1.addStockExchange(stockExchange1);
		company1.addStockExchange(stockExchange);
		company1.setSector(sector);
		company1.setIpo(ipo1);
		companyRepository.save(company1);
		
//		stockPrice.setCompany(company);
		
//		ipo.addStockExchange(stockExchange);
//		ipoRepository.save(ipo);
//		the above didn't work
		
		stockExchange.addIpo(ipo);
		stockExchangeRepository.save(stockExchange);
		
		CompanyCode companyCode = new CompanyCode(500101);
		companyCode.setCompany(company);
		companyCode.setStockExchange(stockExchange);
		companyCodeRepository.save(companyCode);
		
		CompanyCode companyCode1 = new CompanyCode(500102);
		companyCode1.setCompany(company1);
		companyCode1.setStockExchange(stockExchange);
		companyCodeRepository.save(companyCode1);
		
		stockPrice5.setCompanyCode(companyCode);
		stockPriceRepository.save(stockPrice5);
		
		stockPrice.setCompanyCode(companyCode);
		stockPriceRepository.save(stockPrice);
		
		stockPrice1.setCompanyCode(companyCode);
		stockPriceRepository.save(stockPrice1);
		
		stockPrice2.setCompanyCode(companyCode1);
		stockPriceRepository.save(stockPrice2);
		
		stockPrice3.setCompanyCode(companyCode);
		stockPriceRepository.save(stockPrice3);
		
		stockPrice4.setCompanyCode(companyCode);
		stockPriceRepository.save(stockPrice4);
	}

}
