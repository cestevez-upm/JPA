package test;

import models.dao.CategoryDAO;
import models.dao.DAOFactory;
import models.dao.entities.Category;

public class TestCategory {
    public static void main(String[] args) {
        CategoryDAO cd = DAOFactory.getFactory().getCategoryDAO();
        // cd.createTable();
        Category c1, c2, c3, c3b, c4, c5;
        c1 = new Category(1, "uno", "Categoría uno");
        c2 = new Category(2, "dos", "Categoría dos");
        c3 = new Category(3, "tres", "Categoría tres");
        c3b = new Category(3, "tres", "Duplicado");
        cd.create(c1);
        cd.create(c2);
        cd.create(c3);
        cd.create(c3b);

        cd.delete(c2);

        c4 = cd.read(3);
        c4.setDescription("Nueva...");
        cd.update(c4);

        c5 = new Category(1, "uno", "Otro de uno");
        cd.update(c5);

        cd.create(new Category(6, "seis", "Categoría seis"));
        System.out.println(cd.findAll());
    }
}
