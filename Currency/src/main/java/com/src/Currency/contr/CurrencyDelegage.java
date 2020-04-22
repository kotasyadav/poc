package com.src.Currency.contr;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import com.src.Currency.model.CurrencyConvertBean;

@Service
public class CurrencyDelegage {
	
	
	
	@HystrixCommand(fallbackMethod = "callStudentServiceAndGetData_Fallback")
	public static CurrencyConvertBean callStudentServiceAndGetData(String from,String to,BigDecimal quat)
	{
		
      Map<String,String> uriVaraible=new HashMap<String,String>();
		
		uriVaraible.put("from",from);
		uriVaraible.put("to",to);
		
		
		
		ResponseEntity<CurrencyConvertBean> respEntity=new
				 RestTemplate().getForEntity(
				 "http://localhost:902/cur-exch/from/{from}/to/{to}",
				  CurrencyConvertBean.class,uriVaraible);
				  
				  CurrencyConvertBean response=respEntity.getBody();
				  
				  System.out.println("=======1=========="+response.getId());
				  System.out.println("=======1=========="+response.getFrom());
				  System.out.println("=======1=========="+response.getTo());
				  System.out.println("=======1=========="+response.getConvertion());
				  //System.out.println("=======1=========="+response.g));
				  
				  System.out.println("=======1=========="+response.getQuantity());
				  
				  
				  //return new CurrencyConvertBean(1L,from,to,BigDecimal.ONE,quat,quat,0);
				  
				  return new CurrencyConvertBean(response.getId(),from,to,response.getConvertion(),quat,response.getConvertion().multiply(quat),response.getPort());
			
		
	}
	 
	  @SuppressWarnings("unused")
	    public  String callStudentServiceAndGetData_Fallback() {
	 
	        System.out.println("Student Service is down!!! fallback route enabled...");
	 
	        return "CIRCUIT BREAKER ENABLED!!! No Response From Student Service at this moment. " +
	                    " Service will be back shortly - " + new Date();
	    }

}
