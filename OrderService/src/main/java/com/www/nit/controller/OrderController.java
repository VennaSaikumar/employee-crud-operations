package com.www.nit.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.www.nit.dto.OrderRequest;
import com.www.nit.dto.OrderResponse;
import com.www.nit.service.IOrderService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {
	
	private final IOrderService orderService;
	
	public OrderController(IOrderService orderService) {
		this.orderService= orderService;
	}
	
	@PostMapping()
	public ResponseEntity<OrderResponse>save(@Valid @RequestBody OrderRequest request){
		OrderResponse response= orderService.create(request);
		return ResponseEntity.ok(response);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<OrderResponse> get(@Valid @PathVariable Long id){
		OrderResponse response= orderService.get(id);
		return ResponseEntity.ok(response);
		
	}
	
	@GetMapping("/all")
	public ResponseEntity <List<OrderResponse>> getAll(){
		List<OrderResponse> response= orderService.getAll();
		return ResponseEntity.ok(response);
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<OrderResponse>update(@Valid @PathVariable Long id, 
				@RequestBody OrderRequest request){
		OrderResponse response= orderService.update(id,request);
		return ResponseEntity.ok(response);
	}
	
	@DeleteMapping("/{id}")
	public String delete(@Valid @PathVariable Long id){
		String message=orderService.delete(id);
		return message;
	}

}
