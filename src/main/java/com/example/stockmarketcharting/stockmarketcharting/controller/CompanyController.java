package com.example.stockmarketcharting.stockmarketcharting.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.stockmarketcharting.stockmarketcharting.dto.CompanyDto;
import com.example.stockmarketcharting.stockmarketcharting.entity.Company;
import com.example.stockmarketcharting.stockmarketcharting.entity.Ipo;
import com.example.stockmarketcharting.stockmarketcharting.entity.StockExchange;
import com.example.stockmarketcharting.stockmarketcharting.entity.StockPrice;
import com.example.stockmarketcharting.stockmarketcharting.response.Response;
import com.example.stockmarketcharting.stockmarketcharting.service.CompanyService;
import com.example.stockmarketcharting.stockmarketcharting.service.IpoService;
import com.example.stockmarketcharting.stockmarketcharting.service.StockExchangeService;

@RestController
@CrossOrigin(origins = "*")
public class CompanyController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	CompanyService service;
	
	@Autowired
	IpoService ipoService;
	
	@Autowired
	StockExchangeService stockExchangeService;
	
	@PostMapping("/addCompany")
	public Response addCompany(@RequestBody CompanyDto companyDto) {
		boolean uniqueCompanyName = service.isCompanyNameUnique(companyDto.getCompanyName());
		logger.info(companyDto.toString());
		logger.info(Integer.toString(companyDto.getStockExchangeNames().size()));
		if(!uniqueCompanyName) {
			return new Response(false, "This company already exists!");
		} else {
			Company company = new Company();
			company.setBoardDirectors(companyDto.getBoardDirectors());
			company.setBriefWriteup(companyDto.getBriefWriteup());
			company.setCeo(companyDto.getCeo());
			company.setCompanyName(companyDto.getCompanyName());
			company.setTurnOver(companyDto.getTurnOver());
			List<StockExchange> stockExchanges = new ArrayList<>();
			for (StockExchange stockExchange : company.getStockExchanges()) {
				
				if(stockExchangeService.getByStockExchangeName(stockExchange.getStockExchangeName()) != null) {
					stockExchanges.add(stockExchange);
				}
			}
			company.setStockExchange(stockExchanges);
			service.saveCompany(company);
			return new Response(true, "Successfully saved!");
		}
	}
	
	@PutMapping("/updateCompany")
	public Company updateCompany(@RequestBody Company company) {
		logger.info("this is the updatedCompany ***********************");
		logger.info(company.toString());
		return service.updateCompany(company);
	}
	
	@GetMapping("/getCompany/{id}")
	public Company getCompany(@PathVariable int id) {
		return service.findById(id);
	}
	
	@GetMapping("/getIpoFromCompany/{id}")
	public Ipo getIpoFromCompany(@PathVariable int id) {
		Company company = service.findById(id);
		return company.getIpo();
	}	
	
	@GetMapping("/searchCompany/{searchString}")
	public List<Company> searchCompany(@PathVariable String searchString) {
		return service.searchCompany(searchString);
	}
	
	@GetMapping("/companies")
	public List<Company> getCompanies() {
		return service.getCompanies();
	}
	
	@GetMapping("/getStockExchangesFromCompany/{id}")
	public List<StockExchange> getStockExchangesFromCompany(@PathVariable int id){
		Company company = service.findById(id);
		return company.getStockExchanges();
	}
	
}
