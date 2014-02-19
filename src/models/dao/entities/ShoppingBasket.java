package models.dao.entities;

import java.io.Serializable;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
public class ShoppingBasket implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private int id;
	@Temporal(TemporalType.DATE)
	private java.util.Calendar fecha;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "shoppingBasket")
	private Set<Product> products= new HashSet<Product>();

	public ShoppingBasket() {
		super();
	}

	public ShoppingBasket(int id, Calendar fecha) {
		super();
		this.id = id;
		this.fecha = fecha;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public java.util.Calendar getFecha() {
		return this.fecha;
	}

	public void setFecha(java.util.Calendar fecha) {
		this.fecha = fecha;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void addProducts(Product product) {
		this.products.add(product);
	}

	public void removeProduct(Product product) {
		this.products.remove(product);
	}

}
