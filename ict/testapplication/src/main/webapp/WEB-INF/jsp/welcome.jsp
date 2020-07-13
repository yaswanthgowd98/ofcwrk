<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">
<div>
	Welcome ${name}!! <a href="/list-todos">Click here</a> to manage your
	todo's.
	</div>
	
	<br>
	
	 <center>
     <div class="btn-group-vertical">
    
     <a href="/register-patient" class="btn btn-default btn-lg" role="button" style="color: #00264d;" >Enroll Patient</a><br>
     <a href="/register-physician" class="btn btn-default btn-lg" role="button" style="color: #00264d;">Add Physician</a><br>
     <a href="/search-physician" class="btn btn-default btn-lg" role="button" style="color: #00264d;">Search Physician</a><br>
     <a href="/diagnosis" class="btn btn-default btn-lg" role="button" style="color: #00264d;">Patient Diagnosis</a><br>
     <a href="/diagnosis" class="btn btn-default btn-lg" role="button" style="color: #00264d;">View Patient History</a><br>
     
      </div>
      </center>
      
      
</div>
<%@ include file="common/footer.jspf"%>