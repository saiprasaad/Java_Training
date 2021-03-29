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
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js" integrity="sha384-xrRywqdh3PHs8keKZN+8zzc5TX0GRTLCcmivcbNJWm2rs5C8PRhcEn3czEjhAO9o" crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
<div class="row justify-content-center">
    <div class="col-auto">
    <h1 class="display-4">Invoice</h1>
</div>
</div>

	<div class="row justify-content-center"><div class="col-auto"><span class="font-weight-bolder">Customer Name : </span><span>${totaldetails.getCustomermasterdto().getCustomername()}</span></div></div>
	<div class="row justify-content-center"><div class="col-auto"><span class="font-weight-bolder">Customer Email: </span><span>${totaldetails.getCustomermasterdto().getCustomeremail()}</span></div></div>
	<div class="row justify-content-center"><div class="col-auto"><span class="font-weight-bolder">Customer Phone: </span><span>${totaldetails.getCustomermasterdto().getCustomerphone()}</span></div></div>
	<div class="row justify-content-center"><div class="col-auto"><span class="font-weight-bolder">Customer Address: </span><span>${totaldetails.getCustomermasterdto().getCustomeraddress()}</span></div></div>
	<div class="row justify-content-center">
    <div class="col-auto">
	<table border="1" class="table table-responsive table-dark">
	<tr>
	<th>Item No</th>
	<th>Item Description</th>
	<th>Item Quantity</th>
	<th>Item Price</th>
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
		</div>
		</div>
	<div class="row justify-content-center">
	<form action="pdf.do" method="post">
	<input type="hidden" name="formid" value="pdf">
	<div class="col-auto"><input class="btn btn-primary rounded-pill" type="submit" value="Create PDF"></div></form>
	<form action="excel.do" method="post">
	<input type="hidden" name="formid" value="excel">
	<div class="col-auto"><input class="btn btn-primary rounded-pill" type="submit" value="Create Excel"></div></form>
	<form action="email.do" method="post">
	<input type="hidden" name="formid" value="email">
	<div class="col-auto"><input class="btn btn-primary rounded-pill" type="submit" value="Send Email"></div></form>
	<form action="sms.do" method="post">
	<input type="hidden" name="formid" value="sms">
	<div class="col-auto"><input class="btn btn-primary rounded-pill" type="submit" value="Send SMS"></div></form></div>
</div>
</body>
</html>