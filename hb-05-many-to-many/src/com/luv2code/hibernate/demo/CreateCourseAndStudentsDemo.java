package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

class CreateCourseAndStudentsDemo {

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
						
			// create a course
			Course tempCourse = new Course("PackMan - How to own million points");
			Course tempCourse2 = new Course("MTB - Good Manual for 1 week");
			
			
			// save the course and .. leverage cascade all
			System.out.println("\nSaving the course: "+tempCourse+"\n");
			session.save(tempCourse);
			System.out.println("\nSaving the course: "+tempCourse2+"\n");
			session.save(tempCourse2);
			System.out.println("Courses saved");
			
			// create Student
			Student student1 = new Student("John", "Doe", "john@gmail.com");
			Student student2 = new Student("Mary", "Public", "mary@gmail.com");
			
			// add Student to the course
			tempCourse.addStudent(student1);
			tempCourse.addStudent(student2);

			// add course to the student
			student1.addCourse(tempCourse2);
			
			// save students
			System.out.println("Saving students");
			session.save(student1);
			session.save(student2);
			System.out.println("Students saved: "+tempCourse.getStudents()+", \n"+tempCourse2.getStudents());
			
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
