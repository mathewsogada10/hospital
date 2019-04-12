<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ page session="false" %>

  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script>
  $( function() {
    $( "#dateOfBirth" ).datepicker();
    $( "#dateOfBirth2" ).datepicker();
    $( "#enrollmentDate" ).datepicker();
  } );
  </script>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to E-Patients</title>
</head>
<body>
<div id="content" class="content">
<ul class="nav nav-tabs">
  <li class="active"><a data-toggle="tab" href="#patient">Patients Bio Data</a></li>
  <li><a data-toggle="tab" href="#contacts">Contacts Info</a></li>
  <li><a data-toggle="tab" href="#location">Location Info</a></li>
  <li><a data-toggle="tab" href="#kin">Next Of Kin Info</a></li>
  <li><a data-toggle="tab" href="#enrol">Enrollment Info</a></li>
</ul>

<div class="tab-content">
  <div id="patient" class="tab-pane fade in active">
  <div class="col-md-4">
        <form:form method="POST" commandName="savePatient" cssClass="form-horizontal">
		<div class="formGroup">
			<form:label path="sirName"  cssErrorClass="has-errors"><s:message code="sirName.label"/></form:label>
			<form:input path="sirName" cssClass="form-control" cssErrorClass="form-control has-errors" id="sirName" placeholder="Sir Name"/>
			<form:errors path="sirName" cssClass="has-errors" element="span"/>
			<br/>
		</div>
		<div class="formGroup">
			<form:label path="firstName"  cssErrorClass="has-errors"><s:message code="firstName.label"/></form:label>
			<form:input path="firstName" cssClass="form-control" cssErrorClass="form-control has-errors" id="firstName" placeholder="First Name"/>
			<form:errors path="firstName" cssClass="has-errors" element="span"/>
			<br/>
		</div>
		<div class="formGroup">
			<form:label path="middleName"  cssErrorClass="has-errors"><s:message code="middleName.label"/></form:label>
			<form:input path="middleName" cssClass="form-control" cssErrorClass="form-control has-errors" id="middleName" placeholder="Middle Name"/>
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
		<form:button class="btn btn-default"> <s:message code="savePatient.value"/></form:button>
		</form:form>
  </div>
  </div>
  <div id="contacts" class="tab-pane fade">
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
		<form:button class="btn btn-default"> <s:message code="saveContact.value"/></form:button>
		</form:form>
  </div>
  </div>
   <div id="location" class="tab-pane fade">
   <div class="col-md-4">
        <form:form method="POST" commandName="saveLocation" cssClass="form-horizontal">
        <div class="formGroup">
			<form:label path="county"  cssErrorClass="has-errors"><s:message code="county.label"/></form:label>
			<form:select path="county.countyName" cssClass="form-control" cssErrorClass="form-control has-errors" id="county.countyName" placeholder="county.countyName">
			<form:options items="${countyNames}"></form:options>
			</form:select>
			<form:errors path="county.countyName" cssClass="has-errors" element="span"/>
			<br/>
		</div>
 		<div class="formGroup">
			<form:label path="subCounty"  cssErrorClass="has-errors"><s:message code="subCounty.label"/></form:label>
			<form:input path="subCounty" cssClass="form-control" cssErrorClass="form-control has-errors" id="subCounty" placeholder="subCounty"/>
			<form:errors path="subCounty" cssClass="has-errors" element="span"/>
		</div>
		<div class="formGroup">
			<form:label path="village"  cssErrorClass="has-errors"><s:message code="village.label"/></form:label>
			<form:input path="village" cssClass="form-control" cssErrorClass="form-control has-errors" id="village" placeholder="village"/>
			<form:errors path="village" cssClass="has-errors" element="span"/>
			<br/>
		</div>
		<form:button class="btn btn-default"> <s:message code="saveLocation.value"/></form:button>
		</form:form>
  </div>
  </div>
  
   <div id="kin" class="tab-pane fade">
   <div class="col-md-4">
    <form:form method="POST" commandName="saveNextOfKin" cssClass="form-horizontal">
		<div class="formGroup">
			<form:label path="lastName"  cssErrorClass="has-errors"><s:message code="lastName.label"/></form:label>
			<form:input path="lastName" cssClass="form-control" cssErrorClass="form-control has-errors" id="lastName" placeholder="Sir Name"/>
			<form:errors path="lastName" cssClass="has-errors" element="span"/>
			<br/>
		</div>
		<div class="formGroup">
			<form:label path="firstName"  cssErrorClass="has-errors"><s:message code="firstName.label"/></form:label>
			<form:input path="firstName" cssClass="form-control" cssErrorClass="form-control has-errors" id="firstName" placeholder="First Name"/>
			<form:errors path="firstName" cssClass="has-errors" element="span"/>
			<br/>
		</div>
		<div class="formGroup">
			<form:label path="middleName"  cssErrorClass="has-errors"><s:message code="middleName.label"/></form:label>
			<form:input path="middleName" cssClass="form-control" cssErrorClass="form-control has-errors" id="middleName" placeholder="Middle Name"/>
			<form:errors path="middleName" cssClass="has-errors" element="span"/>
			<br/>
		</div>
		<div class="formGroup">
			<form:label path="dateOfBirth"  cssErrorClass="has-errors"><s:message code="dateOfBirth.label"/></form:label>
			<form:input path="dateOfBirth" cssClass="form-control" cssErrorClass="form-control has-errors" id="dateOfBirth2" placeholder="Date Of Birth"/>
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
 
   <div id="enrol" class="tab-pane fade">
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
		<form:button class="btn btn-default"> <s:message code="saveEnrollment.value"/></form:button>
		</form:form>
  </div>
  </div>
  </div>
</div>
</body>
</html>