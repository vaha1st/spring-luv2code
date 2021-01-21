package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Employee;
import com.luv2code.hibernate.demo.entity.Student;

public class HomeWork {

	public static void main(String[] args) {

		// create session-factory
		SessionFactory factory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Employee.class)
										.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
			// Create
			System.out.println("Creating new employee Ruslan...");
			Employee theEmployee = new Employee("Ruslan", "Vakhitov", "StayAtHome");
			
			session.beginTransaction();
			
			session.save(theEmployee);
			
			theEmployee = new Employee("Watson", "Smetanin", "Korobka");
			
			session.save(theEmployee);
			
			session.getTransaction().commit();
			
			// Read
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			System.out.println("\nReading employee with id 1...\n");
			Employee emp1 = session.get(Employee.class, 1);
			
			List<Employee> readEmployee = session.createQuery("from Employee").getResultList();
			
			System.out.println("\nReading all employees...\n");
			printEmps(readEmployee);
			
			// Query employee with company "Korobka"
			readEmployee = session.createQuery("from Employee where company like '%Korobka'").getResultList();
			
			System.out.println("\nReading employees from Korobka company...\n");
			printEmps(readEmployee);
			
			session.getTransaction().commit();
			
			// Delete employee with id 1
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			System.out.println("Deleting employee with id 1");
			session.delete(emp1);
			
			session.getTransaction().commit();
			
			
			System.out.println("Done!");
			
			
		}finally {
			factory.close();
		}
	}

	private static void printEmps(List<Employee> readEmployee) {
		for(Employee emp : readEmployee) {
			System.out.println(emp);
		}
	}

}
