package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

class AddMoreCoursesForMaryDemo {

	public static void main(String[] args) {

		// create session-factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();
						
			// get Mary from data base
			Student student = session.get(Student.class, 2);
			
			System.out.println("\nLoaded Student: "+student);
			System.out.println("His courses: "+student.getCourses());
			
			// create more courses
			Course course1 = new Course("Cooking - how to make a pizza");
			Course course2 = new Course("Division 2 - how to make a perfect damage build");
			
			// add Mary to this courses
			course1.addStudent(student);
			course2.addStudent(student);

			// save the courses
			System.out.println("\nSaving the new courses...");
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
