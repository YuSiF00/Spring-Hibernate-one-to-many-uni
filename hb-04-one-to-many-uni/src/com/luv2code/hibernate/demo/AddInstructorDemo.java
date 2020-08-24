package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class AddInstructorDemo {

	public static void main(String[] args) {

		// create session Factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// create objects
			Instructor tempInstructor = new Instructor("Kenan", "Sultanov", "kenansultanov@gmail.com");
			InstructorDetail temInstructorDetail = new InstructorDetail("http://kenansultanov/youtube", "play a football");

			// associate objects
			tempInstructor.setInstructorDetail(temInstructorDetail);

			// start a transaction
			session.beginTransaction();

			// save the instructor
			System.out.println("Saving Instructor...  " + tempInstructor);
			session.save(tempInstructor); // also save instructor detail for cascade all

			// commit transaction
			session.getTransaction().commit();

		} finally {
			// TODO: handle finally clause
			session.close();
			factory.close();
		}

	}

}
