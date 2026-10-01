package com.www.nit.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class OrderRequest {
	
	@NotBlank(message="customerid is required ")
	private String customerId;
	
	@NotBlank(message="product code is required ")
	private String productCode;
	
	@NotNull(message="quantity is required ")
	@Positive(message="quantity must be greather than 0")
	private Integer quantity;
	
	@NotNull(message="amount is required")
	@Positive(message="amount must be greather than 0")
	private BigDecimal amount;
	
	@NotBlank(message=" status is required")
	private String status;
	
	@NotBlank(message=" createdBy is required")
	private String createdBy;
	
	@NotBlank(message=" updatedBy is required")
	private String updatedBy;
	
	public OrderRequest() {
		super();
	}

	public OrderRequest(@NotBlank(message = "customerid is required ") String customerId,
			@NotBlank(message = "product code is required ") String productCode,
			@NotNull(message = "quantity is required ") @Positive(message = "quantity must be greather than 0") Integer quantity,
			@NotNull(message = "amount is required ") @Positive(message = "amount must be greather than 0") BigDecimal amount,
			@NotBlank(message=" status is required ")String status,
			@NotBlank(message="created is required ")String createdBy,
			@NotBlank(message="updatedBy is required ")String updatedBy)	{
		super();
		this.customerId = customerId;
		this.productCode = productCode;
		this.quantity = quantity;
		this.amount = amount;
		this.status=status;
		this.createdBy=createdBy;
		this.updatedBy=updatedBy;
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


}
