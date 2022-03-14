package com.example.demo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
	@Query("select obj from Employee obj where obj.empJob =?1")
	public Iterable<Employee> findEmployeesByJob(String Job);
}

