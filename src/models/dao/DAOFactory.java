package models.dao;

import models.dao.jpa.JPADAOFactory;

public abstract class DAOFactory {
    // Será mejor por inyección de objetos
    private static DAOFactory factory = new JPADAOFactory();

    public static DAOFactory getFactory() {
        return factory;
    }

    public abstract UserDAO getUserDAO();

    public abstract UserDetailDAO getUserDetailDAO();

    public abstract CategoryDAO getCategoryDAO();

    public abstract ShoppingBasketDAO getShoppingBasketDAO();

    public abstract ProductDAO getProductDAO();

}
