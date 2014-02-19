package test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import models.dao.DAOFactory;
import models.dao.UserDAO;
import models.dao.entities.User;

public class TestJPQL {

	public static void main(String[] args) {
		UserDAO ud=  DAOFactory.getFactory().getUserDAO();
		User u1,u4,u5;
		u1=new User(1,"cuatro","");
		ud.create(u1);
		u4=new User(4,"cuatro","");
		u4.setLevel(4);
		u5=new User(5,"cinco","");
		ud.create(u4);
		u5.setLevel(5);
		ud.create(u5);
		List<User> res = DAOFactory.getFactory().getUserDAO().getByLevel(4);
		System.out.println(res);
		
	    EntityManager em= Persistence.createEntityManagerFactory("jpa").createEntityManager();

		String jpql1 = "SELECT u.id FROM User u";
		List<?> res2 =  em.createQuery(jpql1).getResultList();

		String jpql2 = "SELECT u FROM User u WHERE u.id='1'";
		Query query = em.createQuery(jpql2);
		User res3 =  (User)query.getSingleResult();

		query = em.createNamedQuery("getByLevel");
		query.setParameter("level", 3);
		List<?> res4 = query.getResultList();

        System.out.println(res2);
        System.out.println(res3);
        System.out.println(res4);

	}

}
