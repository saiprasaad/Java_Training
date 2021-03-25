<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<hr>
	<jsp:include page="logout.jsp"></jsp:include>
	<hr>
	<h1>FruitShop</h1>
	<form action="shop.do" method="post">
	<input type="hidden" name="formid" value="shop">
	<input type="hidden" name="shopid" value="shop3">
		Mangoes: <input type="checkbox" name="c7" value="Mangoes">
		Apples: <input type="checkbox" name="c8" value="Apples">
		Bananas: <input type="checkbox" name="c9" value="Bananas">
		
		<input type="submit" value="Invoice..">
	</form>
</body>
</html>