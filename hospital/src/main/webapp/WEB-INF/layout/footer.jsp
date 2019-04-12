  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  
  <!-- Static navbar -->
 <div id="footer" class="nav navbar-nav navbar-right">

      
 Patient records management system. <b>Time: ${serverTime}</b>  
      
        You Are Logged In As:<c:out value="${userprofile.username}" />
  </div><!--/.nav-collapse -->