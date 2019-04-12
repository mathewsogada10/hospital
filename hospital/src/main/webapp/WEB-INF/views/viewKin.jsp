<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Next of kin</title>
</head>

<body>
<table class="table table-dark" id="kin_table">
  <thead>
    <tr>
      <th scope="col">Id Number</th>
      <th scope="col">Sir Name</th>
      <th scope="col">First Name</th>
      <th scope="col">Middle Name</th>
      <th scope="col">Gender</th>
      <th scope="col">Date Of Birth</th>
       <th scope="col">Patient's Id number</th>
         <th><div class="dropdown"> 
        <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Action
		  <span class="caret"></span></button>
		  <ul class="dropdown-menu">
		    <li><a href="<c:url value="/next-of-kin/add_kin"/>">Add Next Of Kin</a></li>
		    </ul>
          </div></th>
    </tr>
  </thead>
  <tbody>
   <c:forEach items="${kins}" var="kin">
    <tr>
        <td><c:out value="${kin.idNo}" /></td>
        <td><c:out value="${kin.lastName}" /></td>
        <td><c:out value="${kin.firstName}" /></td>
        <td><c:out value="${kin.middleName}" /></td>
        <td><c:out value="${kin.gender}" /></td>
        <td><c:out value="${kin.dateOfBirth}" /></td>
        <td><c:out value="${kin.patient.idNumber}" /></td>
        <td><div class="dropdown"> 
        <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">...
		  <span class="caret"></span></button>
		  <ul class="dropdown-menu">
		    <li><a href="<c:url value="/next-of-kin/kinToPatient/"/>${kin.idNo}">Add as Patient</a></li>
		    <li><a href="<c:url value="/next-of-kin/editKin/"/>${kin.idNo}">Edit Kin</a></li>
		    </ul>
          </div></td>
          
    </tr>
</c:forEach>
  </tbody>
</table>
</body>
</html>