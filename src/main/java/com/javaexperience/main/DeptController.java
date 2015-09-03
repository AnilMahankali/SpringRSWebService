package com.javaexperience.main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaexperience.department.Department;

@Controller
@RequestMapping("/services")
public class DeptController 
{
	List<Department> list = new ArrayList<Department>();  
	
	@RequestMapping(value = "/getDept/{deptId}", method = RequestMethod.GET)
	public Department getDepartment(@PathVariable int deptId) {
		for (Iterator<Department> iterator = list.iterator(); iterator.hasNext();) {
			Department dept = iterator.next();
			if(dept.getId()==deptId) {
				return dept;
			}
		}
		return null;
	}
	
	@RequestMapping(value = "/removeDept/{deptId}", method = RequestMethod.DELETE)
	public String removeDepartment(@PathVariable int deptId) {
		for (Iterator<Department> iterator = list.iterator(); iterator.hasNext();) {
			Department dept = iterator.next();
			if(dept.getId()==deptId) {
				iterator.remove();
				return "Successfully removed";
			}
		}
		return "Department Not found";
	}
	
	@RequestMapping(value = "/addDept/{deptId}/{deptName}", method = RequestMethod.POST)
	public String addDepartment(@PathVariable int deptId,@PathVariable String deptName) {
		Department dept = new Department();
		dept.setId(deptId);
		dept.setName(deptName);
		list.add(dept);
		return "Department Added";
	}
	
	@RequestMapping(value = "/addDept/{deptId}/{deptName}", method = RequestMethod.PUT)
	public String updateDepartment(@PathVariable int deptId,@PathVariable String deptName) {
		Department dept = new Department();
		for (Iterator<Department> iterator = list.iterator(); iterator.hasNext();) {
			dept =  iterator.next();
			if(dept.getId()==deptId) {
				dept.setName(deptName);
				return "Successfully upated";
			}
		}
		return "Department Not found";
	}
}
