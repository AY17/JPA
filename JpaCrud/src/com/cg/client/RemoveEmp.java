package com.cg.client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cg.entity.Emp;

public class RemoveEmp {

	


	public static void main(String[] args) {
	EntityManagerFactory emf =Persistence.createEntityManagerFactory("jpacrud");	
	EntityManager em = emf.createEntityManager();
	EntityTransaction tx = em.getTransaction();
	
	Emp emp = em.find(Emp.class, 1005);
	if(emp != null) {
	
		try {
			tx.begin();
			em.remove(emp);
			
			tx.commit();
			System.out.println("row deleted");
			
		}catch(Exception ex) {
			if(tx != null)tx.rollback();
			System.out.println(ex.getMessage());
		}
		
	}else {
		System.out.println("row not found");
	}
	
	em.close();
	emf.close();
		
	}
}
