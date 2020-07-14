<%@page import="java.util.HashMap"%>
<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<div class="container">
    <h2><center>Patient Enrollment</center></h2>
	<form:form method="post" modelAttribute="patient" action="/registerpatient" autocomplete="off" >
		<form:hidden path="id" />
         <form:errors path="id" cssClass="text-warning" />
		<fieldset class="form-group">
			<form:label path="firstName">First Name</form:label>
			<form:input path="firstName" type="text" class="form-control"  />
			<form:errors path="firstName" cssClass="text-warning" />
			<h4>${messages}</h4>
		</fieldset>
         <fieldset class="form-group">
			<form:label path="lastName">Last Name</form:label>
			<form:input path="lastName" type="text" class="form-control"  />
			<form:errors path="lastName" cssClass="text-warning" />
			<h4>${messages}</h4>
		</fieldset>
		<fieldset class="form-group">
			<form:label path="contact">contact</form:label>
			<form:input path="contact" type="text" class="form-control"
				required="required" />
			<form:errors path="contact" cssClass="text-warning" />
		</fieldset>
		
    
      
    <fieldset class="form-group">
		
			<form:label path="dateOfBirth">DateOfBirth</form:label>
			<form:input path="dateOfBirth" id="dateOfBirth"   type="text" class="form-control"/>
			<form:errors path="dateOfBirth" cssClass="text-warning" />	
			
		</fieldset> 
    
		<fieldset class="form-group">
			<form:label path="email">Email</form:label>
			<form:input path="email"    type="text" class="form-control"/>
			<form:errors path="email" cssClass="text-warning" />	
			
		</fieldset> 
      
      
       <fieldset class="form-group">
     <form:label path="state">Choose state</form:label>
       <form:select path="state" placeholder="Pick a state..."   required="state is required" selected="true">
				<!--  	<form:option value='1' selected="true" label="select"/> -->
					<form:options items="${states}" />
					
					</form:select>
					
		<form:errors path="state.statename" cssClass="text-warning" />
		<form:errors path="state" cssClass="text-warning" />
					
		</fieldset>
		
		<fieldset>
		
		<form:label path="plan">Choose plan</form:label>
      
       <form:select path="plan" placeholder="Pick a plan..." required="plan is required" selected="true">
				<!--  	<form:option value='1000' selected="true" label="select"/>  -->
					<form:options items="${plans}"/>
					</form:select>
					<form:errors path="plan" cssClass="text-warning" />
		<form:errors path="plan.planName" cssClass="text-warning" />
				
		</fieldset>
		
		
		
		
		
		
		<br>
		<table>
		<tr>
		<th>
		<form:button type="submit" class="btn btn-success">Enroll</form:button>
        </th>
		   
		      	 
	        	  
	        	 
		</tr>
		</table>
	</form:form>
	
	
	
	 <form method="get" action="/register-patient">
	     	        <button type="submit" class="btn btn-warning">Reset</button>
	     	        </form>
	
	
		
	        	
</div>
<%@ include file="common/footer.jspf" %>