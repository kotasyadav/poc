package com.src.Currency.contr;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.src.Currency.model.CurrencyConvertBean;

//@FeignClient(name="curency-exchange-service", url="localhost:900")
//@FeignClient(name="curency-exchange-service",url="localhost:902")
@FeignClient(name="curency-exchange-service")
@RibbonClient(name="curency-exchange-service")
public interface CurrencyExchangeServiceProxy {
	
	@GetMapping("/cur-exch/from/{from}/to/{to}/")
	public CurrencyConvertBean retrieveExchangeValue(@PathVariable("from") String from,@PathVariable("to") String to);

}
