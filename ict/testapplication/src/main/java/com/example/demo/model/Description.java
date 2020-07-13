package com.example.demo.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;
@Entity
public class Description {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	
    @NotEmpty(message="Symptoms are required")
	private String symptoms;
	@NotEmpty(message="Description is required")
	private String desp;
	
	@NotNull(message="Date of Diagnosis is required")
	@PastOrPresent(message="Date of Diagnosis should be past or present")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dateOfDiagnosis;

	
	@Column(name="followup",nullable = true)
	private boolean followup;
	
	@Transient
	private String followupcon;
	



	//@CreationTimestamp
	@Column(name="followupdate",nullable = true)
	@Future(message="Follow up Date should be in future")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date followupdate;
	
	@OneToOne(cascade = {CascadeType.MERGE} ,
	        fetch = FetchType.LAZY,mappedBy = "description")
	
	private Bill bill;
   
	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

	
	
	
	//physician
	@OneToOne(cascade = {CascadeType.PERSIST} ,
	        fetch = FetchType.LAZY)
	@JoinColumn(name = "physician_id", referencedColumnName = "id")
	private Physician physician;

	public Physician getPhysician() {
		return physician;
	}

	public void setPhysician(Physician physician) {
		this.physician = physician;
	}
	
	
	
	//patient
	@ManyToOne(cascade = {CascadeType.PERSIST} ,
	        fetch = FetchType.LAZY)
	@JoinColumn(name = "patient_id", referencedColumnName = "id")
	
	private Patient patient;
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
		patient.getDescriptions().add(this);
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	
	 public String getDesp() {
		return desp;
	}
	public void setDesp(String desp) {
		this.desp = desp;
	}
	
	public boolean isFollowup() {
		return followup;
	}

	public void setFollowup(boolean followup) {
		this.followup = followup;
	}
	
	
	public String getFollowupcon() {
		if(this.isFollowup())
		{
			return "yes";
		}
		else
		{
		return "No";
		}
	}

	public void setFollowupcon(String followupcon) {
		this.followupcon = followupcon;
	}

	public Date getFollowupdate() {
		return followupdate;
	}

	public void setFollowupdate(Date followupdate) {
		this.followupdate = followupdate;
	}
	
	public String getSymptoms() {
		return symptoms;
	}
	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}

	public Date getDateOfDiagnosis() {
		return dateOfDiagnosis;
	}

	public void setDateOfDiagnosis(Date dateOfDiagnosis) {
		this.dateOfDiagnosis = dateOfDiagnosis;
	}

	public Description() {
 		super();
   }
	
	public Description(Integer id, String desp) {
		super();
		this.id = id;
		this.desp = desp;
	}  

	
}
