package models.dao.jpa;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import models.dao.CategoryDAO;
import models.dao.DAOFactory;
import models.dao.ProductDAO;
import models.dao.ShoppingBasketDAO;
import models.dao.UserDAO;
import models.dao.UserDetailDAO;

public class JPADAOFactory extends DAOFactory {
    private static final String PERSISTENCE_UNIT = "jpa";

    private EntityManager em;

    public JPADAOFactory() {
        this.em = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT).createEntityManager();
    }

    public EntityManager getEm() {
        if (!em.isOpen())
            this.em = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT)
                    .createEntityManager();
        return em;
    }

    @Override
    public CategoryDAO getCategoryDAO() {
        return new JPACategoryDAO();
    }

    @Override
    public UserDAO getUserDAO() {
        return new JPAUserDAO();
    }

    @Override
    public UserDetailDAO getUserDetailDAO() {
        return new JPAUserDetailDAO();
    }

    @Override
    public ShoppingBasketDAO getShoppingBasketDAO() {
        return new JPAShoppingBasketDAO();
    }

    @Override
    public ProductDAO getProductDAO() {
        return new JPAProductDAO();
    }

}
