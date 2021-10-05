package com.hibernate.main;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.model.Employee;
import com.hibernate.util.HibernateUtil;

public class HibernateMainNamedParameter {

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

		//Parameter Binding in Hibernate
		System.out.println("---------------------------------------------");
		System.out.println("Use of named parameters: lable");
		Query query = session
				.createQuery("update Employee e set e.salary=:salary where e.id=:id");
		query.setParameter("salary", 9000.0);
		query.setParameter("id", 113);

		int i = query.executeUpdate();

		System.out.println("---------------------------------------------");
		
		System.out.println("Data Updated Successfully and " + i
				+ " row changes");
		
		System.out.println("---------------------------------------------");
		System.out.println("---------------------------------------------");
		System.out.println("Use of Question mark symbol: ( ? )");
		query = session.createQuery("delete from Employee e where e.id=?");

		query.setParameter(0, 112);
		
		i = query.executeUpdate();
		System.out.println("Data Updated Successfully and " + i
				+ " row changes");

		transaction.commit();

		HibernateUtil.getSessionAnnotationFactory().close();
	}
}
