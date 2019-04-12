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
<title>Add New Enrollment</title>
  	<script type="text/javascript">
    var msg = "${enrolSuccessmsg}";
    if(msg==null || msg==""){
    	console.log("Login not yet!");
    }
    else {
    function alertName(){     
        	alert(msg);
        }
    }

</script>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
 <script>
  $( function() {
    $( "#enrollmentDate" ).datepicker();
  } );
  </script>
</head>
<body>
<div id="content" class="content">
<h1><u>Add Enrollment</u></h1>
<script type="text/javascript"> window.onload = alertName; </script>
<div class="col-md-4">
  <form:form method="POST" commandName="saveEnrollment" cssClass="form-horizontal">
         <div class="formGroup">
			<form:label path="enrollmentNo"  cssErrorClass="has-errors"><s:message code="enrollmentNo.label"/></form:label>
			<form:input path="enrollmentNo" cssClass="form-control" cssErrorClass="form-control has-errors" id="enrollmentNo" placeholder="enrollmentNo"/>
			<form:errors path="enrollmentNo" cssClass="has-errors" element="span"/>
			<br/>
		</div>
		<div class="formGroup">
			<form:label path="enrollmentDate"  cssErrorClass="has-errors"><s:message code="enrollmentDate.label"/></form:label>
			<form:input path="enrollmentDate" cssClass="form-control" cssErrorClass="form-control has-errors" id="enrollmentDate" placeholder="enrollmentDate"/>
			<form:errors path="enrollmentDate" cssClass="has-errors" element="span"/>
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
		<form:button class="btn btn-default"> <s:message code="saveEnrollment.value"/></form:button>
		</form:form>
  </div>
  </div>
</body>
</html>