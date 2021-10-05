package com.hibernate.main;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.hibernate.model.Department;
import com.hibernate.model.Employee;
import com.hibernate.util.HibernateUtil;
public class HibernateMainWithOneToMany {	
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionAnnotationFactory().getCurrentSession();
		//start transaction
		 Transaction tx =session.beginTransaction();		 
		 Department department = new Department();
			department.setDepartmentName("Sales");
			session.save(department);
			
			Employee emp1 = new Employee("Nina", "Mayers", "111");
			Employee emp2 = new Employee("Tony", "Almeida", "222");

			emp1.setDepartment(department);
			emp2.setDepartment(department);
			
			session.save(emp1);
			session.save(emp2);
			
			tx.commit();
			 //terminate session factory, otherwise program won't end
			HibernateUtil.getSessionAnnotationFactory().close();
	}

}
