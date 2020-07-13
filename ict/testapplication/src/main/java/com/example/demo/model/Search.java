package com.example.demo.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


public class Search {

	public Search() {
		super();
		// TODO Auto-generated constructor stub
	}

	@NotNull(message="Department is required")
	@Min(value=1000,message = "Enter Valid departmentid or select from the list")
	
	private Integer departmentid;
	
	@NotNull(message="State is required")
	@Min(value=1000,message = "Enter Valid departmentid or select from the list")
	
	private Integer stateid;
	
	@NotNull(message="Plan is required")
	@Min(value=1000,message = "Enter Valid departmentid or select from the list")
	
	private Integer planid;

	public Integer getDepartmentid() {
		return departmentid;
	}

	public void setDepartmentid(Integer departmentid) {
		this.departmentid = departmentid;
	}

	public Integer getStateid() {
		return stateid;
	}

	public void setStateid(Integer stateid) {
		this.stateid = stateid;
	}

	public Integer getPlanid() {
		return planid;
	}

	public void setPlanid(Integer planid) {
		this.planid = planid;
	}
	
}
