package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;

class CreateCourseAndReviewsDemo {

	public static void main(String[] args) {

		// create session-factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Course.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();
						
			// create a course
			Course tempCourse = new Course("PackMan - How to own million points");
			
			// add some reviews
			tempCourse.addReview(new Review("Cool! love it"));
			tempCourse.addReview(new Review("Not Bad!"));
			tempCourse.addReview(new Review("Fuck you"));
			
			
			// save the course and .. leverage cascade all
			System.out.println("\nSaving the course: "+tempCourse+"\n");
			System.out.println(tempCourse.getReviews());
			session.save(tempCourse);
			
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
