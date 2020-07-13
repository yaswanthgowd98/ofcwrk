<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<div class="container">
 <h2><center>Physician Enrollment</center></h2>
	<form:form method="post" modelAttribute="physician" action="/registerphysician" autocomplete="off">
		<form:hidden path="id" />

		<fieldset class="form-group">
			<form:label path="firstName">First Name</form:label>
			<form:input path="firstName" type="text" class="form-control"
				 />
			<form:errors path="firstName" cssClass="text-warning" />
			<h4>${messages}</h4>
		</fieldset>
         
		<fieldset class="form-group">
			<form:label path="lastName">Last Name</form:label>
			<form:input path="lastName" type="text" class="form-control" />
			<form:errors path="lastName" cssClass="text-warning" />
			<h4>${messages}</h4>
		</fieldset>
		
		
		 <fieldset class="form-group">
		 
		 <fieldset class="form-group">
			<form:label path="qualifications">Qualifications</form:label>
			<form:input path="qualifications" type="text" class="form-control" />
			<form:errors path="qualifications" cssClass="text-warning" />
		</fieldset>
		
		
		 <fieldset class="form-group">
     <form:label path="department">Choose Department</form:label>
      
       <form:select path="department" placeholder="Pick a Department..."   required="Department is required" selected="true">
				
					<form:options items="${departments}" />
					</form:select>
					
		<form:errors path="department" cssClass="text-warning" />
					
		</fieldset>
		
		
		<fieldset class="form-group">
			<form:label path="experienceYears">ExperienceYears</form:label>
			<form:input path="experienceYears" type="text" class="form-control" pattern="[0-9]+" title="Experience should be number between 1 to 100"/>
			<form:errors path="experienceYears" cssClass="text-warning" />
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
		<form:label path="plan">Insurance plan</form:label>
      
       <form:select path="plan" placeholder="Pick a plan..."  >
				<!--  	<form:option value='1000' selected="true" label="select"/>  -->
					<form:options items="${plans}"  selected="true" />
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
	
	<br>
	
	 <form method="get" action="/register-physician">
	     	        <button type="submit" class="btn btn-warning">Reset</button>
	     	        </form>
	
	
		
	        	
</div>
<%@ include file="common/footer.jspf" %>