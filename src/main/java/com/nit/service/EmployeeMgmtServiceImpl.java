package com.nit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nit.model.Employee;
import com.nit.repository.IEmployeeRepository;

@Service("empService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtServcie {
	@Autowired
	private IEmployeeRepository empRepo;

	@Override
	public Iterable<Employee> getAllEmployees() {
		
		return empRepo.findAll();		
	}

	@Override
	public String registerEmployee(Employee emp) {
		
		return "employee is saved with id value:"+empRepo.save(emp).getEmpno();
	}

	@Override
	public Employee getEmployeeByNo(int eno) {
		Employee emp=empRepo.findById(eno).orElseThrow(()->new IllegalArgumentException());
		return emp;
	}

	@Override
	public String updateEmployee(Employee emp) {
		return "Employee is Updated with having id value ::"+empRepo.save(emp).getEmpno();
	}

	@Override
	public String deleteEmployeeById(int id) {
	    Employee emp = empRepo.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
	    emp.setStatus("deleted");
	    empRepo.save(emp);
	    return "Employee marked as deleted";
	}
	@Override
	public Page<Employee> getAllActiveEmployees(Pageable pageable) {
	    return empRepo.findByStatusNot("deleted", pageable);
	}

		
	}

