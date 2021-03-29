<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="model.ItemMasterDTO" %>
    <%@ page import="java.util.Set" %>
    <%@ page import="java.util.HashMap" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="yellow">
	<hr>
	<jsp:include page="logout.jsp"></jsp:include>
	<hr>
	<h1>JewelleryShop</h1>
	
	<form action="shopping.do" method="post">
	<input type="hidden" name="formid" value="shopping">
	<input type="hidden" name="shopid" value="grocery">
	<input type="hidden" name="currentid" value="jewellery"> 
	<table border="1">
	<tr>
	<th>Item Name</th>
	<th>Item Quantity</th>
	<th>Image</th>
	<th>Select</th>
	</tr>

	<c:forEach items="${items}" var="item">
	<tr>
	<td>${item.getItemdescription()}</td> 
	<td><select name=<c:out value='${item.getItemno()}' />>
	<option value="0">Select quantity</option>
	<option value="1">1</option>
	<option value="2">2</option>
	<option value="3">3</option>
	<option value="4">4</option>
	<option value="5">5</option>
	</select></td>
	<td><img src=<c:out value='${item.getImage()}'/> width="100" height="100"></td>
	<td><input type="checkbox" name="selected" value=<c:out value='${item.getItemno()}' />></td>
	</tr>
</c:forEach>
		</table>
		
		
		<input type="submit" value="Next Shop..">
	</form>
</body>
</html>