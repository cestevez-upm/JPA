package models.dao.jpa;

import models.dao.ShoppingBasketDAO;
import models.dao.entities.ShoppingBasket;

public class JPAShoppingBasketDAO extends JPATransactionGenericDAO<ShoppingBasket, Integer> implements ShoppingBasketDAO {

	public JPAShoppingBasketDAO() {
		super(ShoppingBasket.class);
	}

}
