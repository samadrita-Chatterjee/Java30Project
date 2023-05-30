package net.java.springboot.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.java.springboot.model.Employee;
import net.java.springboot.repository.EmployeeRepository;


@Service
public  class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	private EmployeeRepository employeeRepository;
	

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}


	@Override
	public void saveEmployee(Employee employee) {
		this.employeeRepository.save(employee);
	}


	@Override
	public Employee getEmployeeById(long id) {
		// TODO Auto-generated method stub
		return null;
	}



	
}

