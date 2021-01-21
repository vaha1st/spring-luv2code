package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

class DeleteStudentDemo {

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
			
			// new! delete the students
			System.out.println("Deleting student "+myStudent);
			session.delete(myStudent); 
			
			System.out.println("Deleting student with id 3 ");
			session.createQuery("delete from Student where id=3").executeUpdate();

			
			// !commit the transaction
			session.getTransaction().commit();
		
			
			System.out.println("Done.");
			
		} finally {
			factory.close();
		}
	}

}
