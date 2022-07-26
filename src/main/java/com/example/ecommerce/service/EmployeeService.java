package com.example.ecommerce.service;

import java.util.List;

import com.example.ecommerce.model.Employee;

public interface EmployeeService {
	public Employee saveEmployee(Employee employee);
	
	List <Employee> getAllEmployees();
	
	Employee getEmployeeByID(long id);
	
	Employee updateEmployee(Employee employee, long id);
	
	void deleteEmployee(long id);

}
