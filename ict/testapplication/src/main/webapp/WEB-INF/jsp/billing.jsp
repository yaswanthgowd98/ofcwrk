 <%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>


<% Description description=(Description)request.getAttribute("description"); %>
<div class="container">

   
	<form:form onsubmit="return checkCard(this)" modelAttribute="bill" action="/billingDetails" method="post" autocomplete="off">
		<form:hidden path="id"/>
		<form:hidden path="description"/>
      
		<fieldset class="form-group">
			<form:label path="description.id">DescriptionId</form:label>
			<form:input path="description.id" type="text" class="form-control" disabled="true"/>
				<form:errors path="description.id" cssClass="text-warning" />
			</fieldset>
			
			
			<h2><center> Billing Section</center> </h2>
        <fieldset class="form-group">
			<form:label path="amount">Amount</form:label>
			<form:input path="amount" type="text" class="form-control" pattern="[0-9.]+" title="Enter valid amount" />
						<form:errors path="amount" cssClass="text-warning" />
			</fieldset>
		
		
		 <fieldset class="form-group">
			<form:label path="paymentmode">PaymentMode</form:label>
			<form:select path="paymentmode" id="paymentMode" name="paymentMode" type="text" class="form-control"  placeholder="select a payment mode..."  >
			
			<form:option value="Cash">Cash</form:option>
			<form:option value="Card">Card</form:option>
			</form:select>
						<form:errors path="paymentmode" cssClass="text-warning" />
			</fieldset>
			
		<fieldset class="form-group">
			<form:label path="cardnumber">Card number</form:label>
			<form:input path="cardnumber" type="text" class="form-control" id="cardNumber" name="cardNumber" pattern="[0-9.]{10}" title="Enter valid 10 digit credit card number"/>
						<form:errors path="cardnumber" cssClass="text-warning" />
						<p id="message" cssClass="text-warning"></p>
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
	
		       	<a type="button" class="btn btn-success" href="/add-bill?id=${description.id}">Reset</a>
	
	
	
		
	        	
</div>
<%@ include file="common/footer.jspf" %> 