 package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

class EagerLazyDemo {

	public static void main(String[] args) {

		// create session-factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();
						
			// get the instructor from DB
			int id =1;
			Instructor theInstructor = session.get(Instructor.class, id);
			System.out.println("luv2code: Instructor: "+theInstructor);		
			
			System.out.println("luv2code: Courses: "+theInstructor.getCourses()); 	
			
			// commit the transaction
			session.getTransaction().commit();
			
			// close the session
			session.close();
			System.out.println("\nluv2code% we are closing the session\n");

			
			// since the courses are lazy loaded ... this should fail
			
			// retrieve the courses from the instructor
			System.out.println("luv2code: Courses: "+theInstructor.getCourses()); 	
			
			
			
			System.out.println("Done!");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}
	}

}
