
  package com.example.demo.model;
  
  import javax.persistence.CascadeType;
import javax.persistence.Column; import javax.persistence.Entity;
import javax.persistence.FetchType;
import
  javax.persistence.GeneratedValue; import javax.persistence.GenerationType;
  import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.CreditCardNumber;
  
  @Entity 
  public class Bill {
  
  @Id
  
  @GeneratedValue(strategy = GenerationType.IDENTITY) 
  private Integer id;
  
  @NotEmpty(message = "select a payment mode") 
  private String paymentmode;
  
  @Max(value = 20000000,message="Amount value too large")
  @Min(value = 0,message="Amount cant be negative")
  @Digits(fraction = 1, integer = 8,message ="Amount contains Invalid characters" )
  @NotNull(message ="Amount is required")
  private Double amount;
  
    

  private String paymentStatus="Not Paid";
  



	
  @Column(name="cardnumber",nullable=true) 
 // @Pattern(regexp = "[0-9]{10}",message = "Enter valid 10 digit credit card number")
  private String cardnumber;
  
  

	//physician
	@OneToOne(cascade = {CascadeType.MERGE} ,
	        fetch = FetchType.LAZY)
	@JoinColumn(name = "description_id", referencedColumnName = "id")
	private Description description;
   
	public Description getDescription() {
		return description;
	}



	public void setDescription(Description description) {
		this.description = description;
	}



	public Bill() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getPaymentmode() {
		return paymentmode;
	}



	public void setPaymentmode(String paymentmode) {
		this.paymentmode = paymentmode;
		if(this.paymentmode.equalsIgnoreCase("cash"))
		{
			this.cardnumber=null;
		}
	}



	public Double getAmount() {
		return amount;
	}



	public void setAmount(Double amount) {
		this.amount = amount;
	}



	public String getCardnumber() {
		return cardnumber;
	}



	public void setCardnumber(String cardnumber) {
		this.cardnumber = cardnumber;
	}



	public String getPaymentStatus() {
	
	return paymentStatus;
}



public void setPaymentStatus(String paymentStatus) {
	this.paymentStatus = paymentStatus;
}

	
  
  }
 