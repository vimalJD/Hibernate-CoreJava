package com.hibernate.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("PerEmp")
public class PermanentEmployee extends Employee {

	@Column(name = "Designation", length = 20, nullable = true)
	private String designation;

	@Column(name = "Department", length = 20, nullable = true)
	private String department;

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

}
