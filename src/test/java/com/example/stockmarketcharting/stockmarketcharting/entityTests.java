package com.example.stockmarketcharting.stockmarketcharting;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.stockmarketcharting.stockmarketcharting.entity.User;
import com.example.stockmarketcharting.stockmarketcharting.entity.Company;
import com.example.stockmarketcharting.stockmarketcharting.repository.CompanyRepository;
import com.example.stockmarketcharting.stockmarketcharting.service.CompanyService;

@SpringBootTest
public class entityTests {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CompanyService companyService;
	
	@Autowired
	CompanyRepository companyRepository;
	
	@Test
	void userEntityTest () {
		logger.info("test passed");
	}
	
	@Test 
	void companyEntityTest () {
		// create a temporary company
		Company company = new Company((float)20, "abc", "abc", "abc");
		companyRepository.save(company);

		Company companyFromService = companyService.findById(company.getId());
		assertEquals(companyFromService.getBoardDirectors(), "abc", "Working");
		
		company.setBoardDirectors("abc, abc");
		companyService.updateCompany(company);
		
		Company companyFromService1 = companyService.findById(company.getId());
		assertEquals(companyFromService1.getBoardDirectors(), "abc, abc", "Working");
		
		int id = companyFromService1.getId();
		companyService.deleteCompany(companyFromService1.getId());
		assertNull(companyService.findById(id));
	}
	
	@Test
	void sectorEntityTest () {
		
	}
}
