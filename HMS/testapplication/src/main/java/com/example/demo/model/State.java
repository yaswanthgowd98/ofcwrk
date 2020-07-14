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
public class State {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty(message="please select state")
	private String statename;
	
	//patients
	@OneToMany(
	        mappedBy = "state",
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
        	patient.setState(this);}
       }
    
    //physicians
	@OneToMany(
	        mappedBy = "state",
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
        	physician.setState(this);}
	}

	
    

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStatename() {
		return statename;
	}

	public void setStatename(String statename) {
		this.statename = statename;
	}

	public State(Integer id, String statename) {
		super();
		this.id = id;
		this.statename = statename;
	}

	public State() {
		super();
		
		// TODO Auto-generated constructor stub
	}
	
}




