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
<title>Edit bio data</title>
 <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
 <script>
  $( function() {
    $( "#dateOfBirth" ).datepicker();
  } );
  </script>
</head>
<body>
<div id="content" class="content">
<h1> Edit Patient's Bio Data</h1>
<div class="col-md-4">
<div id="patient" class="tab-pane fade in active">
        <form:form method="POST" commandName="editPatientData" cssClass="form-horizontal">
 		<div class="formGroup">
			<form:label path="idNumber"  cssErrorClass="has-errors"><s:message code="idNumber.label"/></form:label>
			<form:input path="idNumber" cssClass="form-control" cssErrorClass="form-control has-errors" id="idNumber" placeholder="idNumber" value="${patient.idNumber}" readonly="true"/>
			<form:errors path="idNumber" cssClass="has-errors" element="span"/>
		</div>
		<div class="formGroup">
			<form:label path="sirName"  cssErrorClass="has-errors"><s:message code="sirName.label"/></form:label>
			<form:input path="sirName" cssClass="form-control" cssErrorClass="form-control has-errors" id="sirName" placeholder="sirName" value="${patient.sirName}"/>
			<form:errors path="sirName" cssClass="has-errors" element="span"/>
			<br/>
		</div>
		<div class="formGroup">
			<form:label path="firstName"  cssErrorClass="has-errors"><s:message code="firstName.label"/></form:label>
			<form:input path="firstName" cssClass="form-control" cssErrorClass="form-control has-errors" id="firstName" placeholder="firstName" value="${patient.firstName}"/>
			<form:errors path="firstName" cssClass="has-errors" element="span"/>
			<br/>
		</div>
		<div class="formGroup">
			<form:label path="middleName"  cssErrorClass="has-errors"><s:message code="middleName.label"/></form:label>
			<form:input path="middleName" cssClass="form-control" cssErrorClass="form-control has-errors" id="middleName" placeholder="middleName" value="${patient.middleName}"/>
			<form:errors path="middleName" cssClass="has-errors" element="span"/>
			<br/>
		</div>
		<div class="formGroup">
			<form:label path="dateOfBirth"  cssErrorClass="has-errors"><s:message code="dateOfBirth.label"/></form:label>
			<fmt:formatDate var="fmtDate" value="${patient.dateOfBirth}" pattern="dd/MM/yyyy"/>
			<form:input path="dateOfBirth" cssClass="form-control" cssErrorClass="form-control has-errors" id="dateOfBirth" placeholder="dateOfBirth" value="${fmtDate}"/>
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
		<form:button class="btn btn-default"> <s:message code="editPatientData.value"/></form:button>
		</form:form>
  </div>
  </div>
  </div>
</body>
</html>