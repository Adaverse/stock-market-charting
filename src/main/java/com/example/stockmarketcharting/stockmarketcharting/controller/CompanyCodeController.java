package com.example.stockmarketcharting.stockmarketcharting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.stockmarketcharting.stockmarketcharting.dto.CompanyCodeDto;
import com.example.stockmarketcharting.stockmarketcharting.entity.CompanyCode;
import com.example.stockmarketcharting.stockmarketcharting.response.Response;
import com.example.stockmarketcharting.stockmarketcharting.service.CompanyCodeService;
import com.example.stockmarketcharting.stockmarketcharting.service.CompanyService;
import com.example.stockmarketcharting.stockmarketcharting.service.StockExchangeService;

@RestController
@CrossOrigin(origins = "*")
public class CompanyCodeController {

	@Autowired
	CompanyCodeService companyCodeService;
	
	@Autowired
	CompanyService companyService;
	
	@Autowired
	StockExchangeService stockExchangeService;
	
	@PostMapping("/addCompanyCode")
	public Response addCompanyCode(@RequestBody List<CompanyCodeDto> companyCodeDtos) {
		for(CompanyCodeDto companyCodeDto : companyCodeDtos) {
			CompanyCode companyCode = new CompanyCode();
			companyCode.setCompanyCode(companyCodeDto.getCompanyCode());
			if(companyService.getCompanyByName(companyCodeDto.getCompanyName()) != null) {
				companyCode.setCompany(companyService.getCompanyByName(companyCodeDto.getCompanyName()));
			} else {
				return new Response(false, "Company doesn't exist!");
			}
			if(stockExchangeService.getByStockExchangeName(companyCodeDto.getStockExchangeName()) != null) {
				companyCode.setStockExchange(stockExchangeService.getByStockExchangeName(companyCodeDto.getStockExchangeName()));
			} else {
				return new Response(false, "Stock Exchange does not exsit!");
			}
		}
		return new Response(true, "Saved!");
	}
	
}
