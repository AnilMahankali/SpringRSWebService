package com.javaexperience.employee;

import javax.xml.bind.annotation.XmlRootElement;

import com.javaexperience.department.Department;

@XmlRootElement(name="Employee")
public class Employee {

	private int empId;
	private Department dept;
		
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public Department getDept() {
		return dept;
	}
	public void setDept(Department dept) {
		this.dept = dept;
	}
}
