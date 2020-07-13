<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf" %>


<div class="container">
 
<form action="/findPatientToAddDiagnosis" method="post" onsubmit="return checkForm(this)">
<h2><i> </i></h2>
<input  type="text" name="id" autocomplete="off" id="id"  pattern="[0-9]+"  title="Please enter your valid patient Id" placeholder="Search by Patient Id">
<input type="submit" value="Search" class="btn btn-success">

<h2><i>Or search by</i></h2>
<input type="text" name="firstName" id="firstName" autocomplete="off"   placeholder="Enter first name"  pattern="[A-Za-z]{3,}"  title="Please enter your valid firstName">
<input type="text" name="lastName" id="lastName" autocomplete="off"   placeholder="Enter Last name" pattern="[A-Za-z]{3,}" title="Please enter your valid lastName">
<input type="submit" value="Search" class="btn btn-success">
</form>

<h3 id="message" style="color:red"></h3>





<h1 cssClass="text-warning">${message}</h1>
	
	
	<br>
	
	<div>
		<table class="table table-striped">
		         <tr><th colspan="8" style="background-color:rgba(100, 130, 60, 0.2)"><h3 >Patient Details</h3></th></tr>
		      
		         <tr>
				<th>PatientId</th>
						<th>FirstName</th>
						<th>LastName</th>
						<th>DOB</th>
						<th>StateName</th>
						<th>Plan</th>
						<th>Contact</th>
						<th>Action</th>
						</tr>
				<c:forEach items="${patients}" var="patient">
				
				
					<tr>
						<td>${patient.id}</td>
						<td>${patient.firstName}</td>
						<td>${patient.lastName}</td>
						<td>${patient.dateOfBirth}</td>
						<td>${patient.state.statename}</td>
						<td>${patient.plan.planName}</td>
						<td>${patient.contact}</td>
						<td><a type="button" class="btn btn-success"
							href="/patient-diagnosis?id=${patient.id}">Add Diagnosis</a></td>
						
					</tr>
					
					
				</c:forEach>
			
		
		

							
							
							
		
		
		   		<tr ><th colspan="8" style="background-color:rgba(100, 130, 60, 0.2)"><h3>Diagnosis History</h3></th></tr>
				
				<th>DiagnosisId</th>
						<th>Symptoms</th>
						<th>Description</th>
						<th>dateOfDiagnosis</th>
						<th>Diagnosed By</th>
						<th>Followup</th>
						<th>FollowupDate</th>
						<th>BillStatus</th>
						</tr>
						
				<c:forEach items="${descriptions}" var="description">
		       
				<tr>
				
					<tr>
						<td>${description.id}</td>
						<td><textarea >${description.symptoms}</textarea></td>
						<td><textarea >${description.desp}</textarea></td>
						
						<td>${description.dateOfDiagnosis}</td>
					<td>${description.physician.firstName} </td>
					<td>${description.followupcon} </td>
					<td>${description.followupdate} </td>
						<td>${description.bill.paymentStatus} </td>
					</tr>
					<br>
					
				</c:forEach>
			
		</table>
		
		</div>
		
	
		
	</div>
<%@ include file="common/footer.jspf"%>