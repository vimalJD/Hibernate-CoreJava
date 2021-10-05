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
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

public class Employee {

	@Id
	@Column(name = "EId", nullable = false, unique = true, length = 11)
	protected int id;

	@Column(name = "EName", length = 20, nullable = true)
	protected String name;

	@Column(name = "ESalary", nullable = true)
	protected double salary;

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
				+ "]";
	}

}
