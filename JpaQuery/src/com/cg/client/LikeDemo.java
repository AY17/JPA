package com.cg.client;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.cg.entity.Emp;

public class LikeDemo {


	public static void main(String[] args) {
	EntityManagerFactory emf =Persistence.createEntityManagerFactory("jpacrud");	
	EntityManager em = emf.createEntityManager();
	
	String jpql = "from Emp where empName like ?";
	TypedQuery<Emp> qry = em.createQuery(jpql,Emp.class);
	qry.setParameter(1, "%kumar");
	List<Emp> lst = qry.getResultList();
	
	em.close();
	emf.close();
	lst.forEach(System.out::println);
	}
	
}
