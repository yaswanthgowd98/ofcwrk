package com.service;

import org.springframework.stereotype.Service;

import com.model.UserClaim;
@Service
public class TaxServiceImpl implements TaxService{

@Override
public double calculateTax(UserClaim userClaim) {
// TODO Auto-generated method stub
double taxClaimAmount=0.0;
String expenceType=userClaim.getExpenseType();
double expenseAmount=userClaim.getExpenseAmt();
double taxPercentage=0.0;
if(expenceType.equals("MedicalExpense"))
{
if(expenseAmount<=1000.0)
taxPercentage=15.0;
else if(expenseAmount>=1001.0 && expenseAmount<=10000.0)
taxPercentage=20.0;
else
taxPercentage=25.0;

}
else if(expenceType.equals("TravelExpense"))
{
if(expenseAmount<=1000.0)
taxPercentage=10.0;
else if(expenseAmount>=1001.0 && expenseAmount<=10000.0)
taxPercentage=15.0;
else
taxPercentage=20.0;

}
else
{
if(expenseAmount<=1000.0)
taxPercentage=5.0;
else if(expenseAmount>=1001.0 && expenseAmount<=10000.0)
taxPercentage=10.0;
else
taxPercentage=15.0;

}
taxClaimAmount = expenseAmount * (taxPercentage /100);
return taxClaimAmount;
}

}