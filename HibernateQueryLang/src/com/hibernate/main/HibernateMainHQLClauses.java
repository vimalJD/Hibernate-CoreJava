package com.hibernate.main;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.model.Employee;
import com.hibernate.util.HibernateUtil;

public class HibernateMainHQLClauses {
	public static void main(String[] args) {

		Session session = HibernateUtil.getSessionAnnotationFactory()
				.getCurrentSession();
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

		Query query = session.createQuery("From Employee ");
		List<Employee> list = query.list();
		Iterator<Employee> itr = list.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}

		System.out.println("Data Retrived");

		query = session.createQuery("From Employee e ");

		System.out.println("Use of Select Clause");

		query = session.createQuery("select e.id,e.name from Employee e");

		list = query.list();
		Iterator it = list.iterator();

		while (it.hasNext()) {
			Object o[] = (Object[]) it.next();

			System.out.println("Employee id : " + o[0] + "\tEmployee Name : "
					+ o[1]);

		}

		System.out.println("---------------------------");

		System.out.println("Use of where clause");

		query = session.createQuery("from Employee e where e.id<112");
		list = query.list();
		it = list.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());

		}
		System.out.println("-----------------------------");
		
		System.out.println("Use of ORDER BY clause");

		query = session
				.createQuery("from Employee e where e.id>100 ORDER BY e.salary DESC");
		list = query.list();
		it = list.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());

		}

		System.out.println("------------------------------------------------");
		// Group by clause
		
		System.out.println("Use of GROUP BY clause");

		query = session
				.createQuery("select sum(e.salary),e.name from Employee e GROUP BY e.name");
		list = query.list();
		it = list.iterator();

		while (it.hasNext()) {
			Object o[] = (Object[]) it.next();

			System.out.println("Employee sal : " + o[0] + "\tEmployee Name : "
					+ o[1]);

		}
		System.out.println("---------------------------------------");

		transaction.commit();

		HibernateUtil.getSessionAnnotationFactory().close();
	}
}
