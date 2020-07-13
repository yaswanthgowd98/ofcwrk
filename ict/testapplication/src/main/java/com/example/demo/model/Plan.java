 package com.example.demo.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

@Entity
public class Plan {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotEmpty(message="please select a plan")
	private String planName;
	
	private Double cost;
	
	//patients
	@OneToMany(
	        mappedBy = "plan",
	        cascade = CascadeType.MERGE,
	        fetch = FetchType.LAZY
	    )
	    private Set<Patient> patients = new HashSet<>();
	
	public Set<Patient> getPatients() {
        return patients;
    }

    public void setPatients(Set<Patient> patients) {
    	this.patients = patients;
        for (Patient patient : patients) {
        	patient.setPlan(this);}
       }
	
    //Physicians
    @OneToMany(
	        mappedBy = "plan",
	        cascade = CascadeType.MERGE,
	        fetch = FetchType.LAZY
	    )
	    private Set<Physician> physicians = new HashSet<>();
	
	public Set<Physician> getPhysicians() {
        return physicians;
    }

    public void setPhysicians(Set<Physician> physicians) {
    	this.physicians = physicians;
        for (Physician physician : physicians) {
        	physician.setPlan(this);}
       }
    
    
  
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getPlanName() {
		return planName;
	}
	public void setPlanName(String planName) {
		this.planName = planName;
	}
	public Double getCost() {
		return cost;
	}
	public void setCost(Double cost) {
		this.cost = cost;
	}

}

