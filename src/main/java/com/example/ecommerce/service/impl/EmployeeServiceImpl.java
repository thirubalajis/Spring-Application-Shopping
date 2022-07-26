package com.example.ecommerce.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.ecommerce.exception.ResourceNotFoundException;
import com.example.ecommerce.model.Employee;
import com.example.ecommerce.repository.EmployeeRepository;
import com.example.ecommerce.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	private EmployeeRepository employeeRepository;
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}


	@Override
	public Employee saveEmployee(Employee employee) {
		
		return employeeRepository.save(employee);
	}


	@Override
	public List<Employee> getAllEmployees() {
			
		return employeeRepository.findAll();
	}


	@Override
	public Employee getEmployeeByID(long id) {
		
		Optional <Employee> employee = employeeRepository.findById(id);
		
		if (employee.isPresent()) {
			return employee.get();
		}
		else {
			throw new ResourceNotFoundException("Employee", "Id", id);
		}
	}


	@Override
	public Employee updateEmployee(Employee employee, long id) {
		
		Employee employeeExisting = employeeRepository.findById(id).orElseThrow(
				()-> new ResourceNotFoundException("Employee", "Id", id));
		
		employeeExisting.setFirstName(employee.getFirstName());
		employeeExisting.setLastName(employee.getLastName());
		employeeExisting.setemail(employee.getEmail());
		
		employeeRepository.save(employeeExisting);
		
		return employeeExisting;
	}


	@Override
	public void deleteEmployee(long id) {
	
		employeeRepository.findById(id).orElseThrow(() -> new
				ResourceNotFoundException("Employee", "Id", id));
		
		employeeRepository.deleteById(id);
		
		return;
	}

}
