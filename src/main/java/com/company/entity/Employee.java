package com.company.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.lowagie.text.pdf.PdfPCell;

@Entity
@Table
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer empId;
	private String  empName;
	private String  empAddress;
	private Integer empPhone;
	
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empAddress=" + empAddress + ", empPhone="
				+ empPhone + "]";
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpAddress() {
		return empAddress;
	}

	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}

	public Integer getEmpPhone() {
		return empPhone;
	}

	public void setEmpPhone(Integer empPhone) {
		this.empPhone = empPhone;
	}

	public Employee( String empName, String empAddress, Integer empPhone) {
		super();
		this.empName = empName;
		this.empAddress = empAddress;
		this.empPhone = empPhone;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
