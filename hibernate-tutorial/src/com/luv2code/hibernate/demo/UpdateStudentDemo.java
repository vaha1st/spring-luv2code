package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

class UpdateStudentDemo {

	public static void main(String[] args) {
		
		// create session-factory
		SessionFactory factory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Student.class)
										.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			int studentId = 1;
			
			// start a transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// find out the student's id: primary key
			System.out.println("Saved student. Generated id: "+studentId);
			
			// retrieve object from DB using Id
			Student myStudent = session.get(Student.class, studentId);
			
			// update
			System.out.println("Updating student...");
			myStudent.setEmail("update@hql.com");
			myStudent.setFirstName("Scooby");

			
			// !commit the transaction
			session.getTransaction().commit();
			
			System.out.println(myStudent);
			
			// NEW update bulk of table
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// update email for all students
			System.out.println("Updating bulk of emails to 'foo@bar.com'");
			session.createQuery("update Student s set s.email='foo@bar.com'").executeUpdate();
			
			// !commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done.");
			
		} finally {
			factory.close();
		}
	}

}
