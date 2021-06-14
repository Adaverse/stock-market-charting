package com.example.stockmarketcharting.stockmarketcharting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.stockmarketcharting.stockmarketcharting.entity.Company;
import com.example.stockmarketcharting.stockmarketcharting.entity.Sector;
import com.example.stockmarketcharting.stockmarketcharting.service.SectorService;

@RestController
public class SectorController {

	@Autowired
	SectorService sectorService;
	
	@GetMapping("/getCompaniesFromSectors/{id}")
	public List<Company> getCompanyList(@PathVariable int id){
		Sector sector = sectorService.findById(id);
		return sector.getCompanies();
	}
}
