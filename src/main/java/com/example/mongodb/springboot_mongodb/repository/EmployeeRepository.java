package com.example.mongodb.springboot_mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.mongodb.springboot_mongodb.model.Employee;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String> {
}
