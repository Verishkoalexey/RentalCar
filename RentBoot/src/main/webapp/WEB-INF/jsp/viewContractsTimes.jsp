<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Users List</title>
<link href="<c:url value='/static/css/bootstrap.css' />"
	rel="stylesheet"></link>
<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>

<body>
	<div class="generic-container">
		<%@include file="authheader.jsp"%>
		<div class="panel panel-default">
			<!-- Default panel contents -->
			<div class="panel-heading">
				<span class="lead">List of Rent </span>
			</div>
			<table class="table table-hover">
				<thead>
					<tr>
						<th>Rent Auto</th>
						<th>Start Rent</th>
						<th>Finish Rent</th>
						<th>Status Rent</th>
						<sec:authorize access="hasRole('ADMIN')">
							<th width="100"></th>
						</sec:authorize>
						<sec:authorize access="hasRole('ADMIN')">
							<th width="100"></th>
						</sec:authorize>
						<sec:authorize access="hasRole('ADMIN')">
							<th width="100"></th>
						</sec:authorize>


					</tr>
				</thead>
				<tbody>
					<c:forEach items="${viewManagers}" var="viewManager">
						<tr>
							<td>${viewManager.contract.auto.numberAuto}</td>
							<td>${viewManager.startRent}</td>
							<td>${viewManager.finishRent}</td>
							<td>${viewManager.statusRent.name}</td>
							<sec:authorize access="hasRole('ADMIN')">
								<td><a href="<c:url value='/contract-details-${viewManager.contract.id}' />"
									class="btn btn-office custom-width">details</a></td>
							</sec:authorize>
							<sec:authorize access="hasRole('ADMIN')">
								<td><a
									href="<c:url value='/edit-contracttime-${viewManager.id}' />"
									class="btn btn-success custom-width">edit</a></td>
							</sec:authorize>
							<sec:authorize access="hasRole('ADMIN')">
								<td><a
									href="<c:url value='/delete-contracttime-${viewManager.id}' />"
									class="btn btn-danger custom-width">delete</a></td>
							</sec:authorize>

						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<sec:authorize access="hasRole('ADMIN')">
			<div class="well">
				<a href="<c:url value='/newcontracttime' />">Add New Rent</a>
			</div>
		</sec:authorize>
	</div>
</body>
</html>