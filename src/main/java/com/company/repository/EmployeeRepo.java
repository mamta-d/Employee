package com.company.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.company.entity.Employee;

@Repository
public interface EmployeeRepo extends CrudRepository<Employee, Integer> {

}
