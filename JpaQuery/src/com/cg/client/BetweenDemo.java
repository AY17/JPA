package com.cg.client;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.cg.entity.Emp;

public class BetweenDemo {

	

	public static void main(String[] args) {
	EntityManagerFactory emf =Persistence.createEntityManagerFactory("jpacrud");	
	EntityManager em = emf.createEntityManager();
	
	String jpql = "from Emp where empSal between :lowsal and :highsal";
	TypedQuery<Emp> qry = em.createQuery(jpql,Emp.class);
	qry.setParameter("lowsal", 32000.0);
	qry.setParameter("highsal", 63000.0);

	List<Emp> lst = qry.getResultList();
	
	em.close();
	emf.close();
	lst.forEach(System.out::println);
	}
	
}


