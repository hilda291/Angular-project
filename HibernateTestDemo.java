package com.example;

import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.example.entity.Employee;

public class HibernateTestDemo {

	public static void main(String[] args) {
		// Create an Employee object with a specific joining date
		LocalDate customJoiningDate = LocalDate.of(2024, 5, 18);
		Employee employee = new Employee(122, "Raj", 52000, "Developer", customJoiningDate);

		insertEmployee(employee);

		System.out.println(employee);
	}

	public static void insertEmployee(Employee employee) {
		//try with resource: no need to close connection, session
		try (Session session = HibernateUtil.getSessionFactory().openSession()) 
		{
			Transaction transaction = session.beginTransaction();
			session.save(employee); //to insert emp record
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
