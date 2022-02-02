package com.cg.client;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class GroupByDemo {

	public static void main(String[] args) {
		EntityManagerFactory emf =Persistence.createEntityManagerFactory("jpacrud");	
		EntityManager em = emf.createEntityManager();
		
		String jpql = "select  desig, count(empId), avg(empSal) from Emp group by desig ";
		Query qry = em.createQuery(jpql);
		List<Object[]> lst = qry.getResultList();
		
		em.close();
		emf.close();
		for(Object[] arr: lst) {
			System.out.println(arr[0] + " "+arr[1] + " " +arr[2]);
		}
		
	}	
}
