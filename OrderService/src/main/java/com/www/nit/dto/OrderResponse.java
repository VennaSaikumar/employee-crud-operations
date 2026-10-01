package com.www.nit.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class OrderResponse {

	private long id;
	
	private String customerId;
	
	private String productCode;
	
	private Integer quantity;
	
	private BigDecimal amount;
	
	private String status;
	
	private String createdBy;
	
	private String updatedBy;
	
	private Timestamp createdAt;
	
	private Timestamp updatedAt;
	
	public OrderResponse() {
		super();
	}
	
	public OrderResponse(Long id,String customerId,String productCode,Integer quantity,
			BigDecimal amount,String status,String createdBy,String updatedBy,
				Timestamp createdAt,Timestamp updatedAt) {
		this.id=id;
		this.customerId=customerId;
		this.productCode=productCode;
		this.quantity=quantity;
		this.amount=amount;
		this.status=status;
		this.createdBy=createdBy;
		this.updatedBy=updatedBy;
		this.createdAt=createdAt;
		this.updatedAt=updatedAt;
		
	}
	public Long getId() {
		return id;
		
	}
	
	public String getCustomerId() {
		return customerId;
	}
	
	public String getProductCode() {
		return productCode;
	}
	
	public Integer getQuantity() {
		return quantity;
		
	}
	
	public BigDecimal getAmount() {
		return amount;
	}
	
	public String getStatus() {
		return status;
	}
	
	public String getCreatedBy() {
		return createdBy;
	}
	
	public String getUpdatedBy() {
		return updatedBy;
		
	}
	
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	
	public Timestamp getUpdatedAt() {
		return updatedAt;
	}
}
