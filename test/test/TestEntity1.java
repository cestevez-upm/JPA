package test;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import basic.Entity1;

public class TestEntity1 {
	
	public static void main(String[] args) {
		EntityManager em = Persistence.createEntityManagerFactory("jpa").createEntityManager();
		em.getTransaction().begin();
		em.persist(new Entity1(1,"uno",1));
		em.persist(new Entity1(2,"uno",1));
		em.persist(new Entity1(2,"uno",1));
		em.getTransaction().commit();
		
	}
	public static void main2(String[] args) {
		EntityManager em = Persistence.createEntityManagerFactory("jpa").createEntityManager();
		em.getTransaction().begin();
		try{
			System.out.println(">>>"+em.getTransaction().isActive());
		em.persist(new Entity1(1,"uno",1));
		em.persist(new Entity1(1,"dos",1));
		em.persist(new Entity1(3,"tres",1));
		em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(">>>"+em.getTransaction().isActive());
		}
		
	}
}
