package com.example.mongodb.springboot_mongodb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.mongodb.springboot_mongodb.model.Employee;
import com.example.mongodb.springboot_mongodb.service.EmployeeService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping
	public String showForm(Model model) {
		model.addAttribute("employee", new Employee());
		return "index";
	}

	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute Employee employee) {
		employeeService.saveEmployee(employee);
		return "redirect:/displayAll";
	}

	@GetMapping("/displayAll")
	public String displayAllEmployees(Model model) {
		List<Employee> employees = employeeService.getAllEmployees();
		model.addAttribute("employees", employees);
		return "employeeList";
	}

	@GetMapping("/display/{id}")
	public String displayEmployeeById(@PathVariable String id, Model model) {
		Optional<Employee> employee = employeeService.getEmployeeById(id);
		if (employee.isPresent()) {
			model.addAttribute("employee", employee.get());
			return "employeeDetail";
		}
		return "notFound";
	}
}
