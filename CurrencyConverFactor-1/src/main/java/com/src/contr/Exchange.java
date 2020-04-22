package com.src.contr;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;




@Entity
public class Exchange {
	
	
	@Id
	private Long id;
	
	@Column(name="currency-from")
	private String from;
	
	@Column(name="currency-to")
	private String to;
	
	private BigDecimal convertionMultiple;
	private int port;
	
	public Exchange() {
	}


	
	public Exchange(Long id, String from, String to, BigDecimal convertionMultiple,int port) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.convertionMultiple = convertionMultiple;
		this.port=port;
		
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

	public BigDecimal getConverionMultiple() {
		return convertionMultiple;
	}

	public void setConverionMultiple(BigDecimal convertionMultiple) {
		this.convertionMultiple = convertionMultiple;
	}
	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}


		
}
