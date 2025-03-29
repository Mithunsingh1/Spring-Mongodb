package com.example.mongodb.springboot_mongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@Document(collection = "employees")
public class Employee {
	@Id
	private String id;
	private String name;
	private String email;
	
	private String location;
	
	
}
