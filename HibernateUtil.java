package com.example;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {

	private static SessionFactory sessionFactory = buildSessionFactory();
	 
	   private static SessionFactory buildSessionFactory() 
	   {
	      try
	      {
	         if (sessionFactory == null) 
	         {
	            StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
	                  .configure("hibernate.cfg.xml").build();//reading properties from configuration file
	             
	            Metadata metaData = new MetadataSources(standardRegistry)
	                  .getMetadataBuilder()
	                  .build();//data about all configuration properties
	             
	            sessionFactory = metaData.getSessionFactoryBuilder().build();//building sessionFactory object
	         }
	         return sessionFactory;
	      } catch (Throwable ex) {
	         throw new ExceptionInInitializerError(ex);
	      }
	   }

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	 
	  
	 
}
