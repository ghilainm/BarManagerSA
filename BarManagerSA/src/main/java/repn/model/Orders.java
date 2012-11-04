package repn.model;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="ORDERS", catalog="",  uniqueConstraints={@UniqueConstraint(columnNames = "orderSeq")})
public class Orders {
	
	private Integer orderSeq;
	private User user;
	private Product product;
	private Calendar createdOn;
	
	public Orders(){}
	
	public Orders(User user, Product product, Calendar createdOn) {
		super();
		this.user = user;
		this.product = product;
		this.createdOn = createdOn;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="orderSeq", nullable=false, updatable=false, unique=true)
	public Integer getOrderSeq() {
		return orderSeq;
	}

	public void setOrderSeq(Integer orderSeq) {
		this.orderSeq = orderSeq;
	}
	
	@ManyToOne(cascade=CascadeType.ALL, optional=false, fetch=FetchType.EAGER)
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne(cascade=CascadeType.ALL, optional=false, fetch=FetchType.EAGER)
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Column(name="createdOn", nullable=false)
	public Calendar getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Calendar createdOn) {
		this.createdOn = createdOn;
	}
}
