package repn.model;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import repn.util.DateUtils;

@Entity
@Table(name="USER", catalog="",  uniqueConstraints={@UniqueConstraint(columnNames = "login"), @UniqueConstraint(columnNames = "userSeq")})
public class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3685812333140831737L;
	
	private Integer userSeq;
	private String mail;
	private String login;
	private String firstName;
	private String lastName;
	private Boolean isActive;
	private Integer balance;
	private Calendar createdOn;
	
	public User(){}
	
	public User(String mail, String login, String firstName, String lastName, Boolean isActive, Integer balance){
		this.mail = mail;
		this.login = login;
		this.firstName = firstName;
		this.lastName = lastName;
		this.balance = balance;
		this.isActive = isActive;
		this.createdOn = Calendar.getInstance();
	}

	@Column(name="mail")
	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	
	@Column(name="login", nullable=false,unique=true)
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	@Column(name="firstName")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name="lastName")
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="userSeq",unique=true,nullable=false)
	public Integer getUserSeq() {
		return userSeq;
	}

	public void setUserSeq(Integer userSeq) {
		this.userSeq = userSeq;
	}

	@Column(name="isActive")
	public Boolean isActive() {
		return isActive;
	}
	
	
	public void setActive(Boolean isActive) {
		this.isActive = isActive;
	}

	@Column(name="createOn")
	public Calendar getCreatedOn() {
		return createdOn;
	}

	
	public void setCreatedOn(Calendar createdOn) {
		this.createdOn = createdOn;
	}
	
	@Column(name="balance", nullable=false, updatable=true)
	public Integer getBalance() {
		return balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}

	public String toString(){
		return "User [login: "+login+", mail: "+mail+", firstName: "+firstName+", lastName: "+lastName+", isActive: "+isActive+", balance: "+balance+", createOn: "+DateUtils.format(createdOn)+"]";
	}
	
}
