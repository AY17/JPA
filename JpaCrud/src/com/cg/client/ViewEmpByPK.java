package com.cg.client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.cg.entity.Emp;

public class ViewEmpByPK {
	

	public static void main(String[] args) {
	EntityManagerFactory emf =Persistence.createEntityManagerFactory("jpacrud");	
	EntityManager em = emf.createEntityManager();

 
	Emp emp = em.find(Emp.class, 1002);
	
	if(emp != null)
		System.out.println(emp);
	else
		System.out.println("now row is found");
	

	
	
	em.close();
	emf.close();
}
	
}
