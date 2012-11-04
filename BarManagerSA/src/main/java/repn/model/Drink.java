package repn.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="DRINK", catalog="",  uniqueConstraints={@UniqueConstraint(columnNames = "drinkId"), @UniqueConstraint(columnNames = "drinkSeq")})
public class Drink {

	private String drinkId;
	private Integer drinkSeq;
	private Integer price;
	
	public Drink(String drinkId, Integer price) {
		super();
		this.drinkId = drinkId;
		this.price = price;
	}

	@Id
	@Column(name="drinkId",unique=true,nullable=false)
	public String getDrinkId() {
		return drinkId;
	}

	public void setDrinkId(String drinkId) {
		this.drinkId = drinkId;
	}

	public Integer getPrice() {
		return price;
	}

	@Column(name="price",nullable=false)
	public void setPrice(Integer price) {
		this.price = price;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="drinkSeq",unique=true,nullable=false,updatable=false)
	public Integer getDrinkSeq() {
		return drinkSeq;
	}
	
	public void setDrinkSeq(Integer drinkSeq){
		this.drinkSeq = drinkSeq;
	}
	
}
