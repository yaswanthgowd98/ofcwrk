package com.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.model.UserClaim;
import com.service.TaxService;
@Controller
@ComponentScan("com.service")
public class TaxController {
@Autowired
private TaxService taxService;
double taxcost=0.0;

@ModelAttribute("expenseList")
public List<String> populateExpense() {
List<String> li = new ArrayList<String>();
li.add("MedicalExpense");
li.add("TravelExpense");
li.add("FoodExpense");
return li;
}

//display page home
@RequestMapping(value = "/getTaxClaimFormPage", method = RequestMethod.GET)
public String discountPage(@ModelAttribute("userClaim") UserClaim userClaim) {
return "taxclaim";
}
@RequestMapping(value = "/calculateTax", method = RequestMethod.GET)
public String calculateTax(@Valid @ModelAttribute("userClaim") UserClaim userClaim, BindingResult result,ModelMap model) {
if(!result.hasErrors())
{
	taxcost = taxService.calculateTax(userClaim);
	model.addAttribute("taxcost", taxcost);
	model.addAttribute("expenseType",userClaim.getExpenseType());
	double expenseAmount=userClaim.getExpenseAmt();
	model.addAttribute("expenseAmount",expenseAmount);
	return "result";

}
else
{
	return "taxclaim";
}
}


}