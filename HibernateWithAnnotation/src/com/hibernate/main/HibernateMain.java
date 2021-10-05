package com.hibernate.main;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.hibernate.model.Address;
import com.hibernate.model.Employee;
import com.hibernate.util.HibernateUtil;

public class HibernateMain {
	public static void main(String[] args) {

		Address address = new Address();
		address.setLandmark("Kothrud");
		address.setZip("411038");
		address.setCountry("India");

		Employee e2 = new Employee();
		e2.setId(111);
		e2.setName("vimal");
		e2.setRole("MD");
		e2.setAddress(address);

		Employee e1 = new Employee();
		e1.setId(112);
		e1.setName("Siddhesh");
		e1.setRole("CEO");
		e1.setAddress(address);

		Employee e = new Employee();
		e.setId(113);
		e.setName("Akshay");
		e.setRole("MNGR");
		e.setAddress(address);

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		session.beginTransaction();

		session.save(e2);
		session.save(e1);
		session.save(e);

		Query query = session.createQuery("From Employee");
		List<Employee> list = query.list();
		Iterator<Employee> iterator = list.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}

		session.getTransaction().commit();

		HibernateUtil.getSessionFactory().close();
	}
}
