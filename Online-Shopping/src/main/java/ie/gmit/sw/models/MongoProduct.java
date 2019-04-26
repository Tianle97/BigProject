package ie.gmit.sw.models;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

public class MongoProduct implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String id;
	private String name;
	private BigDecimal price;
	private String type;
	private String photo;
	private int stocks;
	
	
	public MongoProduct(){
		
	}
	
	public MongoProduct(String id, String name, BigDecimal price, String type, String photo, int stocks) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.type = type;
		this.photo = photo;
		this.stocks = stocks;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public int getStocks() {
		return stocks;
	}

	public void setStocks(int stocks) {
		this.stocks = stocks;
	}
	
}
