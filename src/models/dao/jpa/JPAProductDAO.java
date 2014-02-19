package models.dao.jpa;

import models.dao.ProductDAO;
import models.dao.entities.Product;

public class JPAProductDAO extends JPATransactionGenericDAO<Product, Integer> implements ProductDAO {

	public JPAProductDAO() {
		super(Product.class);
	}

}
