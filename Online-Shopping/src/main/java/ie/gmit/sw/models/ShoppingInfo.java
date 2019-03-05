package ie.gmit.sw.models;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.*;

import org.springframework.stereotype.Component;

public class ShoppingInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private String userName;
	private String date;
	private String amount;
	private BigDecimal price;
	
	public ShoppingInfo() {
	}

	public ShoppingInfo(String id, String userName, String date, String amount, BigDecimal price) {
		this.id = id;
		this.userName = userName;
		this.date = date;
		this.amount = amount;
		this.price = price;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
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
}
