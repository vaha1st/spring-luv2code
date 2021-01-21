package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

class CreateCourseDemo {

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
						
			// create the courses
			Course course1 = new Course("Spring");
						Course course2 = new Course("Hibernate");

			// add courses to instructor
			theInstructor.add(course1);
			theInstructor.add(course2);



			// save courses
			System.out.println("Saving courses: " + course1);
			session.save(course1);
			session.save(course2);

			// commit the transaction
			session.getTransaction().commit();
			System.out.println("Done!");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}
	}

}
