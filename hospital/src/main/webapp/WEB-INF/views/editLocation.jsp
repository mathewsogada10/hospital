<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Location</title>
</head>
<body>

 <div id="content" class="content">
<h1><u>Edit Location</u></h1>
   <div class="col-md-4">
        <form:form method="POST" commandName="saveLocation" cssClass="form-horizontal">
           <div class="formGroup">
			<form:label path="intCode"  cssErrorClass="has-errors"><s:message code="intCode.label"/></form:label>
			<form:input path="intCode" cssClass="form-control" cssErrorClass="form-control has-errors" id="intCode" value="${location.intCode }" placeholder="intCode"/>
			<form:errors path="intCode" cssClass="has-errors" element="span"/>
			<br/>
		</div>
        <div class="formGroup">
			<form:label path="county"  cssErrorClass="has-errors"><s:message code="county.label"/></form:label>
			<form:select path="county.countyName" cssClass="form-control" cssErrorClass="form-control has-errors" id="county.countyName" value="${location.county.countyName }" placeholder="county.countyName">
			<form:options items="${countyNames}"></form:options>
			</form:select>
			<form:errors path="county.countyName" cssClass="has-errors" element="span"/>
			<br/>
		</div>
 		<div class="formGroup">
			<form:label path="subCounty"  cssErrorClass="has-errors"><s:message code="subCounty.label"/></form:label>
			<form:input path="subCounty" cssClass="form-control" cssErrorClass="form-control has-errors" id="subCounty" value="${location.subCounty }" placeholder="subCounty"/>
			<form:errors path="subCounty" cssClass="has-errors" element="span"/>
		</div>
		<div class="formGroup">
			<form:label path="village"  cssErrorClass="has-errors"><s:message code="village.label"/></form:label>
			<form:input path="village" cssClass="form-control" cssErrorClass="form-control has-errors" id="village" value="${location.village }" placeholder="village"/>
			<form:errors path="village" cssClass="has-errors" element="span"/>
			<br/>
		</div>
		<form:button class="btn btn-default"> <s:message code="saveLocation.value"/></form:button>
		</form:form>
    </div>
    </div>
</body>
</html>