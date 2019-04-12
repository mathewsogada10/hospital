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
<title>Edit NEXT OF KIN</title>
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
<h1><u>Update Next Of Kin</u></h1>
<div class="col-md-4">
<div id="kin" class="tab-pane fade in active">
    <form:form method="POST" commandName="saveNextOfKin" cssClass="form-horizontal">
    	<div class="formGroup">
			<form:label path="idNo"  cssErrorClass="has-errors"><s:message code="intCode.label"/></form:label>
			<form:input path="idNo" cssClass="form-control" cssErrorClass="form-control has-errors" id="idNo" value="${kin.idNo }" readonly="true" placeholder="idNo"/>
			<form:errors path="idNo" cssClass="has-errors" element="span"/>
			<br/>
		</div>
		<div class="formGroup">
			<form:label path="lastName"  cssErrorClass="has-errors"><s:message code="lastName.label"/></form:label>
			<form:input path="lastName" cssClass="form-control" cssErrorClass="form-control has-errors" id="lastName" value="${kin.lastName }" placeholder="lastName"/>
			<form:errors path="lastName" cssClass="has-errors" element="span"/>
			<br/>
		</div>
		<div class="formGroup">
			<form:label path="firstName"  cssErrorClass="has-errors"><s:message code="firstName.label"/></form:label>
			<form:input path="firstName" cssClass="form-control" cssErrorClass="form-control has-errors" id="firstName" value="${kin.firstName }" placeholder="firstName"/>
			<form:errors path="firstName" cssClass="has-errors" element="span"/>
			<br/>
		</div>
		<div class="formGroup">
			<form:label path="middleName"  cssErrorClass="has-errors"><s:message code="middleName.label"/></form:label>
			<form:input path="middleName" cssClass="form-control" cssErrorClass="form-control has-errors" id="middleName" value="${kin.middleName }" placeholder="middleName"/>
			<form:errors path="middleName" cssClass="has-errors" element="span"/>
			<br/>
		</div>
		<div class="formGroup">
			<form:label path="dateOfBirth"  cssErrorClass="has-errors"><s:message code="dateOfBirth.label"/></form:label>
			<fmt:formatDate var="fmtDate" value="${kin.dateOfBirth}" pattern="dd/MM/yyyy"/>
			<form:input path="dateOfBirth" cssClass="form-control" cssErrorClass="form-control has-errors" id="dateOfBirth" value="${fmtDate}" placeholder="Date Of Birth"/>
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
		<form:button class="btn btn-default"> <s:message code="saveNextOfKin.value"/></form:button>
		</form:form>
		</div>
		</div>
		</div>
</body>
</html>