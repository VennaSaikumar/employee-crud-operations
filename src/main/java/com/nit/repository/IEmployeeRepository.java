package com.nit.repository;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.nit.model.Employee;

public interface IEmployeeRepository extends PagingAndSortingRepository<Employee, Integer> {
	@Query("FROM Employee WHERE status <> 'deleted'")
	public List<Employee> findAllActiveEmployees();
	Page<Employee> findByStatusNot(String status, Pageable pageable);

}
