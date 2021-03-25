<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="model.ItemMasterDTO" %>
    <%@ page import="java.util.Set" %>
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
	
	<form action="shop.do" method="post">
	<input type="hidden" name="formid" value="shop">
	<input type="hidden" name="shopid" value="shop1">
	 

	
		Bangles: <input type="checkbox" name="c1" value="bangle">
		Necklace: <input type="checkbox" name="c2" value="necklace">
		Chain: <input type="checkbox" name="c3" value="chain">
		
		<input type="submit" value="Next Shop..">
	</form>
</body>
</html>