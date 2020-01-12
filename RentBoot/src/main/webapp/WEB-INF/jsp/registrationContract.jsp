<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Contract Registration Form</title>
	<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>

<body>
 	<div class="generic-container">
		<%@include file="authheader.jsp" %>

		<div class="well lead">User Registration Form</div>
	 	<form:form method="POST" modelAttribute="contract" class="form-horizontal">
			<form:input type="hidden" path="id" id="id"/>
			
			
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="contractNumber">Contract Number</label>
					<div class="col-md-7">
						<form:input type="text" path="contractNumber" id="contractNumber" class="form-control input-sm"/>
						<div class="has-error">
							<form:errors path="contractNumber" class="help-inline"/>
						</div>
					</div>
				</div>
			</div>
	
	  		<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="manager">Manager</label>
					<div class="col-md-7">
						<form:select path="manager" items="${managers}" multiple="false" itemValue="id" itemLabel="fio" class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="manager" class="help-inline"/>
						</div>
					</div>
				</div>
			</div>  
			
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="auto">Auto</label>
					<div class="col-md-7">
						<form:select path="auto" items="${autos}" multiple="false" itemValue="id" itemLabel="numberAuto" class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="auto" class="help-inline"/>
						</div>
					</div>
				</div>
			</div>  
			
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="client">Client</label>
					<div class="col-md-7">
						<form:select path="client" items="${clients}" multiple="false" itemValue="id" itemLabel="fio" class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="client" class="help-inline"/>
						</div>
					</div>
				</div>
			</div>  
			 
	
			<div class="row">
				<div class="form-actions floatRight">
					<c:choose>
						<c:when test="${edit}">
							<input type="submit" value="Update" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/officeList' />">Cancel</a>
						</c:when>
						<c:otherwise>
							<input type="submit" value="Register" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/officeList' />">Cancel</a>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
		</form:form>
	</div>
</body>
</html>