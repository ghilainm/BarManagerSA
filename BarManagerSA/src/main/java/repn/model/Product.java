package repn.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="PRODUCT", catalog="",  uniqueConstraints={@UniqueConstraint(columnNames = "productId"), @UniqueConstraint(columnNames = "productSeq")})
public class Product implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6464029797956284719L;
	
	private String productId;
	private Long productSeq;
	private String price;
	private Integer numberInStock;
	
	public Product(){}
	
	public Product(String productId, String price, Integer numberInStock) {
		super();
		this.productId = productId;
		this.price = price;
		this.numberInStock = numberInStock;
	}

	@Column(name="productId",unique=true,nullable=false)
	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	@Column(name="price",nullable=false)
	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="productSeq",unique=true,nullable=false,updatable=false)
	public Long getProductSeq() {
		return productSeq;
	}
	
	public void setProductSeq(Long productSeq){
		this.productSeq = productSeq;
	}

	@Column(name="numberInStock", updatable=true, nullable=false)
	public Integer getNumberInStock() {
		return numberInStock;
	}

	public void setNumberInStock(Integer numberInStock) {
		this.numberInStock = numberInStock;
	}
	
	public String toString(){
		return "productId : "+productId+", price : "+price;
	}
	
}
