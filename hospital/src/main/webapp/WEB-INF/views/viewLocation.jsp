<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Location</title>
</head>
<body>
<table class="table table-dark" id="location_table">
  <thead>
    <tr>
      <th scope="col">Internal Code</th>
      <th scope="col">County</th>
      <th scope="col">Sub County</th>
      <th scope="col">Village</th>
      <th scope="col">Patient Id Number</th>
         <th><div class="dropdown"> 
        <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Action
		  <span class="caret"></span></button>
		  <ul class="dropdown-menu">
		    <li><a href="<c:url value="/location/add_location"/>">Add Location</a></li>
		    </ul>
          </div></th>
    </tr>
  </thead>
  <tbody>
   <c:forEach items="${locations}" var="location">
    <tr>
       <td><c:out value="${location.intCode}" /></td>
        <td><c:out value="${location.county.countyName}" /></td>
        <td><c:out value="${location.subCounty}" /></td>
        <td><c:out value="${location.village}" /></td>
        <td><c:out value="${location.patient.idNumber}" /></td> 
        <td><div class="dropdown"> 
        <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">...
		  <span class="caret"></span></button>
		  <ul class="dropdown-menu">
		    <li><a href="<c:url value="/location/editLocation/"/>${location.intCode}">Edit Location</a></li>
		    </ul>
          </div></td> 
    </tr>
</c:forEach>
  </tbody>
</table>
</body>
</html>