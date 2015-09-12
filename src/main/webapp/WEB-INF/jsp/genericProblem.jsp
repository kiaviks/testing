<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to the client</title>
</head>
<body>
	<h2>:-( we have a problem...</h2>
	current date: <fmt:formatDate value="${dateTime}" pattern="dd-MM-yyyy HH:mm"/><br/>
	<br/>
	<span style="font-family: monospace; font-size: 12px; white-space: nowrap;">
	<p>The exception is : ${exception} <br />
	<br/>
	<br/>
		<c:forEach var="stackTraceElem" items="${exception.stackTrace}">
			<c:out value="${stackTraceElem}"/><br/>
		</c:forEach>
	</span>
</body>
</html>