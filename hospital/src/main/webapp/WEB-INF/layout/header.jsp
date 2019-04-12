  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <% String role= (String)session.getAttribute("${userprofile.fname}");
      pageContext.setAttribute("role",role);
%>

  <!-- Static navbar -->
  <nav class="navbar navbar-default navbar-static-top">
    <div class="container">
      <div id="navbar" class="nav navbar-nav navbar-right">
        <ul class="nav navbar-nav">
       <div class="dropdown">
  <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Patient
  <span class="caret"></span></button>
  <ul class="dropdown-menu">
    <li><a href="<c:url value="/bio-data/new"/>">Add new Patient</a></li>
    <li><a href="<c:url value="/bio-data/view"/>">View Patients</a></li>
    <li><a href="<c:url value="/contacts/view_contacts"/>">View Patient's Contacts</a></li>
    <li><a href="<c:url value="/location/view_location"/>">View Patient's Location</a></li>
    <li><a href="<c:url value="/enrollment/view_enrollment"/>">View Patient's Enrollment</a></li>
    <li><a href="<c:url value="/next-of-kin/view_kin"/>">View Patient's Next of Kin</a></li>
     <li><a href="<c:url value="/bio-data/view_deleted_patients"/>">View Deleted Patients</a></li>
    </ul>
   </ul>
   </div>
      </div><!--/.nav-collapse -->
    </div>
  </nav>
  