package com.luv2code.springboot.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

 import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	// quick and dirty inject dao
	private EmployeeService employeeService;
	
	@Autowired
	public EmployeeRestController(EmployeeService theEmployeeService) {
		employeeService=theEmployeeService;
	}
	
	// expose endpoint for GET /employees - get list of all employee
	@GetMapping("/employees")
	public List<Employee> getEmployees() {
		return employeeService.getEmployees();
	}
	
	// expose endpoint for GET /employees/{employeeId} - get employee by id
	@GetMapping("/employees/{employeeId}")
	public Employee getSingleEmployee(@PathVariable int employeeId) {
		
		Employee employee = employeeService.getSingleEmployee(employeeId);
		
		if(employee == null) {
			throw new RuntimeException("Employee id not found - "+employeeId);
		}
		
		return employee;
	}
	
	// expose endpoint for POST /employees - save employee
	@PostMapping("/employees")
	public Employee saveEmployee(@RequestBody Employee employee) {
		
		// just in case id included in request set employeeId to 0. Hibernate save a new
		// employee if id=0 of null
		employee.setId(0);
		
		employeeService.saveOrUpdateEmployee(employee);
		
		return employee;
	}
	
	// expose endpoint for PUT /employees - update employee
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee employee) {
		
		employeeService.saveOrUpdateEmployee(employee);
		
		return employee;
	}
	
	
	// expose endpoint for DELETE /employees/{employeeId} - delete employee by id
	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {
		
		Employee employee = employeeService.getSingleEmployee(employeeId);
		
		if(employee == null) {
			throw new RuntimeException("Employee id not found - "+employeeId);
		}
		
		employeeService.deleteEmployee(employeeId);
		
		return "Employee deleted - "+employeeId;
		
	}
	

}
