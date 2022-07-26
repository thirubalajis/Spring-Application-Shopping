package com.example.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ecommerce.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
