package models.dao.entities;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

@Entity
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	private int id;
	private int amount;
	private String description;
	@ManyToOne
	@JoinColumn
	private ShoppingBasket shoppingBasket;

	public Product() {
		super();
	}

	public Product(int id, int amount, String description, ShoppingBasket shoppingBasket) {
		this.id = id;
		this.amount = amount;
		this.description = description;
		this.shoppingBasket = shoppingBasket;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAmount() {
		return this.amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ShoppingBasket getShoppingBasket() {
		return shoppingBasket;
	}

	public void setShoppingBasket(ShoppingBasket shoppingBasket) {
		this.shoppingBasket = shoppingBasket;
	}

	@Override
	public int hashCode() {
		return id;
	}

	@Override
	public boolean equals(Object other) {
		if (other == null) return false;
		if (getClass() != other.getClass()) return false;
		return other.hashCode()==this.hashCode();
	}

}
