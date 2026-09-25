package com.nit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nit.entity.Employees;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employees, Integer> {

}
