package com.example.demo.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Department {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	
    @Column(name="department_name",unique=true)
	private String departmentName;
	
  
    //physicians
  	@OneToMany(
  	        mappedBy = "department",
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
          	physician.setDepartment(this);}
  	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}



}
