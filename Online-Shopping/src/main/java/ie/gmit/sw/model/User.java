package ie.gmit.sw.model;

import java.math.BigDecimal;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

@Entity
@Table(name="user_detail")
@Component
public class User {
	
	@Id
	@GeneratedValue
	@Column(name="uid")
	private int uid;
	
	@NotNull(message="may not empty")
	@Column(name="username")
	private String username;
	
	@NotNull(message="may not empty")
	@Column(name="password")
	private String password;
	
	@Column(name="balance")
	private BigDecimal balance;
	
	@NotNull(message="may not empty")
	@Column(name="balance")
	private String address;

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
}
