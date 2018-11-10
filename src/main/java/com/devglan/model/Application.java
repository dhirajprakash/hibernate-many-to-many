package com.devglan.model;

import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class Application {
	
	public static void main(String[] args) {
		
		createStudent();
	}

	public static SessionFactory getSessionFactory() {
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration
				.buildSessionFactory(builder.build());
		return sessionFactory;
	}

	public static void createStudent() {
		System.out.println("****************Creating Student*************");
		Student student = new Student();
		student.setName("John");
		student.setAge(23);
		Course course1 = new Course("John");
		Course course2 = new Course("Rohan");
		student.setCourses(Arrays.asList(course1, course2));
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		session.save(student);
		session.save(course1);
		session.save(course2);
		session.getTransaction().commit();
		session.close();
		System.out.println("Student Created Successfully" + student.toString());

	}

}
