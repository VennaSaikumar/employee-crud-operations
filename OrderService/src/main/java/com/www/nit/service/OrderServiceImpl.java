package com.www.nit.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.www.nit.dto.OrderRequest;
import com.www.nit.dto.OrderResponse;
import com.www.nit.entity.OrderEntity;
import com.www.nit.exception.OrderNotFoundException;
import com.www.nit.repository.OrderRepository;

@Service
public class OrderServiceImpl implements IOrderService {
	
	private final OrderRepository orderRepo;
		
	  public OrderServiceImpl(OrderRepository orderRepo) {
	  super();
	  this.orderRepo=orderRepo; }
	 
	@Override
	public OrderResponse create(OrderRequest request) {
		OrderEntity order=new OrderEntity();
		order.setCustomerId(request.getCustomerId());
		order.setProductCode(request.getProductCode());
		order.setQuantity(request.getQuantity());
		order.setAmount(request.getAmount());
		order.setStatus(request.getStatus());
		order.setCreatedBy(request.getCreatedBy());
		order.setUpdatedBy(request.getUpdatedBy());
		System.out.println("BEFORE SAVE");

		OrderEntity entity = orderRepo.save(order);

		System.out.println("AFTER SAVE");
		return toResponse(entity);
	}
	
	@Override
	public OrderResponse get(Long id) {
		Optional<OrderEntity> orders = orderRepo.findById(id);
		if(orders.isPresent()) {
			OrderEntity entity=  orders.get();
			return toResponse(entity);
		}
		throw new OrderNotFoundException("Order id is not found , id is "+id);
			}
	
	@Override
	public List<OrderResponse> getAll() {
		List<OrderEntity> listofOrders = orderRepo.findAll();
		List<OrderResponse> responses = new ArrayList<>();
		for (OrderEntity orderEntity : listofOrders) {
			OrderResponse response = toResponse(orderEntity);
			responses.add(response);
			}
		return responses;
	}
	
	@Override
	public OrderResponse update(Long id, OrderRequest request) {
		Optional<OrderEntity> response = orderRepo.findById(id);
			if(response.isPresent()) {
		OrderEntity order = response.get();
		
		order.setCustomerId(request.getCustomerId());
		order.setProductCode(request.getProductCode());
		order.setQuantity(request.getQuantity());
		order.setAmount(request.getAmount());
		order.setStatus(request.getStatus());
		order.setCreatedBy(request.getCreatedBy());
		order.setUpdatedBy(request.getUpdatedBy());

		OrderEntity entity = orderRepo.save(order);

		return toResponse(entity);
			}
		throw new OrderNotFoundException(
				"Order id is not found id is "+id);
			
	}
	
	@Override
	public String delete(Long id) {
		if(!orderRepo.existsById(id)) {
			throw new OrderNotFoundException("Order id is not found id is "+id);
		}
		orderRepo.deleteById(id);
		return "order deleted with id "+ id;
}
	
	public OrderResponse toResponse(OrderEntity response) {
		return new OrderResponse(response.getId(),
				response.getCustomerId(),
				response.getProductCode(),
				response.getQuantity(),
		response.getAmount(),
		response.getStatus(),
		response.getCreatedBy(),
			response.getUpdatedBy(),
			response.getCreatedAt(),
			response.getUpdatedAt()
			);
	}

}
