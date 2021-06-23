package com.example.stockmarketcharting.stockmarketcharting.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.stockmarketcharting.stockmarketcharting.dto.IpoDto;
import com.example.stockmarketcharting.stockmarketcharting.entity.Company;
import com.example.stockmarketcharting.stockmarketcharting.entity.Ipo;
import com.example.stockmarketcharting.stockmarketcharting.response.Response;
import com.example.stockmarketcharting.stockmarketcharting.service.CompanyService;
import com.example.stockmarketcharting.stockmarketcharting.service.IpoService;

@RestController
@CrossOrigin(origins = "*")
public class IpoController {

	@Autowired
	IpoService service;
	
	@Autowired 
	CompanyService companyService;
	
	@PostMapping("/addIpo")
	public Response addIpo(@RequestBody IpoDto ipoDto) {
		Ipo ipo = new Ipo();
		ipo.setTotalShares(ipoDto.getTotalShares());
		ipo.setOpenDateTime(ipoDto.getOpenDateTime());
		ipo.setRemarks(ipoDto.getRemarks());
		ipo.setPricePerShare(ipoDto.getPricePerShare());
		Company company = companyService.getCompanyByName(ipoDto.getCompanyName());
		if(company != null) {
//			ipo.setCompany(company);
			service.saveIpo(ipo);
			company.setIpo(ipo);
			companyService.saveCompany(company);
			return new Response(true, "Ipo Saved!");
		} else {
			return new Response(false, "No Such Company!");
		}
	}
	
	@PutMapping("/updateIpo")
	public Ipo updateIpo(@RequestBody Ipo ipo) {
		return service.updateIpo(ipo);
	}
	
	@GetMapping("/ipos")
	public List<Ipo> getIpos(){
		return service.getIpos();
	}
}
