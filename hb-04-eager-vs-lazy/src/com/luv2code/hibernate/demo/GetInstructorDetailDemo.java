package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

class GetInstructorDetailDemo {

	public static void main(String[] args) {

		// create session-factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();

			// get the instructorDetail object
			int id = 299;
			InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, id);

			// print the instructor detail
			System.out.println("Instructor Details: " + tempInstructorDetail);

			// print the associated instructor
			System.out.println("Associated Instructor: " + tempInstructorDetail.getInstructor());

			// commit the transaction
			session.getTransaction().commit();
			System.out.println("Done!");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			// handle connection leak issue
			session.close();

			factory.close();
		}
	}

}
