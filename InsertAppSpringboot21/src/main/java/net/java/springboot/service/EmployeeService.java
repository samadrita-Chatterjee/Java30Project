package net.java.springboot.service;


import java.util.List;

import net.java.springboot.model.Employee;

public interface EmployeeService {
	
	List<Employee> getAllEmployees();
	void saveEmployee(Employee employee);
	Employee getEmployeeById(long id);
	
}
