 

package com.cg.client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cg.entity.Emp;

public class UpdateEmp {

	

	public static void main(String[] args) {
	EntityManagerFactory emf =Persistence.createEntityManagerFactory("jpacrud");	
	EntityManager em = emf.createEntityManager();
	EntityTransaction tx = em.getTransaction();
	
	Emp emp = em.find(Emp.class, 1002);
	if(emp != null) {
		emp.setEmpSal(32000.00);
		try {
			tx.begin();
			em.merge(emp);
			tx.commit();
			System.out.println("row updated");
			
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
