package ie.gmit.sw.model;

import java.math.BigDecimal;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="goods_details")
public class Goods {
	
	@Id
	@GeneratedValue
	@Column(name="gid")
	private int gid;
	
	@Size(min=1,max=250,message="size must be between 1 and 250")
	@NotEmpty
	@Column(name="name")
	private String name;
	
	@NotNull
	@Column(name="price")
	private BigDecimal price;
	
	@NotEmpty(message="may not be empty")
	@Column(name="address")
	private String address;

	public int getGid() {
		return gid;
	}

	public void setGid(int gid) {
		this.gid = gid;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
