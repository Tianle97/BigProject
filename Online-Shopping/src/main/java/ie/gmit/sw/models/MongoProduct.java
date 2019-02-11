package ie.gmit.sw.models;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.*;

import org.bson.types.ObjectId;


public class MongoProduct implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8254263003154089546L;

	@Id
	private ObjectId id;
	private String name;
	private BigDecimal price;
	private String type;
	private String photo;
	
	public MongoProduct(){
		
	}
	
	public MongoProduct(ObjectId id, String name, BigDecimal price, String type, String photo) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.type = type;
		this.photo = photo;
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
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
}
