package com.src.contr;

import java.math.BigDecimal;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;




@RestController
public class CurrencyEx {
	
	@Autowired
	private Environment environ;

	@GetMapping("/cur-exch/from/{from}/to/{to}")
	public Exchange gets(@PathVariable String from,@PathVariable String to)
	{
		
		//Exchange exch= new Exchange(10L,from,to,BigDecimal.valueOf(65),8080);
		
		Exchange exch= new Exchange();
		
		exch.setId(10L);
		exch.setFrom(from);
		exch.setTo(to);
		//exch.setConvertion(BigDecimal.valueOf(65));
		exch.setConvertion(BigDecimal.valueOf(65));
		
		exch.setPort(Integer.parseInt(environ.getProperty("local.server.port")));
		
		return exch;
	}
	
	//http://localhost:9090/cur/from/USD/to/INR/quant/1000
	//http://localhost:9090/cur/from/FR/to/INR/quant/1000
	//http://localhost:900/cur-exch/from/INR/to/USD
	//http://localhost:8080/h2-console
}
