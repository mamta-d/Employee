package com.company.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.company.entity.Employee;
import com.company.pdf.PdfGenerator;
import com.company.service.EmployeeService;
import com.lowagie.text.DocumentException;


@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService service;
	
	@GetMapping("/emp")
	public ResponseEntity<List<Employee>> getAllEmployee1(){
		List<Employee>list=service.getAll();
		if(list.size()<=0)
		{
		 return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}else {
			
			return ResponseEntity.of(Optional.of(list));
		}
	
	}
	
	@DeleteMapping("/emp/delete")
	public void deleteBook() {
		this.service.deleteAllEmp();
	}
	
	
	//-----------------------------------------------------------
	@GetMapping("/emp/pdf")

	  public void generatePdfFile(HttpServletResponse response) throws DocumentException, IOException {

	    response.setContentType("application/pdf");

	    DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD:HH:MM:SS");

	    String currentDateTime = dateFormat.format(new Date());

	    String headerkey = "Content-Disposition";

	    String headervalue = "attachment; filename=student" + currentDateTime + ".pdf";

	    response.setHeader(headerkey, headervalue);

	    List < Employee > emplist = service.getAll();

	    PdfGenerator generator = new PdfGenerator();

	    generator.generate(emplist, response);

	  }
	
	}
	

