<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	<script type="text/javascript">
    var msg = "${errorMessage}";
    if(msg==null || msg==""){
    	console.log("Login not yet!");
    }
    else {
    function alertName(){     
        	alert(msg);
        }
    }

</script>
</head>
<body>

<div class="container">
<div id="logindiv">
<h1>
	<u>Login Page </u>
</h1>
<div class="col-md-4">
    <br></br>
    <script type="text/javascript"> window.onload = alertName; </script>
     <form:form method="POST" commandName="login" cssClass="form-horizontal">
 		<div class="formGroup">
			<form:label path="username"  cssErrorClass="has-errors"><s:message code="username.label"/></form:label>
			<form:input path="username" cssClass="form-control" cssErrorClass="form-control has-errors" id="username" placeholder="username"/>
			<form:errors path="username" cssClass="has-errors" element="span"/>
		</div>
		<div class="formGroup">
			<form:label path="password"  cssErrorClass="has-errors"><s:message code="password.label"/></form:label>
			<form:password path="password" cssClass="form-control" cssErrorClass="form-control has-errors" id="password" placeholder="password"/>
			<form:errors path="password" cssClass="has-errors" element="span"/>
			<br/>
		</div>
		<form:button class="btn btn-default"> <s:message code="login.value"/></form:button>
		</form:form>
		<br></br>
		</div>
		</div>
		</div>
</body>
</html>
