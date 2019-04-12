<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Patient Contact</title>
  	<script type="text/javascript">
    var msg = "${contactSuccessmsg}";
    if(msg==null || msg==""){
    	console.log("Login not yet!");
    }
    else {
    function alertName(){     
        	alert(msg);
        }
    }
</script>
</head>
<body>
<div id="content" class="content">
<h1><u>Add Contact</u></h1>
<script type="text/javascript"> window.onload = alertName; </script>
<div class="col-md-4">
<form:form method="POST" commandName="saveContact" cssClass="form-horizontal">
            <div class="formGroup">
			<form:label path="cellPhone"  cssErrorClass="has-errors"><s:message code="cellPhone.label"/></form:label>
			<form:input path="cellPhone" cssClass="form-control" cssErrorClass="form-control has-errors" id="cellPhone" placeholder="cellPhone"/>
			<form:errors path="cellPhone" cssClass="has-errors" element="span"/>
			<br/>
		</div>
 		<div class="formGroup">
			<form:label path="alternateCell"  cssErrorClass="has-errors"><s:message code="alternateCell.label"/></form:label>
			<form:input path="alternateCell" cssClass="form-control" cssErrorClass="form-control has-errors" id="alternateCell" placeholder="alternateCell"/>
			<form:errors path="alternateCell" cssClass="has-errors" element="span"/>
		</div>
		<div class="formGroup">
			<form:label path="email"  cssErrorClass="has-errors"><s:message code="email.label"/></form:label>
			<form:input path="email" cssClass="form-control" cssErrorClass="form-control has-errors" id="email" placeholder="email"/>
			<form:errors path="email" cssClass="has-errors" element="span"/>
			<br/>
		</div>
	 <div class="formGroup">
			<form:label path="patient"  cssErrorClass="has-errors"><s:message code="patient.label"/></form:label>
			<form:select path="patient.firstName" cssClass="form-control" cssErrorClass="form-control has-errors" id="patient.firstName" placeholder="patient.firstName">
			<form:options items="${patientNames}"></form:options>
			</form:select>
			<form:errors path="patient.idNumber" cssClass="has-errors" element="span"/>
			<br/>
		</div>
		<form:button class="btn btn-default"> <s:message code="saveContact.value"/></form:button>
		</form:form>
  </div>
  </div>
</body>
</html>