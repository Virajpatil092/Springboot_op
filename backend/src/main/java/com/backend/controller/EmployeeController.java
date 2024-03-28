package com.backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.exception.ResourceNotFoundException;
import com.backend.model.Employee;
import com.backend.repo.Employeerepo;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
	@Autowired
	private Employeerepo emprepo;
	
	// get all employees
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		return emprepo.findAll();
	}

	@PostMapping("/employees")
	public Employee createemployee(@Validated @RequestBody Employee e) { 
		return this.emprepo.save(e);
	}
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id) {
		return ResponseEntity.of(this.emprepo.findById(id));
	}
	
	@PostMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Long id,@Validated @RequestBody Employee emp){
		Employee e = this.emprepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("No emp with id" + id));
		
		e.setEmail_id(emp.getEmail_id());
		e.setFirstname(emp.getFirstname());
		e.setLastname(emp.getLastname());
		
		return ResponseEntity.of(Optional.of(this.emprepo.save(e)));
	}
	
	@DeleteMapping("/employees/{id}")
	public void deleteEntity(@PathVariable Long id){
		this.emprepo.deleteById(id);
	}
}