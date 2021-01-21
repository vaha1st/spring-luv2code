package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

class CreateStudentDemo {

	public static void main(String[] args) {
		
		// create session-factory
		SessionFactory factory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Student.class)
										.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
						
			// create the Student object
			System.out.println("Creating a new Student object");
			Student theStudent = new Student("Ruslan", "Valhitov", "bla@gmail.com");
			
			// start a transaction
			session.beginTransaction();
			
			// save the student object
			System.out.println("Saving the Student object");
			session.save(theStudent);
			
			// commit the transaction
			session.getTransaction().commit();
			System.out.println("Done.");
			
		} finally {
			factory.close();
		}
	}

}
