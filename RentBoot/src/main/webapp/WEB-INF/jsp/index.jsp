<!DOCTYPE HTML>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Users List</title>
<link href="<c:url value='static/css/books.css' />"
	rel="stylesheet"></link>
<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>
   <body>
      <h1>Welcome</h1>
       
     <h2>${list}</h2>
         
      <a href="${pageContext.request.contextPath}/list">View Manager</a>  
       
   </body>
   
</html>