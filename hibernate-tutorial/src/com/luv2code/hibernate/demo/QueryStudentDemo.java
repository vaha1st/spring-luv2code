package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

class QueryStudentDemo {

	public static void main(String[] args) {
		
		// create session-factory
		SessionFactory factory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Student.class)
										.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
						
			// start a transaction
			session.beginTransaction();
						
			// Query Students
			List<Student> students = session.createQuery("from Student").getResultList();
						
			// display students
			printStudents(students);
			
			// query students: Last Name "Duck"
			students = session.createQuery("from Student s where s.lastName='duck'").getResultList();
			printStudents(students);
			
			// query students: last name "Vakhitova" or first name "Watson"
			students = session.createQuery("from Student s where s.lastName='Vakhitov' or s.firstName='Watson'").getResultList();
			printStudents(students);
			
			// query where email like "moew%"
			students = session.createQuery("from Student s where s.email like 'sister%'").getResultList();
			printStudents(students);

						
			// commit the transaction
			session.getTransaction().commit();
			System.out.println("Done.");
			
		} finally {
			factory.close();
		}
		
	}
	
	private static void printStudents(List<Student> students) {
		for(Student st : students) {
			System.out.println(st);
		}
	}

}
