package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

class DeleteDemo {

	public static void main(String[] args) {

		// create session-factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();

			// get the instructor by the primary key
			int id = 1;
			Instructor tempInstructor = session.get(Instructor.class, id);

			System.out.println("Found instructor :" + tempInstructor);
			// delete instructor
			if (tempInstructor != null) {
				System.out.println("Deleting instructor "+tempInstructor);
				// Delete instructor and cascade delete instructor details
				session.delete(tempInstructor);
			}

			// commit the transaction
			session.getTransaction().commit();
			System.out.println("Done!");

		} finally {
			factory.close();
		}
	}

}
