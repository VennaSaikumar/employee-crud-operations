package com.nit.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.nit.dto.EmployeeRequest;
import com.nit.dto.EmployeeResponse;
import com.nit.entity.Employees;
import com.nit.exception.EmployeeNotFoundException;
import com.nit.repository.IEmployeeRepository;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	private final IEmployeeRepository employeeRepository;

	public EmployeeServiceImpl(IEmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	@Override
	public EmployeeResponse create(EmployeeRequest request) {
		Employees employees =new Employees();
		employees.setName(request.getName());
	    employees.setEmail(request.getEmail());
	    employees.setSalary(request.getSalary());
	    employees.setDepartment(request.getDepartment());
		return toResponse(employees);
	}

	@Override
	public EmployeeResponse get(Integer id) {
		Optional<Employees> optional = employeeRepository.findById(id);
		if (optional.isPresent()) {
			Employees response = optional.get();
			return toResponse(response);
		}
		else
		 throw new EmployeeNotFoundException("Employee not found with id: " + id);
	}

	@Override
	public List<EmployeeResponse> getAll() {
		List<Employees> listofEmployees = employeeRepository.findAll();
		List<EmployeeResponse> responses = new ArrayList<>();
		for (Employees employees : listofEmployees) {
			EmployeeResponse response = toResponse(employees);
			responses.add(response);
		}
		return responses;
	}

	@Override
	public EmployeeResponse update(Integer id, EmployeeRequest request) {
		Optional<Employees> response = employeeRepository.findById(id);
		if(response.isPresent()) {
			Employees employees = response.get();
			employees.setName(request.getName());
		    employees.setEmail(request.getEmail());
		    employees.setSalary(request.getSalary());
		    employees.setDepartment(request.getDepartment());

			Employees respons = employeeRepository.save(employees);

			return  toResponse(employees);
			
		}
		 throw new EmployeeNotFoundException(
		            "Employee not found with id: " + id);
	}

	@Override
	public void delete(Integer id) {

	    if (!employeeRepository.existsById(id)) {
	        throw new EmployeeNotFoundException(
	                "Employee not found with id: " + id);
	    }

	    employeeRepository.deleteById(id);
	}
	
	private EmployeeResponse toResponse(Employees employee) {
	    return new EmployeeResponse(
	            employee.getId(),
	            employee.getName(),
	            employee.getEmail(),
	            employee.getSalary(),
	            employee.getDepartment()
	    );
	}
}
