package com.example.stockmarketcharting.stockmarketcharting.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.stockmarketcharting.stockmarketcharting.entity.Company;
import com.example.stockmarketcharting.stockmarketcharting.repository.CompanyRepository;

@Service
public class CompanyService {

	@Autowired
	CompanyRepository repository;
	
	public Company saveCompany(Company company) {
		return repository.save(company);
	}

	public Company updateCompany(Company company) {
		Company existingCompany = repository.findById(company.getId()).orElse(null);
		existingCompany.setTurnOver(company.getTurnOver());
		existingCompany.setCeo(company.getCeo());
		existingCompany.setBoardDirectors(company.getBoardDirectors());
		existingCompany.setSector(company.getSector());
		existingCompany.setBriefWriteup(company.getBriefWriteup());
		return repository.save(existingCompany);
	}
	
	public void deleteCompany(int id) {
		repository.deleteById(id);
	}
}
