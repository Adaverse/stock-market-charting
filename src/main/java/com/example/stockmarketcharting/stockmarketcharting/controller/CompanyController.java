package com.example.stockmarketcharting.stockmarketcharting.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.stockmarketcharting.stockmarketcharting.entity.Company;
import com.example.stockmarketcharting.stockmarketcharting.service.CompanyService;

@RestController
public class CompanyController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	CompanyService service;
	
	@PostMapping("/addCompany")
	public Company addCompany(@RequestBody Company company) {
		return service.saveCompany(company);
	}
	
	@PutMapping("/updateCompany")
	public Company updateCompany(@RequestBody Company company) {
		return service.updateCompany(company);
	}
	
}
