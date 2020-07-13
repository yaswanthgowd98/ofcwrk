package com.example.demo.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.MetaValue;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.format.annotation.DateTimeFormat;

import com.sun.istack.Nullable;


@Entity

public class Patient  {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	 
	@NotEmpty(message="First name is required")
	@Size(min=3, max=20,message="First Name should be min 3 and max 20 characters")
	@Pattern(regexp = "[a-z-A-Z]*", message = "First name has invalid characters")
	@Column(name="first_name",unique=false)
	private String firstName;
	
	@NotEmpty(message="Last Name is required")
	@Size(min=3, max=20,message="min 3 and max 20 is required")
	@Pattern(regexp = "[a-z-A-Z]*", message = "Last name has invalid characters")
	@Column(name="last_name",unique=false)
	private String lastName;
	
	
  
	@NotNull(message="Date of Birth is required")
	@PastOrPresent(message="Date of Birth should be past or present")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dateOfBirth;
	
	@NotEmpty(message="email is required")
	@Email(message="enter valid email")
	private String email;
	
	
	@NotEmpty(message="Contact number is required")
	
	@Pattern(regexp = "[0-9]{10}",message = "Enter valid 10 digit phone number")
	private String contact;
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}


	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	
	    //constructor
	    public Patient() {
			super();
			// TODO Auto-generated constructor stub
		}
	    
	
	
	
	
	
	//Description
	@OneToMany(cascade = CascadeType.PERSIST,
	        fetch = FetchType.LAZY ,mappedBy = "patient")
	
    private Set<Description> descriptions = new HashSet<>();
	
	

    public Set<Description> getDescriptions() {
		return descriptions;
	}
	public void setDescriptions(Set<Description> descriptions) {
		this.descriptions = descriptions;
		 for (Description description : descriptions) {
			 description.setPatient(this);}
	}
	
	   
	

	
	
	


	//state
	@ManyToOne(cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
    @JoinColumn(name = "state_id", referencedColumnName = "id")
	
    private State state;
	
	public State getState() {
		return state;
	}
	
	public void setState(State state) {
		this.state = state;
		//this.state.setStatename(state.getStatename());
		state.getPatients().add(this);
	}
	
	
	//plan
	@ManyToOne(cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
    @JoinColumn(name = "plan_id", referencedColumnName = "id")
	
	private Plan plan;
	
	
	public Plan getPlan() {
		return plan;
	}

	public void setPlan(Plan plan) {
		this.plan = plan;
		plan.getPatients().add(this);
	}

	

		
		
		
		
}
