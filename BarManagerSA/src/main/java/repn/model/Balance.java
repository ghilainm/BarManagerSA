package repn.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="Balance", catalog="",  uniqueConstraints={@UniqueConstraint(columnNames = "balanceSeq")})
public class Balance {

	private Integer balanceSeq;
	private Double balance;
	
	public Balance(){}
	
	public Balance(Integer balanceSeq, Double balance) {
		super();
		this.balanceSeq = balanceSeq;
		this.balance = balance;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="balanceSeq", nullable=false, updatable=false, unique=true)
	public Integer getBalanceSeq() {
		return balanceSeq;
	}
	public void setBalanceSeq(Integer balanceSeq) {
		this.balanceSeq = balanceSeq;
	}
	
	@Column(name="balance", nullable=false)
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
}
