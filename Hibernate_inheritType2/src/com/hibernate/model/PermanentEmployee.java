package com.hibernate.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="PermanentEmployee")
@AttributeOverrides({
	@AttributeOverride(name="name", column=@Column(name="ENAME")),
    @AttributeOverride(name ="salary", column=@Column(name="ESalary"))
})
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

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary
				+ "]\n"+"PermanentEmployee [designation=" + designation + ", department=" + department + "]";
	}

}
