package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

class ReadStudentDemo {

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
			Student theStudent = new Student("Daffy", "Duck", "utka@gmail.com");
			
			// start a transaction
			session.beginTransaction();
			
			// save the student object
			System.out.println("Saving the Student object");
			System.out.println(theStudent);
			session.save(theStudent);
			
			// commit the transaction
			session.getTransaction().commit();
			
			// find out the student's id: primary key
			System.out.println("Saved student. Generated id: "+theStudent.getId());
			
			
			
			// get a new session and start a transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retrieve object from DB using Id
			Student myStudent = session.get(Student.class, theStudent.getId());
			
			System.out.println("Get complete: "+myStudent);
			
			// commit
			session.getTransaction().commit();
			
			
			System.out.println("Done.");
			
		} finally {
			factory.close();
		}
	}

}
