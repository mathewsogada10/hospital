<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Contacts</title>

<script type="text/javascript">    
 var msg1 = "${successContact}";
 var msg2 = "${errormessageContact}";
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
</head>
<body>
<script type="text/javascript"> window.onload = alertJob; </script>
<table class="table table-dark" id="contact_table">
  <thead>
    <tr>
    <th scope="col">Internal Code</th>
      <th scope="col">Cell Phone</th>
      <th scope="col">Email</th>
      <th scope="col">Alternative Cell Phone</th>
      <th scope="col">Patient Id Number</th>
          <th><div class="dropdown"> 
        <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Action
		  <span class="caret"></span></button>
		  <ul class="dropdown-menu">
		    <li><a href="<c:url value="/contacts/add_contact"/>">Add New Contact</a></li>
		    </ul>
          </div></th>
    </tr>
  </thead>
  <tbody>
   <c:forEach items="${contacts}" var="contact">
    <tr>
        <td><c:out value="${contact.intCode}" /></td>
        <td><c:out value="${contact.cellPhone}" /></td>
        <td><c:out value="${contact.email}" /></td>
        <td><c:out value="${contact.alternateCell}" /></td>
        <td><c:out value="${contact.patient.idNumber}" /></td> 
        <td><div class="dropdown"> 
        <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">...
		  <span class="caret"></span></button>
		  <ul class="dropdown-menu">
		    <li><a href="<c:url value="/contacts/editContact/"/>${contact.intCode}">Edit</a></li>
		    </ul>
          </div></td> 
    </tr>
</c:forEach>
  </tbody>
</table>
</body>
</html>