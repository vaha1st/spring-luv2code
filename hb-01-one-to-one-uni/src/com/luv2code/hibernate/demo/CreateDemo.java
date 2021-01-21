package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

class CreateDemo {

	public static void main(String[] args) {
		
		// create session-factory
		SessionFactory factory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Instructor.class)
										.addAnnotatedClass(InstructorDetail.class)
										.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
			// create the objects
			/*
			 * Instructor instructor = new Instructor ("Chad", "Darby",
			 * "darby@luv2code.com"); InstructorDetail instructorDetails = new
			 * InstructorDetail("www.luv2code.com/youtube", "Luv 2 code!!!");
			 */
			
			Instructor instructor = new Instructor ("Madhu", "Patel", "madhu@luv2code.com");
			InstructorDetail instructorDetails = new InstructorDetail("www.youtube.com", "Guitar");
			
			
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
			
		} finally {
			factory.close();
		}
	}

}
