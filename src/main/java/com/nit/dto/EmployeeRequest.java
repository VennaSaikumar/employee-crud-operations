
package com.nit.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;


public class EmployeeRequest {
	@NotBlank(message = "Name is required")
	private String name;

	@NotBlank(message = "Email is required")
	@Email(message = "Invalid email format")
	private String email;

	@NotNull(message = "Salary is required")
	@Positive(message = "Salary must be greater than 0")
	private BigDecimal salary;

	@NotBlank(message = "Department is required")
	private String department;
	
	public EmployeeRequest(String name, String email, BigDecimal salary, String department) {
		super();
		this.name = name;
		this.email = email;
		this.salary = salary;
		this.department = department;
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
