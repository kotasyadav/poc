package com.src.Currency.model;

import java.math.BigDecimal;

public class CurrencyConvertBean {
	
	
	private Long id;
	private String from;
	private String to;
	//private BigDecimal convertionMultiple;
	private BigDecimal convertion;
	
	private BigDecimal quantity;
	private BigDecimal totalCalculatedAmount;
	private int port;
	
	
	public CurrencyConvertBean() {
	}

	public CurrencyConvertBean(Long id, String from, String to, BigDecimal convertion, BigDecimal quantity,
			BigDecimal totalCalculatedAmount, int port) {
		//super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.convertion = convertion;
		this.quantity = quantity;
		this.totalCalculatedAmount = totalCalculatedAmount;
		this.port = port;
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}
	
	public BigDecimal getConvertion() {
		return convertion;
	}

	public void setConvertion(BigDecimal convertion) {
		this.convertion = convertion;
	}


	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getTotalCalculatedAmount() {
		return totalCalculatedAmount;
	}

	public void setTotalCalculatedAmount(BigDecimal totalCalculatedAmount) {
		this.totalCalculatedAmount = totalCalculatedAmount;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	
	
	

}
