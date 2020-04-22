package com.src.Currency.contr;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.src.Currency.model.CurrencyConvertBean;

@RestController
public class Currency {
	
	@Autowired
	private CurrencyExchangeServiceProxy proxy;

	@GetMapping("/cur/from/{from}/to/{to}/quant/{quat}")
	public CurrencyConvertBean gets(@PathVariable String from,@PathVariable String to,@PathVariable BigDecimal quat)
	{
		Map<String,String> uriVaraible=new HashMap<String,String>();
		
		uriVaraible.put("from",from);
		uriVaraible.put("to",to);
		
		
		
		
		 System.out.println("Going to call student service to get data!");
	        return CurrencyDelegage.callStudentServiceAndGetData(from,to,quat);
		
		/*
		 * ResponseEntity<CurrencyConvertBean> respEntity=new
		 * RestTemplate().getForEntity(
		 * "http://localhost:902/cur-exch/from/{from}/to/{to}",
		 * CurrencyConvertBean.class,uriVaraible);
		 * 
		 * CurrencyConvertBean response=respEntity.getBody();
		 * 
		 * System.out.println("=======1=========="+response.getId());
		 * System.out.println("=======1=========="+response.getFrom());
		 * System.out.println("=======1=========="+response.getTo());
		 * System.out.println("=======1=========="+response.getConvertion());
		 * //System.out.println("=======1=========="+response.g));
		 * 
		 * System.out.println("=======1=========="+response.getQuantity());
		 * 
		 * 
		 * //return new CurrencyConvertBean(1L,from,to,BigDecimal.ONE,quat,quat,0);
		 * 
		 * return new
		 * CurrencyConvertBean(response.getId(),from,to,response.getConvertion(),quat,
		 * response.getConvertion().multiply(quat),response.getPort());
		 */	}
	
	
	@GetMapping("/fault")
	@HystrixCommand(fallbackMethod = "callStudentServiceAndGetData_Fallback")
	public CurrencyConvertBean gets()
	{
		throw new RuntimeException("No Data avaiable");
	
	}
	
	@SuppressWarnings("unused")
    public  CurrencyConvertBean callStudentServiceAndGetData_Fallback() {
 
        System.out.println("Student Service is down!!! fallback route enabled...");
 
        return new CurrencyConvertBean();
    }

	
	
	@GetMapping("/cur-feign/from/{from}/to/{to}/quant/{quat}")
	public CurrencyConvertBean getser(@PathVariable String from,@PathVariable String to,@PathVariable BigDecimal quat)
	{
		
	
		CurrencyConvertBean response=proxy.retrieveExchangeValue(from, to);
		
	System.out.println("=======1=========="+response.getId());
	System.out.println("=======1=========="+response.getFrom());
	System.out.println("=======1=========="+response.getTo());
	System.out.println("=======1=========="+response.getConvertion());
	System.out.println("=======1=========="+response.getTotalCalculatedAmount());
	System.out.println("=======1=========="+response.getPort());
	//System.out.println("=======1=========="+response.g));
	
	
		//BigDecimal total=response.getConvertion().multiply(quat);
		
		//return new CurrencyConvertBean(1L,from,to,BigDecimal.ONE,quat,quat,0);
	
	return new CurrencyConvertBean(response.getId(),from,to,response.getConvertion(),quat,response.getConvertion().multiply(quat),response.getPort());
	}
	
	
	//http://localhost:9090/cur/from/USD/to/INR/quant/1000
	//http://localhost:9090/cur/from/FR/to/INR/quant/1000
	
	//final url:http://localhost:900/cur-exch/from/INR/to/USD
	
	//http://localhost:9090/cur/from/USD/to/INR/quant/1000
	
	//http://localhost:9090/cur-feign/from/USD/to/INR/quant/1000
}
