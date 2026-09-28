package com.www.nit.service;

import java.util.List;

import com.www.nit.dto.OrderRequest;
import com.www.nit.dto.OrderResponse;

public interface IOrderService {
	
	public OrderResponse create(OrderRequest request);
	
	public OrderResponse get(Long id);
	
	public List<OrderResponse> getAll();
	
	public OrderResponse update(Long id,OrderRequest request);
	
	public String delete(Long id);
	
	
	
	

}
