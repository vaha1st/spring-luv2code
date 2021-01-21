package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		// create session-factory
		SessionFactory factory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Student.class)
										.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
						
			// create 3 Student objects
			System.out.println("Creating a new Student objects");
			Student Student1 = new Student("Watson", "Vakhitov", "moew@gmail.com");
			Student Student2 = new Student("Ksu", "Vakhitova", "toltukha@gmail.com");
			Student Student3 = new Student("Aliya", "Vakhitova", "sister@gmail.com");
			
			// start a transaction
			session.beginTransaction();
			
			// save the student object
			System.out.println("Saving the Student objects");
			session.save(Student1);
			session.save(Student2);
			session.save(Student3);
			
			// commit the transaction
			session.getTransaction().commit();
			System.out.println("Done.");
			
		} finally {
			factory.close();
		}

	}

}
