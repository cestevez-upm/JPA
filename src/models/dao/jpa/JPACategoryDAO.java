package models.dao.jpa;

import models.dao.entities.Category;

public class JPACategoryDAO extends JPATransactionGenericDAO<Category, Integer> implements models.dao.CategoryDAO {
    public JPACategoryDAO() {
        super(Category.class);
    }
}
