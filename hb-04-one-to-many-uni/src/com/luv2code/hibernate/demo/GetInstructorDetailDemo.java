package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class GetInstructorDetailDemo {

	public static void main(String[] args) {

		// create session Factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			int instructorDetailId = 2;

			// start a transaction
			session.beginTransaction();

			// get the instructor detail object
			InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, instructorDetailId);

			// print instructor detail
			System.out.println("Instructor Detail : " + tempInstructorDetail);

			// print the associated instructor
			System.out.println("\n\nInstructor : " + tempInstructorDetail.getInstructor());

			// commit transaction
			session.getTransaction().commit();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			// TODO: handle finally clause
			session.close();
			factory.close();
		}

	}

}
