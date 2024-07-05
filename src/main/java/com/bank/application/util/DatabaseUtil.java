package com.bank.application.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DatabaseUtil {
	
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	
	static {
		entityManagerFactory = Persistence.createEntityManagerFactory("bankServerApplication");
	}
	
	public static EntityManager getManager() {
		if(entityManager == null || !entityManager.isOpen()) {
			entityManager = entityManagerFactory.createEntityManager();
			System.out.println("Entity is loaded");
		}
		return entityManager;
	}

}
