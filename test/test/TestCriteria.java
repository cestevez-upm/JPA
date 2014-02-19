package test;

import java.util.List;

import models.dao.DAOFactory;
import models.dao.UserDAO;
import models.dao.entities.User;

public class TestCriteria {

	public static void main(String[] args) {
		UserDAO ud=  DAOFactory.getFactory().getUserDAO();
		User u4,u5,u6;
		ud.create(new User(1,"untro n dos",""));
		ud.create(new User(2,"dos d tres",""));
		ud.create(new User(3,"tres",""));
		u4=new User(4,"cuatro","");
		u4.setLevel(4);
		ud.create(u4);
		u5=new User(5,"cinco","");
		u5.setLevel(4);
		ud.create(u5);
		u6=new User(6,"seis","");
		u6.setLevel(6);
		ud.create(u6);
		
		String[] attributes={"name"};
		String[] values={"%re%"};
		List<User> res = DAOFactory.getFactory().getUserDAO().find(attributes, values);
		System.out.println(res);
	}

}
