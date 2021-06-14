package com.example.stockmarketcharting.stockmarketcharting.repositoryTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.stockmarketcharting.stockmarketcharting.entity.Company;
import com.example.stockmarketcharting.stockmarketcharting.repository.CompanyRepository;
import com.example.stockmarketcharting.stockmarketcharting.service.CompanyService;

@DataJpaTest
public class CompanyRepositoryTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CompanyRepository companyRepository;
	
	@Test 
	void companyRespositoryTest () {
		// create a temporary company
		Company company = new Company("TestCompany", (float)20, "abc", "abc", "abc");
		companyRepository.save(company);
		
		assertNotNull(company);
		assertTrue(company.getId() > 0);
	}
	
	@Test
	void sectorEntityTest () {
		
	}
}
