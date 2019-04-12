<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Deleted Patients</title>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<link rel="stylesheet" 
href="http://cdn.datatables.net/1.10.2/css/jquery.dataTables.min.css">
<script type="text/javascript" 
src="http://cdn.datatables.net/1.10.2/js/jquery.dataTables.min.js"></script>
<script>
$(document).ready(function(){
    $('#historico_patient_table').dataTable();
});
</script>
</head>
<body>
<table class="table table-dark" id="historico_patient_table" class="table table-striped" >
  <thead>
    <tr>
      <th scope="col" >Internal Code</th>
      <th scope="col">Sir Name</th>
      <th scope="col">First Name</th>
      <th scope="col">Middle Name</th>
      <th scope="col">Gender</th>
      <th scope="col">Date Of Birth</th>
      <th scope="col">Delete By</th>
      <th scope="col">Date Deleted</th>
    </tr>
  </thead>
  <tbody>
   <c:forEach items="${historicoPatients}" var="historicoPatient">
    <tr>
        <td><c:out value="${historicoPatient.idNumber}" /></td>
        <td><c:out value="${historicoPatient.sirName}" /></td>
        <td><c:out value="${historicoPatient.firstName}" /></td>
        <td><c:out value="${historicoPatient.middleName}" /></td>
        <td><c:out value="${historicoPatient.gender}" /></td>
        <td><c:out value="${historicoPatient.dateOfBirth}" /></td>
        <td><c:out value="${historicoPatient.user.username}" /></td>
        <td><c:out value="${historicoPatient.dateDeleted}" /></td>
    </tr>
</c:forEach>
  </tbody>
</table>
</body>
</html>