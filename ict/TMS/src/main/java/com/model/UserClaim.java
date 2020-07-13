package com.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

public class UserClaim {

private String expenseType;
@Min(value=0,message="{error.expenseAmount.negative}")
private double expenseAmt;
@NotEmpty(message="{error.employeeId}")
@Length(min=5,message="{error.employeeId.length}")
private String employeeId;

public String getExpenseType() {
return expenseType;
}
public void setExpenseType(String expenseType) {
this.expenseType = expenseType;
}
public double getExpenseAmt() {
return expenseAmt;
}
public void setExpenseAmt(double expenseAmt) {
this.expenseAmt = expenseAmt;
}
public String getEmployeeId() {
return employeeId;
}
public void setEmployeeId(String employeeId) {
this.employeeId = employeeId;
}



}