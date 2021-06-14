package com.example.stockmarketcharting.stockmarketcharting.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.stockmarketcharting.stockmarketcharting.entity.CompanyCode;
import com.example.stockmarketcharting.stockmarketcharting.repository.CompanyCodeRepository;

@Service
public class CompanyCodeService {

	@Autowired
	CompanyCodeRepository repository;
	
	public CompanyCode saveCompanyCode(CompanyCode companyCode) {
		return repository.save(companyCode);
	}
	
	public CompanyCode findByCompanyCode(int companyCode) {
		return repository.findByCompanyCode(companyCode);
	}
	
}
