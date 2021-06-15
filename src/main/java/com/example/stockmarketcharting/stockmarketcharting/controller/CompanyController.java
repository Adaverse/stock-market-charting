package com.example.stockmarketcharting.stockmarketcharting.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.stockmarketcharting.stockmarketcharting.entity.Company;
import com.example.stockmarketcharting.stockmarketcharting.entity.Ipo;
import com.example.stockmarketcharting.stockmarketcharting.response.Response;
import com.example.stockmarketcharting.stockmarketcharting.service.CompanyService;

@RestController
public class CompanyController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	CompanyService service;
	
	@PostMapping("/addCompany")
	public Response addCompany(@RequestBody Company company) {
		boolean uniqueCompanyName = service.isCompanyNameUnique(company.getCompanyName());
		if(!uniqueCompanyName) {
			return new Response(false, "This company already exists!");
		} else {
			return new Response(true, "Successfully saved!");
		}
	}
	
	@PutMapping("/updateCompany")
	public Company updateCompany(@RequestBody Company company) {
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
	
}
