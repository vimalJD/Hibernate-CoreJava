package com.hibernate.main;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.model.Employee;
import com.hibernate.util.HibernateUtil;

public class HibernateMainAggregateFun {

	public static void main(String[] args) {

		Session session = HibernateUtil.getSessionAnnotationFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();

		Employee e1 = new Employee();
		e1.setId(111);
		e1.setName("vimal");
		e1.setSalary(100000);
		e1.setRole("MD");

		Employee employee2 = new Employee();
		employee2.setId(112);
		employee2.setName("raj");
		employee2.setRole("CEO");
		employee2.setSalary(70000);

		Employee employee3 = new Employee();
		employee3.setId(113);
		employee3.setName("vikash");
		employee3.setRole("MNG");
		employee3.setSalary(50000);

		session.save(e1);
		session.save(employee2);
		session.save(employee3);

		System.out.println("Use of Count aggregate Function");
		Query q = session.createQuery("select count(distinct e.name) from Employee e");
		List<Integer> list = q.list();
		System.out.println("Count of employees:" + list);
		System.out.println("------------------------------------------------");

		System.out.println("Use of Sum aggregate Function");

		// Use Sum aggregate Function
		q = session.createQuery("select sum(e.salary) from Employee e");
		list = q.list();
		System.out.println("Sum(sal):" + list);
		System.out.println("------------------------------------------------");

		System.out.println("Use of Avg aggregate Function");
		// Use of Avg aggregate function
		q = session.createQuery("select avg(e.salary) from Employee e");
		list = q.list();
		System.out.println("Average of Sal:" + list);
		System.out.println("------------------------------------------------");

		System.out.println("Use of Min aggregate Function");
		// Use of Min aggregate functions
		q = session.createQuery("select min(e.salary) from Employee e");
		list = q.list();
		System.out.println("Min of Sal:" + list);
		System.out.println("------------------------------------------------");

		System.out.println("Use of Max aggregate Function");
		// Use of Max aggregate function
		q = session.createQuery("select max(e.salary) from Employee e");
		list = q.list();
		System.out.println("Max of Sal:" + list);

		transaction.commit();

		HibernateUtil.getSessionAnnotationFactory().close();
	}
}
