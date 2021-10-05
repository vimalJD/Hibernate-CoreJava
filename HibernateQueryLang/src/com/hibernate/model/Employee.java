package com.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "employeev1", uniqueConstraints = { @UniqueConstraint(columnNames = { "EID" }) })
public class Employee {

	@Id
	@Column(name = "EId", nullable = false, unique = true, length = 11)
	private int id;

	@Column(name = "EName", length = 20, nullable = true)
	private String name;

	@Column(name = "ESalary", nullable = true)
	private double salary;

	@Column(name = "ERole", length = 20, nullable = true)
	private String role;

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

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

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary
				+ ", role=" + role + "]";
	}

}
