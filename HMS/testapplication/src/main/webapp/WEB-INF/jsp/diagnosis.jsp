<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>


<% Description description=(Description)request.getAttribute("description"); %>
<div class="container">
 <h2><center>Diagnosis Details</center></h2>
     <h3>${msg}</h3>
	<form:form  modelAttribute="description" action="/patientDiagnosisDetails" method="post" autocomplete="off">
		<form:hidden path="id"/>
		<form:hidden path="patient"/>

		<fieldset class="form-group">
			<form:label path="patient.id">PatientId</form:label>
			<form:input path="patient.id" type="text" class="form-control" disabled="true"/>
				
			<form:errors path="patient.id" cssClass="text-warning" />

		</fieldset>
		
         <fieldset class="form-group">
			<form:label path="symptoms">Symptoms</form:label>
			<form:textarea path="symptoms" type="text" class="form-control"
				required="required" />
			<form:errors path="symptoms" cssClass="text-warning" />
		</fieldset>
		
		<fieldset class="form-group">
			<form:label path="desp">Description</form:label>
			<form:input path="desp" type="text" class="form-control"
				required="required" />
			<form:errors path="desp" cssClass="text-warning" />
		</fieldset>
		
		<fieldset class="form-group">
		
			<form:label path="dateOfDiagnosis">DateOfDiagnosis</form:label>
			<form:input path="dateOfDiagnosis" id="dateOfDiagnosis"   type="text" class="form-control"/>
			<form:errors path="dateOfDiagnosis" cssClass="error" />	
			
		</fieldset>
		
		
		<fieldset class="form-group">
		
		<form:label path="physician">Diagnosed By</form:label>
      
       <form:select path="physician" placeholder="Pick a Doctor..." required="Doctor is required"  >
				
					<form:options items="${physicians}" selected="true" />
					</form:select>
					<form:errors path="physician" cssClass="text-warning" />

				
		</fieldset>
	
		<fieldset class="form-group">
		<form:label path="followup">followUp required</form:label>
		<form:checkbox path="followup" id="followup"></form:checkbox>
			<form:errors path="followup" cssClass="text-warning" />		
				
		</fieldset>
		

		
		<fieldset id="display" class="form-group">
		
			<form:label path="followupdate">FollowUp Date</form:label>
			<form:input path="followupdate" id="followupdate"   type="text" class="form-control"/>
			<form:errors path="followupdate" cssClass="text-warning" />	
			
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
	
		       	<a type="button" class="btn btn-success" href="/patient-diagnosis?id=${description.patient.id}">Reset</a>
	
	
	
		
	        	
</div>
<%@ include file="common/footer.jspf" %>