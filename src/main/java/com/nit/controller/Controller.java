package com.nit.controller;

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

import com.nit.dto.EmployeeRequest;
import com.nit.dto.EmployeeResponse;
import com.nit.service.IEmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/employees")
public class Controller {
	
	private final IEmployeeService employeeService;

	public Controller(IEmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	@PostMapping
	public ResponseEntity<EmployeeResponse> save(@Valid @RequestBody EmployeeRequest request) {
		
		EmployeeResponse response= employeeService.create(request);
		return ResponseEntity.ok(response);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<EmployeeResponse> get(@PathVariable Integer id){
		EmployeeResponse response= employeeService.get(id);
		return ResponseEntity.ok(response);
		
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<EmployeeResponse>> getAll(){
		List<EmployeeResponse> response= employeeService.getAll();
		return ResponseEntity.ok(response);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<EmployeeResponse> save(@PathVariable Integer id,@Valid @RequestBody EmployeeRequest request) {
		EmployeeResponse response= employeeService.update(id,request);
		return ResponseEntity.ok(response);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		employeeService.delete(id);
	}
}
