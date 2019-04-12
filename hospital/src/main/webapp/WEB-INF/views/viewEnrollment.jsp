<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Enrollment</title>
</head>
<body>
<table class="table table-dark" id="enrollemnt_table">
  <thead>
    <tr>
      <th scope="col">Internal Code</th>
      <th scope="col">Enrollment Number</th>
      <th scope="col">Enrollment Date</th>
      <th scope="col">Patient Id Number</th>
          <th><div class="dropdown"> 
        <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Action
		  <span class="caret"></span></button>
		  <ul class="dropdown-menu">
		    <li><a href="<c:url value="/enrollment/add_enrollment"/>">Add New Enrollment</a></li>
		    </ul>
          </div></th>
    </tr>
  </thead>
  <tbody>
   <c:forEach items="${enrollments}" var="enrollment">
    <tr>
        <td><c:out value="${enrollment.intCode}" /></td>
        <td><c:out value="${enrollment.enrollmentNo}" /></td>
        <td><c:out value="${enrollment.enrollmentDate}" /></td>
        <td><c:out value="${enrollment.patient.idNumber}" /></td>
         <td><div class="dropdown"> 
        <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">...
		  <span class="caret"></span></button>
		  <ul class="dropdown-menu">
		    <li><a href="<c:url value="/enrollment/editEnrollment/"/>${enrollment.intCode}">Edit</a></li>
		    </ul>
          </div></td>   
    </tr>
</c:forEach>
  </tbody>
</table>
</body>
</html>