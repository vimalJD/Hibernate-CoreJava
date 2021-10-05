package com.hibernate.main;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.hibernate.model.Employee;
import com.hibernate.util.HibernateUtil;

public class HibernateMain {
	public static void main(String[] args) {

		Employee e2 = new Employee();
		e2.setId(111);
		e2.setName("vimal");
		e2.setRole("MD");

		Employee e1 = new Employee();
		e1.setId(112);
		e1.setName("Siddhesh");
		e1.setRole("CEO");

		Employee e = new Employee();
		e.setId(113);
		e.setName("Akshay");
		e.setRole("MNGR");

		//For getting session
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		//For starting transaction
		session.beginTransaction();

		//For saving the model object means the record in the database.
		session.save(e2);
		session.save(e1);
		session.save(e);

		//To fetch all the records.
		//Using the query object we are generating the query which will fetch all the records.
		Query query = session.createQuery("From Employee e2");
		List<Employee> list = query.list();
		Iterator<Employee> iterator = list.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}

		/*//Use of the load method to get the particular records 
		
		e = (Employee) session.load(Employee.class, 113);
		
		//Now the same record which we can update.
		
		e.setName("Rohit");
		e.setRole("MNGR");
		session.update(e);
		
		//TO delete the records
		
		e1 = (Employee) session.get(Employee.class, 112);
		session.delete(e1);*/
		
		//Commit transaction
		session.getTransaction().commit();

		//terminate session factory, otherwise program will not end.
		HibernateUtil.getSessionFactory().close();
	}
}
