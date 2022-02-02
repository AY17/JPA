package com.cg.client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cg.entity.Emp;

public class InsertEmployee {

	public static void main(String[] args) {
	EntityManagerFactory emf =Persistence.createEntityManagerFactory("jpacrud");	
	EntityManager em = emf.createEntityManager();
	EntityTransaction tx = em.getTransaction();
	
	Emp emp =new Emp();
	
	emp.setEmpId(1005);
	emp.setEmpName("shiva ");
	emp.setDesig("associate");
	emp.setEmpSal(73000.00);
	
	try {
		tx.begin();
		em.persist(emp);
		
		tx.commit();
		System.out.println("row added");
		
	}catch(Exception ex) {
		System.out.println(ex.getMessage());
		if(tx!= null) tx.rollback();
		
	}
	em.close();
	emf.close();
	System.out.println("table created");
	}

}
