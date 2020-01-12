    <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>View Office</title>
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>

<body>
  	<div class="generic-container">
		<%@include file="authheader.jsp" %>

		<div class="well lead">Contract Time Form</div>
	 	<form:form method="POST" modelAttribute="viewManager" class="form-horizontal">
			<form:input type="hidden" path="id" id="id"/>
			
	
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="contract">Contract</label>
					<div class="col-md-7">
						<form:input type="text" path="contract" id="contract" class="form-control input-sm"/>
						<div class="has-error">
							<form:errors path="contract" class="help-inline"/>
						</div>
					</div>
				</div>
			</div>  
			
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="startRent">Start Rent</label>
					<div class="col-md-7">
						<form:input type="datetime-local" path="startRent" id="startRent" class="form-control input-sm"/>
						<div class="has-error">
							<form:errors path="startRent" class="help-inline"/>
						</div>
					</div>
				</div>
			</div>
			
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="finishRent">Finish Rent</label>
					<div class="col-md-7">
						<form:input type="datetime-local" path="finishRent" id="finishRent" class="form-control input-sm"/>
						<div class="has-error">
							<form:errors path="finishRent" class="help-inline"/>
						</div>
					</div>
				</div>
			</div> 
			
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="statusRent">Status Rent</label>
					<div class="col-md-7">
						<form:select path="statusRent" items="${statuses}" multiple="false" itemValue="id" itemLabel="name" class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="statusRent" class="help-inline"/>
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