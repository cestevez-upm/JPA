package test;

import models.dao.CategoryDAO;
import models.dao.DAOFactory;
import models.dao.entities.Category;
import upm.jbb.IO;

public class TestIOCategory {
	private CategoryDAO dao;

	public TestIOCategory() {
		this.dao = DAOFactory.getFactory().getCategoryDAO();
	}

	public void create() {
		Category cat = new Category();
		cat.setId(IO.in.readInt("Id"));
		cat.setName(IO.in.readString("Name"));
		cat.setDescription(IO.in.readString("Description"));
		dao.create(cat);
	}

	public void find() {
		Category cat = dao.read(IO.in.readInt("Identificador"));
		IO.out.println("find: " + cat);
	}

	public void delete() {
		Category cat = dao.read(IO.in.readInt("Identificador"));
		if (cat == null) IO.out.println("No encontrado");
		else dao.delete(cat);
	}

	public void update() {
		Category cat = dao.read(IO.in.readInt("Identificador"));
		if (cat == null) IO.out.println("No encontrado");
		else {
			cat.setName(IO.in.readString("Name: "+cat.getName()));
			cat.setDescription(IO.in.readString("Description: "+cat.getDescription()));
			if (cat != null) dao.update(cat);
		}
	}

	public static void main(String[] args) {
		IO.in.addController(new TestIOCategory());
	}
}