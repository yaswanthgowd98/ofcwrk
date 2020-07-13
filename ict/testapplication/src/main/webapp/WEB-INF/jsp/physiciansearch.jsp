<%@page import="java.util.HashMap"%>
<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">
<h2><i>Search Physician</i></h2>
	<form:form method="post" modelAttribute="search"
		action="/searchphysicians" autocomplete="off" >

<fieldset class="form-group">
		<form:label path="departmentid">select department</form:label>
		<form:select path="departmentid" placeholder="Pick a department..."
			title="Select state from list">
			
			<form:options items="${departmentsids}" />

		</form:select>

		<form:errors path="departmentid" cssClass="text-warning" />
 </fieldset>
		
	<fieldset class="form-group">	
		<form:label path="planid">select plan</form:label>

		<form:select path="planid" placeholder="Pick a plan..."
		title="Select plan from list" >
			
			<form:options items="${plansids}"  />
		</form:select>
		<form:errors path="planid" cssClass="text-warning" />
 </fieldset>

<fieldset class="form-group">
		<form:label path="stateid">select state</form:label>
		<form:select path="stateid" placeholder="Pick a state..."
			title="Select state from list"
			selected="true">
			
			<form:options items="${statesids}" />

		</form:select>

		
		<form:errors path="stateid" cssClass="error" />

 </fieldset>



		<table>
			<tr>
				<th><form:button type="submit" class="btn btn-success">Search</form:button>
				</th>
			</tr>
		</table>
	</form:form>



<h2>${message1}</h2>
<h2>${message2}</h2>
<h2>${message3}</h2>
    
	
 <h2>${message}</h2>

	

<br>
	
	
	<div>
		<table class="table table-striped">
		         <tr><th colspan="6" style="background-color:rgba(100, 130, 60, 0.2)"><h3 >Physicians Details</h3></th></tr>
				
				
				<tr>
				<th>PhysicianId</th>
				        
						<th>FirstName</th>
						<th>LastName</th>
						<th>Department</th>
						<th>State</th>
						<th>PlanProvided</th>
						
						</tr>
				
				
				
				<c:forEach items="${physicians}" var="physician">
				
				
					<tr>
						<td>${physician.physicianId}</td>
						<td>${physician.firstName}</td>
						<td>${physician.lastName}</td>
						<td>${physician.department.departmentName}</td>
						<td>${physician.state.statename}</td>
						<td>${physician.plan.planName}</td>
						
						
						
					</tr>
					
					
				</c:forEach>
			
		</table>

</div>
       







</div>
<%@ include file="common/footer.jspf"%>