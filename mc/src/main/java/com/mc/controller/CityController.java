package com.mc.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mc.service.CityService;

@RestController
public class CityController {
	
	@Autowired
	CityService cityService;
	
	@RequestMapping(value = "/connected", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
	public String isConnected(@RequestParam String origin, @RequestParam String destination) {
		
		return cityService.isconnected(origin, destination);
	}
	
}
