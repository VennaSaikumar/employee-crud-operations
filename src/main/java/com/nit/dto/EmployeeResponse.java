package com.nit.dto;

import java.math.BigDecimal;

public class EmployeeResponse {
	private Integer id;
	private String name;
	private String email;
	private BigDecimal salary;
	private String department;
	
	public EmployeeResponse(Integer id, String name, String email, BigDecimal salary, String department) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.salary = salary;
		this.department = department;
	}

	public Integer getId() {
		return id;
	}


	public String getName() {
		return name;
	}


	public String getEmail() {
		return email;
	}


	public BigDecimal getSalary() {
		return salary;
	}


	public String getDepartment() {
		return department;
	}

	
}
