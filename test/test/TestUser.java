package test;

import models.dao.DAOFactory;
import models.dao.UserDAO;
import models.dao.UserDetailDAO;
import models.dao.entities.User;
import models.dao.entities.UserDetail;

public class TestUser {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//DAOFactory.getFactory().createTables();
		
		UserDAO ud = DAOFactory.getFactory().getUserDAO();
		UserDetailDAO udd = DAOFactory.getFactory().getUserDetailDAO();

		User u1 = new User(1, "Uno", "1");
		ud.create(u1);

		User u2 = new User(2, "Dos", "2");
		u2.setDetail(new UserDetail("detalles 2", u2));
		ud.create(u2);

		User u3 = new User(3, "Tres", "3");
		u3.setDetail(new UserDetail("detalles 3", u3));
		ud.create(u3);
		u1.setDetail(new UserDetail("detalles 1", u1));
		ud.update(u1);

		u2.getDetail().setDetail("detalles 2 cambiado");
		ud.update(u2);

		// JPA: Se borra en la relación, pero se queda en la tabla
		u3.setDetail(null);
		ud.update(u3);

		User u4 = ud.read(2);
		System.out.println("u4 (2):" + u4);

		User u5 = ud.read(3);
		System.out.println("u5 (3): " + u5);

		UserDetail ud1 = udd.read(1);
		System.out.println(ud1.getUser());

		System.out.println("...FIN");

	}

}
