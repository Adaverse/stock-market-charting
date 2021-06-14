package com.example.stockmarketcharting.stockmarketcharting.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.stockmarketcharting.stockmarketcharting.entity.Ipo;
import com.example.stockmarketcharting.stockmarketcharting.response.Response;
import com.example.stockmarketcharting.stockmarketcharting.service.IpoService;

@RestController
public class IpoController {

	@Autowired
	IpoService service;
	
	@PostMapping("/addIpo")
	public Response addIpo(@RequestBody Ipo ipo) {
	    HashMap<String, String> map = new HashMap<>();
	    
	    return new Response(true, "ok");
//		return service.saveIpo(ipo);
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
