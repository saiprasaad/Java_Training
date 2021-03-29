<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="model.ItemMasterDTO" %>
    <%@ page import="java.util.Set" %>
    <%@ page import="java.util.HashSet" %>
     <%@ page import="java.util.HashMap" %>
         <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<table border="1">
	<tr>
	<th>Item No</th>
	<th>Item Description</th>
	<th>Item Price</th>
	<th>Item Quantity</th>
	<th>Item Unit</th>
	</tr>

	<c:forEach items="${totaldetails.getItemdetails()}" var="item">
	<tr>
	<td>${item.getItemno()}</td> 
	<td>${item.getItemdescription()}</td>
	<td>${item.getItemqty()}</td>
	<td>${item.getItemprice()}</td>
	<td>${item.getItemunit()}</td>
	</tr>
</c:forEach>
		</table>
</body>
</html>