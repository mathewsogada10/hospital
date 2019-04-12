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
<title>Add New Next Of Kin</title>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
 <script>
  $( function() {
    $( "#dateOfBirth" ).datepicker();
  } );
  </script>
  	<script type="text/javascript">
    var msg = "${kinsuccessmsg}";
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
<h1><u>Add Next Of Kin</u></h1>
<script type="text/javascript"> window.onload = alertName; </script>
<div class="col-md-4">
<div id="kin" class="tab-pane fade in active">
    <form:form method="POST" commandName="saveNextOfKin" cssClass="form-horizontal">
		<div class="formGroup">
			<form:label path="lastName"  cssErrorClass="has-errors"><s:message code="lastName.label"/></form:label>
			<form:input path="lastName" cssClass="form-control" cssErrorClass="form-control has-errors" id="lastName" placeholder="lastName"/>
			<form:errors path="lastName" cssClass="has-errors" element="span"/>
			<br/>
		</div>
		<div class="formGroup">
			<form:label path="firstName"  cssErrorClass="has-errors"><s:message code="firstName.label"/></form:label>
			<form:input path="firstName" cssClass="form-control" cssErrorClass="form-control has-errors" id="firstName" placeholder="firstName"/>
			<form:errors path="firstName" cssClass="has-errors" element="span"/>
			<br/>
		</div>
		<div class="formGroup">
			<form:label path="middleName"  cssErrorClass="has-errors"><s:message code="middleName.label"/></form:label>
			<form:input path="middleName" cssClass="form-control" cssErrorClass="form-control has-errors" id="middleName" placeholder="middleName"/>
			<form:errors path="middleName" cssClass="has-errors" element="span"/>
			<br/>
		</div>
		<div class="formGroup">
			<form:label path="dateOfBirth"  cssErrorClass="has-errors"><s:message code="dateOfBirth.label"/></form:label>
			<form:input path="dateOfBirth" cssClass="form-control" cssErrorClass="form-control has-errors" id="dateOfBirth" placeholder="Date Of Birth"/>
			<form:errors path="dateOfBirth" cssClass="has-errors" element="span"/>
			<br/>
		</div>
	    <div class="formGroup">
			<form:label path="gender"  cssErrorClass="has-errors"><s:message code="gender.label"/></form:label>
			<form:select path="gender" cssClass="form-control" cssErrorClass="form-control has-errors" id="gender" placeholder="gender">
			<form:options items="${gender}"></form:options>
			</form:select>
			<form:errors path="gender" cssClass="has-errors" element="span"/>
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
		<form:button class="btn btn-default"> <s:message code="saveNextOfKin.value"/></form:button>
		</form:form>
		</div>
		</div>
		</div>
</body>
</html>