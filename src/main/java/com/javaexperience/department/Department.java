package com.javaexperience.department;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Department")
public class Department {

	int id;
	String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
