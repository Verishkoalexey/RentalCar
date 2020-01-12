<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Auto List</title>
<link href="<c:url value='/static/css/auto.css' />" rel="stylesheet"></link>
</head>
<body>
	<header>
		<%@include file="authheader.jsp"%>
	</header>
	<div class='row'>
		<c:forEach items="${autos}" var="auto">
			<div class='product--blue'>
				<div class='product_inner'>
					<img src='${auto.image}' width='300'>
					<p>${auto.mark} ${auto.model}</p>
					<p>${auto.volume} ${auto.engine}</p>
					<p>Привод: ${auto.driveType.name}</p>
					<p>Трансмиссия: ${auto.transmission.name}</p>
					<form action="/rent-viewManager-${auto.id}">
						<button type="submit">Забронировать</button>
					</form>
				</div>
			</div>
		</c:forEach>
	</div>
</body>
</html>