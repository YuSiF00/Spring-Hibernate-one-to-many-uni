package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class DeleteDemo {

	public static void main(String[] args) {

		// create session Factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			int instructorId = 2;

			// start a transaction
			session.beginTransaction();

			// get the instructor with primary key id
			Instructor tempInstructor = session.get(Instructor.class, instructorId);

			System.out.println("Found instructor : " + tempInstructor);

			// delete the instructor
			if (tempInstructor != null) {
				System.out.println("Deleting instructor... " + tempInstructor);
				session.delete(tempInstructor);

			}

			// commit transaction
			session.getTransaction().commit();

		} finally {
			// TODO: handle finally clause
			factory.close();
		}

	}

}
