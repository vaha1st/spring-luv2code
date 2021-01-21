package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

class CreateIntructorDemo {

	public static void main(String[] args) {
		
		// create session-factory
		SessionFactory factory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Instructor.class)
										.addAnnotatedClass(InstructorDetail.class)
										.addAnnotatedClass(Course.class)
										.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
			// create the objects
			 
			
			Instructor instructor = new Instructor ("Watson", "Public", "susan@luv2code.com");
			InstructorDetail instructorDetails = new InstructorDetail("www.youtube.com", "Gamer");
			
			
			// associate the objects together
			instructor.setInstructorDetail(instructorDetails);

			// start a transaction
			session.beginTransaction();
			
			
			// save the Instructor
			// Note: this save will also save the instructorDetails object because of CascadeType.ALL
			System.out.println("Saving instructor: " + instructor);
			session.save(instructor);

			
			
		
			// commit the transaction
			session.getTransaction().commit();
			System.out.println("Done!");
			
		} catch(Exception e){
			e.printStackTrace();
		}finally {
			session.close();
			factory.close();
		}
	}

}
