<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>User Registration Form</title>
	<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>

<body>
 	<div class="generic-container">
		<%@include file="authheader.jsp" %>

		<div class="well lead">User Registration Form</div>
	 	<form:form method="POST" modelAttribute="user" class="form-horizontal">
			<form:input type="hidden" path="id" id="id"/>
			
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="login">Login</label>
					<div class="col-md-7">
						<c:choose>
							<c:when test="${edit}">
								<form:input type="text" path="login" id="login" class="form-control input-sm" disabled="true"/>
							</c:when>
							<c:otherwise>
								<form:input type="text" path="login" id="login" class="form-control input-sm" />
								<div class="has-error">
									<form:errors path="login" class="help-inline"/>
								</div>
							</c:otherwise>
						</c:choose>
					</div>
				</div>
			</div>
			
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="password">Password</label>
					<div class="col-md-7">
						<form:input type="password" path="password" id="password" class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="password" class="help-inline"/>
						</div>
					</div>
				</div>
			</div>
			
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="fio">FIO</label>
					<div class="col-md-7">
						<form:input type="text" path="fio" id="fio" class="form-control input-sm"/>
						<div class="has-error">
							<form:errors path="fio" class="help-inline"/>
						</div>
					</div>
				</div>
			</div>
	
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="phone">Phone</label>
					<div class="col-md-7">
						<form:input type="text" path="phone" id="phone" class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="phone" class="help-inline"/>
						</div>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="address">Address</label>
					<div class="col-md-7">
						<form:input type="text" path="address" id="address" class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="address" class="help-inline"/>
						</div>
					</div>
				</div>
			</div>
			
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="passport_id">Passport ID</label>
					<div class="col-md-7">
						<form:input type="text" path="passport_id" id="passport_id" class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="passport_id" class="help-inline"/>
						</div>
					</div>
				</div>
			</div>
			
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="identificationNumber">Identification Number</label>
					<div class="col-md-7">
						<form:input type="text" path="identificationNumber" id="identificationNumber" class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="identificationNumber" class="help-inline"/>
						</div>
					</div>
				</div>
			</div>
	
	  		<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="userRole">Role</label>
					<div class="col-md-7">
						<form:select path="userRole" items="${roles}" multiple="false" itemValue="id" itemLabel="role" class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="userRole" class="help-inline"/>
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