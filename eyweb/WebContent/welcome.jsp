<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome Page...Mr.<%=session.getAttribute("uname") %></h1>
	<hr>
	<jsp:include page="logout.jsp"></jsp:include>
	<hr>
	<form action="shopping.do" method="post">
	<input type="hidden" name="formid" value="shopping">		
	<input type="hidden" name="shopid" value="jewellery">
	
		<input type="submit" value="Shopping...">
	</form>
	
	
</body>
</html>