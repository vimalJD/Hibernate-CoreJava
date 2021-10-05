package com.hibernate.main;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.hibernate.model.Employee;
import com.hibernate.util.HibernateUtil;

public class HibernateMainCriteriaAPI {
	public static void main(String[] args) {

		Session session = HibernateUtil.getSessionAnnotationFactory()
				.getCurrentSession();
		Transaction transaction = session.beginTransaction();

		Employee e1 = new Employee();
		e1.setId(124);
		e1.setName("Aniket");
		e1.setRole("Clerk");
		e1.setSalary(7800);
		
		Employee employee2 = new Employee();
		employee2.setId(121);
		employee2.setName("Manasi");
		employee2.setRole("MD");
		employee2.setSalary(80222);

		Employee employee3 = new Employee();
		employee3.setId(100);
		employee3.setName("Sam");
		employee3.setRole("Manager");
		employee3.setSalary(45000);

		session.save(e1);
		session.save(employee2);
		session.save(employee3);

		System.out.println("-----------------------------------------");
		
		System.out.println("1) Use of simeple Criteria");
		Criteria cr;
		cr = session.createCriteria(Employee.class);
		List<Employee> list = cr.list();
		Iterator<Employee> iter = list.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}

		System.out.println("-----------------------------------------");

		System.out.println("2) Use of Criteria With Restrictions");
		cr = session.createCriteria(Employee.class);
		cr.add(Restrictions.like("name", "A%"));
		list = cr.list();
		iter = list.iterator();
		while (iter.hasNext()) {

			System.out.println(iter.next());
		}
		System.out.println("-----------------------------------------");

		// Use of Criteria with and Expression
		System.out.println("3) Use of Criteria with and Expression");
		cr = session.createCriteria(Employee.class);
		cr.add(Expression.between("salary", 2000.0, 8000.0));
		list = cr.list();
		iter = list.iterator();
		while (iter.hasNext()) {

			System.out.println(iter.next());
		}

		System.out.println("-----------------------------------------");

		// Criteria with the use of Criterion concepts with the Restrictions
		// with the use of order
		System.out.println("4) Criteria by using of Criterion concepts with the Restrictions by using use of order");
		Criteria criteria = session.createCriteria(Employee.class);
		Criterion crt = Restrictions.idEq(new Integer(113));
		
//		crt = Restrictions.eq("salary", new Double(7800.0));

//		 crt=Restrictions.like("name", "a%") ;
		
		 crt=Restrictions.between("name", "A","N");

		criteria.add(crt);

		criteria.addOrder(Order.asc("salary"));

		list = criteria.list();
		Iterator iterator = list.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		System.out.println("-----------------------------------------");
		// To put AND and OR in Criteria
		System.out.println("5) To put AND and OR in Criteria");
		Criterion cr1 = Restrictions.between("salary", new Double(7000),
				new Double(90000));
		Criterion cr3 = Restrictions.eq("name", "Manasi");

		LogicalExpression expression = Restrictions.or(cr3, cr1);
		criteria.add(expression);

		List list1 = criteria.list();
		Iterator iterator1 = list1.iterator();
		while (iterator1.hasNext()) {
			System.out.println(iterator1.next());
		}

		transaction.commit();

		HibernateUtil.getSessionAnnotationFactory().close();

	}
}
