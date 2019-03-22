package ie.gmit.sw.models;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.*;

public class OrderInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private String username;
	private String name;
	private String date;
	private String amounts;
	private BigDecimal price;
	private BigDecimal totalPrice;
	private String photo;
	
	public OrderInfo() {
	}
	
	public OrderInfo(String id, String username, String name, String date, String amounts, BigDecimal price,
			BigDecimal totalPrice, String photo) {
		super();
		this.id = id;
		this.username = username;
		this.name = name;
		this.date = date;
		this.amounts = amounts;
		this.price = price;
		this.totalPrice = totalPrice;
		this.photo = photo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getAmounts() {
		return amounts;
	}

	public void setAmounts(String amounts) {
		this.amounts = amounts;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
