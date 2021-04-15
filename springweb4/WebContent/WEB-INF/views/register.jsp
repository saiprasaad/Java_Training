<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<spring:form commandName="customerdetails" method="post" action="register">
		Customer Name :<spring:input path="customername"/>
		Customer Phone :<spring:input path="customerphone"/>
		Customer Address :<spring:input path="customeraddress"/>
		Customer Email :<spring:input path="customeremail"/>
		Username :<spring:input path="user.uname"/>
		Password :<spring:input path="user.upass"/>
				
		<input type="submit" value="register..">
		
	</spring:form>
</body>
</html>