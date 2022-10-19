package com.company.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.entity.Employee;
import com.company.repository.EmployeeRepo;



@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepo repository;
	
	public void saveEmp(List<Employee> emplist) {
		repository.saveAll(emplist);
		}
	

	public List<Employee> getAll() {
		List<Employee> emplist = (List<Employee>) this.repository.findAll();
		return emplist;
	}
	
	public void deleteAllEmp() {
		repository.deleteAll();
		System.out.println(" Records Deleted");

	}


}
