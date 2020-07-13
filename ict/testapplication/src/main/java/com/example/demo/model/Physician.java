package com.example.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
@Entity
public class Physician {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotEmpty(message="First name is required")
	@Pattern(regexp = "[a-z-A-Z]*", message = "First name has invalid characters")
	private String firstName;
	@NotEmpty(message="Last name is required")
	@Pattern(regexp = "[a-z-A-Z]*", message = "Last name has invalid characters")
	private	String lastName;
	
	
	@NotEmpty(message="Qualification is required")
	@Pattern(regexp = "[a-z-A-Z.]*", message = "Qualification has invalid characters")
	private	String qualifications;
	
	
	private	String physicianId;
	
	
	//@Digits(fraction = 0, integer =3,message="Should be a digit" )
	@NotNull(message="Experience is required")
	@Min(value = 1,message="min experience is 1")
	@Max(value = 100,message="max experience is 100")
	private Integer experienceYears;
	
	
	//plan
		@ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
	    @JoinColumn(name = "plan_id", referencedColumnName = "id")
		
		private Plan plan=new Plan();
		
		
		public Plan getPlan() {
			return plan;
		}

		public void setPlan(Plan plan) {
			this.plan = plan;
			plan.getPhysicians().add(this);
		}
	
		//state
		@ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
	    @JoinColumn(name = "state_id", referencedColumnName = "id")
		
	    private State state;
		
		public State getState() {
			return state;
		}
		
		public void setState(State state) {
			this.state = state;
			//this.state.setStatename(state.getStatename());
			state.getPhysicians().add(this);
		}
		
		
		//department
		@ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
		 @JoinColumn(name = "department_id", referencedColumnName = "id")
		private Department department;
		
		
    	public Department getDepartment() {
			return department;
		}

		public void setDepartment(Department department) {
			this.department = department;
			department.getPhysicians().add(this);
		}

		
		
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getQualifications() {
		return qualifications;
	}

	public void setQualifications(String qualifications) {
		this.qualifications = qualifications;
	}

	public Integer getExperienceYears() {
		return experienceYears;
	}

	public void setExperienceYears(Integer experienceYears) {
		this.experienceYears = experienceYears;
	}

	public String getPhysicianId() {
		return physicianId;
	}

	public void setPhysicianId(String physicianId) {
		this.physicianId = physicianId;
	}
	
	
	
	
}
