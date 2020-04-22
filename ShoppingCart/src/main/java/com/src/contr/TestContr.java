package com.src.contr;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestContr {
	
	
	@GetMapping("/Test")
	public String getHello()
	{
		
		return "hello";
	}

}
