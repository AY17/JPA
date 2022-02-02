package com.cg.client;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.cg.entity.Emp;

public class ProjectionDemo {
	public static void main(String[] args) {
		EntityManagerFactory emf =Persistence.createEntityManagerFactory("jpacrud");	
		EntityManager em = emf.createEntityManager();
		
		String jpql = "select empName,empSal from Emp";
		Query qry = em.createQuery(jpql);
		List<Object[]> lst = qry.getResultList();
		
		em.close();
		emf.close();
		for(Object[] arr: lst) {
			System.out.println(arr[0] + " "+arr[1]);
		}
		
		}
}
