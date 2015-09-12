<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Customer registration</title>
</head>
<body>
	<h2><spring:message code="New.customer.signup"/></h2>
	<br>
	<c:url var="registrationController" value="/newCustomer.do" />
	<form:form action="${registrationController}" method="post" modelAttribute="customer" id="registrationForm">
		<table border="0">
			<tr>
				<td>Type:</td>
				<td>
					<form:select path="userType" 
						items="${userTypes}"
						itemValue="id" 
						itemLabel="name" />
				</td>
			</tr>
			<tr>
				<td>id:</td>
				<td><form:input path="id"  readonly="true" /></td>
				<td></td>
			</tr>
			<tr>
				<td>nickname:</td>
				<td><form:input path="nickName"/></td>
				<td><form:errors path="nickName" cssStyle="color:red; font-size: 12px;" /></td>
				
			</tr>
			<tr>
				<td>email:</td>
				<td><form:input path="email"/></td>
				<td><form:errors path="email" cssStyle="color:red; font-size: 12px;" /></td>
			</tr>
			<tr>
				<td>pwd:</td>
				<td><form:password path="pwd"/></td>
				<td><form:errors path="pwd" cssStyle="color:red; font-size: 12px;" /></td>
			</tr>
			<tr><td>&nbsp;</td></tr>
			<tr>
				<td> <input type="submit" value="submit"> </td>
				<td> <input type="reset" value="reset"> </td>
			</tr>
		</table>
	</form:form>
</body>
</html>