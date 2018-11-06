package ie.gmit.sw.model;

import javax.persistence.*;

import org.springframework.stereotype.Component;

@Entity
@Table(name="order_details")
@Component
public class Order {
	
	@Id
	@GeneratedValue
	@Column(name="oid")
	private int oid;
	
	@ManyToOne//(cascade={CascadeType.PERSIST,CascadeType.MERGE})
	@JoinColumn(name="gid")
	private Goods goods;
	
	@ManyToOne//(cascade={CascadeType.PERSIST,CascadeType.MERGE})
	@JoinColumn(name="uid")
	private User user;
	
	@Column(name="date")
	private String date;
	
	@Column(name="amount")
	private String amount;

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
}
