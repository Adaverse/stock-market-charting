package com.example.stockmarketcharting.stockmarketcharting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.stockmarketcharting.stockmarketcharting.entity.Company;
import com.example.stockmarketcharting.stockmarketcharting.entity.Sector;
import com.example.stockmarketcharting.stockmarketcharting.response.Response;
import com.example.stockmarketcharting.stockmarketcharting.service.SectorService;

@RestController
@CrossOrigin(origins = "*")
public class SectorController {

	@Autowired
	SectorService sectorService;
	
	@GetMapping("/getCompaniesFromSectors/{id}")
	public List<Company> getCompanyList(@PathVariable int id){
		Sector sector = sectorService.findById(id);
		return sector.getCompanies();
	}
	
	@PostMapping("/addSector")
	public Response addSector(@RequestBody Sector sector) {
		Sector _sector = sectorService.saveSector(sector);
		if(_sector != null) {
			return new Response(true, "Sector saved!");
		} else {
			return new Response(false, "We ran into some problem!");
		}
	}
	
	@GetMapping("/getSectors")
	public List<Sector> getSector() {
		return sectorService.getSectors();
	}
}
