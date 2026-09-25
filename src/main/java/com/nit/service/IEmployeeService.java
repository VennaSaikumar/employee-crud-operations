package com.nit.service;

import java.util.List;

import com.nit.dto.EmployeeRequest;
import com.nit.dto.EmployeeResponse;

public interface IEmployeeService {
	
	public EmployeeResponse create(EmployeeRequest request); 
	
	public EmployeeResponse get(Integer id); 
	
	public List<EmployeeResponse> getAll();
	
	public EmployeeResponse update(Integer id,EmployeeRequest request);
	
	public void delete(Integer id);

}
