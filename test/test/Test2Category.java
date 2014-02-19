package test;

import models.dao.CategoryDAO;
import models.dao.DAOFactory;
import models.dao.entities.Category;

import org.apache.log4j.Logger;

public class Test2Category {
    public static void main(String[] args) {
        CategoryDAO cd = DAOFactory.getFactory().getCategoryDAO();
        // cd.createTable();
        Category c1, c2, c3;
        c1 = new Category(1, "uno", "Categoría uno");
        c2 = new Category(2, "dos", "Duplicado");
        c3 = new Category(3, "tres", "Categoría tres");

        cd.begin();
        try {
            cd.create(c1);
            cd.create(c2);
            cd.create(c3);
            cd.commit();
        } catch (Exception e) {
            cd.rollback();
        }

        Logger.getLogger(Test2Category.class).info(">>>" + cd.findAll());
    }
}
