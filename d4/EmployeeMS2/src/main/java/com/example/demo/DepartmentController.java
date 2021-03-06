package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class DepartmentController {
	@Autowired
	DepartmentRepository repository;
	@PostMapping("/departments")
	public ResponseEntity<String> createDepartment(@RequestBody Department dep){
	try {
	repository.save(dep);
	ResponseEntity<String> response = new ResponseEntity<>("departments Created", HttpStatus.CREATED);
	return response;
	} catch (Exception e) {
	ResponseEntity<String> response = new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	return response;
	}
	}
	@GetMapping("/departments")
	public Iterable<Department> getAllDepartment(){

	return repository.findAll();
	}
	

}
