package test;

import java.util.GregorianCalendar;

import models.dao.DAOFactory;
import models.dao.ProductDAO;
import models.dao.ShoppingBasketDAO;
import models.dao.entities.Product;
import models.dao.entities.ShoppingBasket;

public class TestShoppingBasket {
    public static void main(String[] args) {
        ShoppingBasketDAO sbd = DAOFactory.getFactory().getShoppingBasketDAO();

        ShoppingBasket sb = new ShoppingBasket(1, new GregorianCalendar());
        Product p1 = new Product(1, 3, "producto 1", sb);
        sb.addProducts(p1);
        sb.addProducts(new Product(2, 4, "producto 2", sb));
        sb.addProducts(new Product(3, 1, "producto 3", sb));
        sbd.create(sb);

        // Error: Se debe elimiar el producto de la entidad
        sb.removeProduct(p1);
        sbd.update(sb);

        // Se debe eliminar manualmente
        ProductDAO dao = DAOFactory.getFactory().getProductDAO();
        Product p2 = dao.read(1);
        dao.delete(p2);
        // DAOFactory.getFactory().getProductDAO().deleteByID(1);
    }
}
