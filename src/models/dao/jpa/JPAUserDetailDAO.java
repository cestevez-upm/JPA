package models.dao.jpa;

import models.dao.UserDetailDAO;
import models.dao.entities.UserDetail;

public class JPAUserDetailDAO extends JPATransactionGenericDAO<UserDetail, Integer> implements UserDetailDAO {

	public JPAUserDetailDAO() {
		super(UserDetail.class);
	}

	@Override
	public UserDetail findByUserId(int userId) {
		String jpql = "SELECT ud FROM UserDetail ud WHERE ud.user.id = " + userId;
		UserDetail ud = (UserDetail) em.createQuery(jpql).getSingleResult();
		return ud;
	}

}
