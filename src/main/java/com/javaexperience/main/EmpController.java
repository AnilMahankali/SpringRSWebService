package com.javaexperience.main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaexperience.department.Department;
import com.javaexperience.employee.Employee;

@Controller
public class EmpController 
{
	List<Employee> list = new ArrayList<Employee>();  
	
	@RequestMapping(value = "/getEmp/{emp}", method = RequestMethod.GET)
	public Employee getEmployee(@PathVariable("emp") int empid) {
		System.out.println("empid is " + empid);
		for (Iterator<Employee> iterator = list.iterator(); iterator.hasNext();) {
			Employee emp = (Employee) iterator.next();
			if(emp.getEmpId()==empid) {
				return emp;
			}
		}
		return null;
	}
	
	@RequestMapping(value = "/removeEmp/{emp}", method = RequestMethod.DELETE)
	public String removeEmployee(@PathVariable("emp") int empid) {
		for (Iterator<Employee> iterator = list.iterator(); iterator.hasNext();) {
			Employee emp = (Employee) iterator.next();
			if(emp.getEmpId()==empid) {
				iterator.remove();
				return "Successfully removed";
			}
		}
		return "Not found";
	}
	
	@RequestMapping(value = "/addEmp/{emp}/{dept}", method = RequestMethod.POST)
	public String addEmployee(@PathVariable int empid,@PathVariable int deptId) {
		Employee emp = new Employee();
		emp.setEmpId(empid);
		DeptController deptController = new DeptController();
		List<Department> depts = deptController.list;
		for (Iterator<Department> iterator = depts.iterator(); iterator.hasNext();) {
			Department dept =  iterator.next();
			if(dept.getId() == deptId) {
				emp.setDept(dept);
				list.add(emp);
				return "Employee Added";
			}
		}
		return "Department Not found";
	}
	
	@RequestMapping(value = "/addEmp/{emp}/{dept}", method = RequestMethod.PUT)
	public String updateEmployee(@PathVariable int empid,@PathVariable int deptId) {
		Employee emp = new Employee();
		for (Iterator<Employee> iterator = list.iterator(); iterator.hasNext();) {
			emp = iterator.next();
			if(emp.getEmpId()==empid) {
				break;
			}
		}

		DeptController deptController = new DeptController();
		List<Department> depts = deptController.list;
		for (Iterator<Department> iterator = depts.iterator(); iterator.hasNext();) {
			Department dept = iterator.next();
			if(dept.getId() == deptId) {
				emp.setDept(dept);
				return "Employee Updated";
			}
		}
		return "Employee or Department Not found";
	}

}
