package com.example.mongodb.springboot_mongodb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mongodb.springboot_mongodb.model.Employee;
import com.example.mongodb.springboot_mongodb.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository repository;

	public Employee saveEmployee(Employee employee) {
		return repository.save(employee);
	}

	public List<Employee> getAllEmployees() {
		return repository.findAll();
	}

	public Optional<Employee> getEmployeeById(String id) {
		return repository.findById(id);
	}
}
