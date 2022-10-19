package com.company;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.company.entity.Employee;
import com.company.service.EmployeeService;



@SpringBootApplication
public class EmployeStart1Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext run= SpringApplication.run(EmployeStart1Application.class, args);
		EmployeeService bean = run.getBean(EmployeeService.class);
		  Employee employee= new Employee("Mamta", "Aurangabad", 738555444); Employee employee2=new
		  Employee("Adesh", "Pune", 995511223); Employee employee3=new
		  Employee("Umesh", "Mumbai", 885544665); Employee employee4=new
		  Employee("Reena", "Jalgaon", 774455445); Employee employee5=new
		  Employee("Suraj","Pune",885577445); Employee employee6=new
		  Employee("Pratik","Nasik", 998844556); Employee employee7= new
		  Employee("Rudraksh", "Mumbai", 66447788); Employee employee8=new
		  Employee("Sarika", "pune", 88794568); Employee employee9= new
		  Employee("Prashant", "Aurangabad", 988111445);
		  
		  bean.saveEmp(List.of(employee,employee2,employee3,employee4,employee5,
		  employee6,employee7,employee8,employee9));
	}

}
