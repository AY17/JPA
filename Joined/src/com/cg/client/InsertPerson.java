package com.cg.client;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.cg.entity.Passport;

public class InsertPerson {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpacrud");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		Passport obj =new Passport();
		obj.setPersonId(1);
		obj.setPname("amar");
		obj.setPassPortNo("A-2015");

		tx.begin();
		em.persist(obj);
		tx.commit();
		em.close();
		emf.close();
		System.out.println("Done");
	}
}
