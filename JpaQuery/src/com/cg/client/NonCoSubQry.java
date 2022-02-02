package com.cg.client;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.cg.entity.Emp;

public class NonCoSubQry {

	

	

	public static void main(String[] args) {
	EntityManagerFactory emf =Persistence.createEntityManagerFactory("jpacrud");	
	EntityManager em = emf.createEntityManager();
	
	String jpql = "from Emp where empSal = (select max(empSal) from Emp)";
	TypedQuery<Emp> qry = em.createQuery(jpql,Emp.class);
	List<Emp> lst = qry.getResultList();
	
	em.close();
	emf.close();
	lst.forEach(System.out::println);
	}
	
}
