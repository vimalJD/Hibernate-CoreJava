package com.hibernate.main;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.hibernate.model.Employee;
import com.hibernate.model.PermanentEmployee;
import com.hibernate.model.TemporaryEmployee;
import com.hibernate.util.HibernateUtil;

public class HibernateMainTablePerHierarchy {
	public static void main(String[] args) {

		Employee e1 = new Employee();
		e1.setId(111);
		e1.setName("vimal");
		e1.setSalary(25000);

		// Creating the object of two Permanent Employee
		PermanentEmployee pe1 = new PermanentEmployee();
		pe1.setId(112);
		pe1.setName("Siddhesh");
		pe1.setSalary(30000);
		pe1.setDesignation("manager");
		pe1.setDepartment("Tech");

		PermanentEmployee pe2 = new PermanentEmployee();
		pe2.setId(113);
		pe2.setName("Raj");
		pe2.setSalary(35000);
		pe2.setDesignation("Former");
		pe2.setDepartment("Tech");

		// Creating the object of two Temporary Employee
		TemporaryEmployee te1 = new TemporaryEmployee();
		te1.setId(114);
		te1.setName("Amol");
		te1.setWorkingDays("28");
		te1.setContractorName("Aakash");

		TemporaryEmployee te2 = new TemporaryEmployee();
		te2.setId(115);
		te2.setName("Rakesh");
		te2.setWorkingDays("25");
		te2.setContractorName("Vishal");

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		session.beginTransaction();

		session.save(e1);
		session.save(pe1);
		session.save(pe2);
		session.save(te1);
		session.save(te2);
		
		Query query = session.createQuery("FROM Employee");
	    List<Employee> myList1 = query.list();
	    for(Employee pe :myList1) 
	    {
	      System.out.println(pe);
	    }
	  
	    query = session.createQuery("FROM PermanentEmployee");
	    List<PermanentEmployee> myList = query.list();
	    for(PermanentEmployee pe :myList) 
	    {
	      System.out.println(pe);
	    }
	 
	    Query q1 = session.createQuery("FROM TemporaryEmployee");
	    List<TemporaryEmployee> yourList = q1.list();
	    for(TemporaryEmployee te : yourList)  
	    {
	      System.out.println(te);
	    }

		session.getTransaction().commit();

		HibernateUtil.getSessionFactory().close();
	}
}
