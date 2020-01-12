<%@ page language="java" contentType="text/html; charset=cp1251" pageEncoding="cp1251"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=cp1251">
	<title>Auto Registration Form</title>
	<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>

<body>
 	<div class="generic-container">
		<%@include file="authheader.jsp" %>

		<div class="well lead">Auto Registration Form</div>
	 	<form:form method="POST" enctype="multipart/form-data" modelAttribute="auto" class="form-horizontal">
			<form:input type="hidden" path="id" id="id"/>
			
			
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="numberAuto">Number Auto</label>
					<div class="col-md-7">
						<form:input type="text" path="numberAuto" id="numberAuto" class="form-control input-sm"/>
						<div class="has-error">
							<form:errors path="numberAuto" class="help-inline"/>
						</div>
					</div>
				</div>
			</div>
	
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="mark">Mark</label>
					<div class="col-md-7">
						<form:input type="text" path="mark" id="mark" class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="mark" class="help-inline"/>
						</div>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="model">Model</label>
					<div class="col-md-7">
						<form:input type="text" path="model" id="model" class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="model" class="help-inline"/>
						</div>
					</div>
				</div>
			</div>
			
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="engine">Engine</label>
					<div class="col-md-7">
						<form:input type="text" path="engine" id="engine" class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="engine" class="help-inline"/>
						</div>
					</div>
				</div>
			</div>
			
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="volume">Volume</label>
					<div class="col-md-7">
						<form:input type="text" path="volume" id="volume" class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="volume" class="help-inline"/>
						</div>
					</div>
				</div>
			</div>
	
	  		<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="transmission">Transmission</label>
					<div class="col-md-7">
						<form:select path="transmission" items="${transmissions}" multiple="false" itemValue="id" itemLabel="name" class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="transmission" class="help-inline"/>
						</div>
					</div>
				</div>
			</div>  
			
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="bodyType">Body Type</label>
					<div class="col-md-7">
						<form:select path="bodyType" items="${bodyTypes}" multiple="false" itemValue="id" itemLabel="name" class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="bodyType" class="help-inline"/>
						</div>
					</div>
				</div>
			</div> 
			
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="driveType">Drive Type</label>
					<div class="col-md-7">
						<form:select path="driveType" items="${driveTypes}" multiple="false" itemValue="id" itemLabel="name" class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="driveType" class="help-inline"/>
						</div>
					</div>
				</div>
			</div> 
			
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="image">Image</label>
					<div class="col-md-7">
						<form:input type="text" path="image" id="image" class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="image" class="help-inline"/>
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