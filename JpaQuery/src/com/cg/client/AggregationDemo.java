package com.cg.client;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.cg.entity.Emp;

public class AggregationDemo {

	public static void main(String[] args) {
		EntityManagerFactory emf =Persistence.createEntityManagerFactory("jpacrud");	
		EntityManager em = emf.createEntityManager();
		
		String jpql = "select sum(empSal) from Emp";
		/*Query qry = em.createQuery(jpql);
		double sum = (Double) qry.getSingleResult();*/
		
		TypedQuery<Double> qry = em.createQuery(jpql,Double.class);
		double sum = (Double) qry.getSingleResult();
		
		//List<Object[]> lst = qry.getResultList();
		
		em.close();
		emf.close();
		
			System.out.println("sum" +sum);
		
		
		}
}
