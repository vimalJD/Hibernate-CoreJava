package com.hibernate.main;

import java.util.Iterator;
import java.util.List;

import javax.persistence.*;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.model.Address;
import com.hibernate.model.Employee;
import com.hibernate.util.HibernateUtil;

public class HibernateWithManyToOne {

	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSessionAnnotationFactory()
				.getCurrentSession();
		//start transaction
		 Transaction tx =session.beginTransaction();
		 
		 Employee e1=new Employee();  
		    e1.setName("Ravi Malik");  
		    e1.setEmail("ravi@gmail.com");  
		    
		    Employee e2=new Employee();
		    e2.setName("Anuj Verma");
		    e2.setEmail("anuj@gmail.com");
		      
		    Address address1=new Address();  
		    address1.setAddressLine1("G-13,Sector 3");  
		    address1.setCity("Noida");  
		    address1.setState("UP");  
		    address1.setCountry("India");  
		    address1.setPincode(201301);  
		      
		    e1.setAddress(address1);  
		    e2.setAddress(address1);
		      
		    session.save(e1);
	        session.save(e2);
		    
		    /*session.persist(e1);  
		    session.persist(e2);*/
		    
	        Query query=session.createQuery("from Employee e");  
	        List<Employee> list=query.list(); 
	          
	        Iterator<Employee> itr=list.iterator();  
	        while(itr.hasNext()){  
	         Employee emp=itr.next();  
	         System.out.println(emp.getEmployeeId()+" "+emp.getName()+" "+emp.getEmail());  
	         Address address=emp.getAddress();  
	         System.out.println(address.getAddressLine1()+" "+address.getCity()+" "+  
	            address.getState()+" "+address.getCountry()+" "+address.getPincode());  
	        }
	        
	        
	        
	        tx.commit();
			 //terminate session factory, otherwise program won't end
			HibernateUtil.getSessionAnnotationFactory().close();
			
//		    session.close();  
		    System.out.println("success");
		 
		 
		 
		 
	}
}
