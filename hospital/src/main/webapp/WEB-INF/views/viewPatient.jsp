<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List Of Patients</title>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<link rel="stylesheet" 
href="http://cdn.datatables.net/1.10.2/css/jquery.dataTables.min.css">
<script type="text/javascript" 
src="http://cdn.datatables.net/1.10.2/js/jquery.dataTables.min.js"></script>

<script type="text/javascript">    
 var msg1 = "${success}";
 var msg2 = "${errormessage}";
function alertJob(){
	  if(msg1==null || msg1==""){
	    }
	    else {
	    	window.alert(msg1);
	    }
	  if(msg2==null || msg2==""){
	    }
	    else {
	    	window.alert(msg2);
	    } 
}</script>
<script type="text/javascript">
function confirmDlete(m)
{
  var answer = confirm ("Are you sure you want to delete?");
  if (answer){
	  window.open("http://localhost:9090/web/delete/"+m+"","_self");
  }
    else
      return false;
}
</script> 
<script type="text/javascript">    
 var msg3 = "${kinchange}";
function alertkin(){
	  if(msg3==null || msg3==""){
	    }
	    else {
	    	window.alert(msg1);
	    }

}</script>

<script>
$(document).ready(function(){
    $('#patient_table').dataTable();
});
</script>
</head>
<body>
<script type="text/javascript"> window.onload = alertJob; </script>
<script type="text/javascript"> window.onload = alertkin; </script>
<div class="col-md-8">
<form:form method="POST" commandName="searchPatient" class="form-inline">
			<form:label path="equation"  cssErrorClass="has-errors"><s:message code="equation.label"/></form:label>
			<form:select path="equation" cssClass="form-control" cssErrorClass="form-control has-errors" id="equation" placeholder="equation">
			<c:forEach var="item" items="${equations}">
            <option value="${item.equation}" ${item.equation == searchEq ? 'selected="selected"' : ''}>${item.equation}</option>
            </c:forEach>
			</form:select>
			<form:input path="valueSearch" cssClass="form-control" cssErrorClass="form-control has-errors" value="${searchValue}" id="valueSearch"/>
		 <form:button class="btn btn-default"> <s:message code="searchPatient.value"/></form:button>
</form:form>
</div>
<br/><br/><br/>
<table class="table table-dark" id="patient_table" class="table table-striped" >
  <thead>
    <tr>
      <th scope="col" id="idNumber">Internal Code</th>
      <th scope="col">Sir Name</th>
      <th scope="col">First Name</th>
      <th scope="col">Middle Name</th>
      <th scope="col">Gender</th>
      <th scope="col">Date Of Birth</th>
      <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody>
   <c:forEach items="${patients}" var="patient">
    <tr>
        <td><c:out value="${patient.idNumber}" /></td>
        <td><c:out value="${patient.sirName}" /></td>
        <td><c:out value="${patient.firstName}" /></td>
        <td><c:out value="${patient.middleName}" /></td>
        <td><c:out value="${patient.gender}" /></td>
        <td><c:out value="${patient.dateOfBirth}" /></td>
        <td><div class="dropdown"> 
        <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">...
		  <span class="caret"></span></button>
		  <ul class="dropdown-menu">
		    <li><a href="<c:url value="/bio-data/editPatient/"/>${patient.idNumber}">Edit</a></li>
		    <li><a href="<c:url value="/contacts/contacts/"/>${patient.idNumber}">see contacts</a></li>
		    <li><a href="<c:url value="/location/location/"/>${patient.idNumber}">see location</a></li>
		    <li><a href="<c:url value="/next-of-kin/kin/"/>${patient.idNumber}">see next of kin</a></li>
		    <li><a href="<c:url value="/enrollment/enrol/"/>${patient.idNumber}">View Enrollment</a></li>
		    <li onclick="confirmDlete(${patient.idNumber})"><a href="<c:url value="/bio-data/delete/"/>${patient.idNumber}">Delete</a></li>
		    </ul>
          </div></td>
  
    </tr>
</c:forEach>
  </tbody>
</table>
</body>
</html>