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
<style>
body{
	font-size : 14px;
	background-color: #f2f6f9;
}

.minicart{
	background:url(cart.png);
	background-position: -156px 11px;
	background-repeat:no-repeat;
	width: 40px;
	height: 50px;
	padding-right: 32px;
}
container-fluid.text-center{
	padding: 0 32px;
	
	background-color: #ffffff;
}

.row{
	box-shadow: 0 1px 0 #e1e5e8;
	padding-bottom :0;
	padding:10px;
	margin-bottom: 11px;
}
.columnCaptions{
	color: #7e93a7;
	font-size:12px;
	text-transform: uppercase;
	padding: 0;
	box-shadow: 0 0 0;
	background-color: #f2f6f9;
}
.itemName{	
	color: #727578;
	font-size :16px;
	font-weight: bold; 
	float: left;
	padding-left:25px;
}
.quantity{	
	color: #4ea6bc;
	font-size :18px;
	font-weight: bold;
	float : left;
	width: 42px;
	padding-left: 7px;
}
.price{
	color: #f06953;
	font-size :18px;
	font-weight: bold;
	float: right;
}
</style>
</head>
<body>
<div class="container-fluid text-center p-5">
<p class="display-2">Invoice</p>
            <div class="row">
			<div class="col-6">
				<h1 style="padding:10px;">Your Details</h1>
	<h4 class="font-weight-light">Customer Name : ${totaldetails.getCustomermasterdto().getCustomername()}</h4>
	<h4 class="font-weight-light">Customer Email: ${totaldetails.getCustomermasterdto().getCustomeremail()}</h4>
	<h4 class="font-weight-light">Customer Phone: ${totaldetails.getCustomermasterdto().getCustomerphone()}</h4>
	<h4 class="font-weight-light">Customer Address: ${totaldetails.getCustomermasterdto().getCustomeraddress()}</h4>
	</div>
	<div class="col-6">
	
	<table>
	<tr><h1 class="row font-weight-light mr-5 text-center">Items Purchased</h1></tr>
		<tr class="row list-inline columnCaptions">
        <th class="col-3">Item No</th>
        <th class="col-3">Item Description</th>
        <th class="col-3">Item Quantity</th>
        <th class="col-3">Item Price</th>
		</tr>
	<c:forEach items="${totaldetails.getItemdetails()}" var="item">
	<tr class="row">
	<td class="col-3 quantity">${item.getItemno()}</td> 
	<td class="col-3 itemname">${item.getItemdescription()}</td>
	<td class="col-3 quantity">${item.getItemqty()}</td>
	<td class="col-3 price">${item.getItemprice()}</td>
	</tr>
	</c:forEach>
		</table>
		</div>
		</div>
	<div class="row justify-content-center">
	<form action="pdf.do" method="post">
	<input type="hidden" name="formid" value="pdf">
	<div class="col-auto"><input class="btn btn-outline-dark rounded-pill" type="submit" value="Create PDF"></div></form>
	<form action="excel.do" method="post">
	<input type="hidden" name="formid" value="excel">
	<div class="col-auto"><input class="btn btn-outline-dark rounded-pill" type="submit" value="Create Excel"></div></form>
	<form action="email.do" method="post">
	<input type="hidden" name="formid" value="email">
	<div class="col-auto"><input class="btn btn-outline-dark rounded-pill" type="submit" value="Send Email"></div></form>
	<form action="sms.do" method="post">
	<input type="hidden" name="formid" value="sms">
	<div class="col-auto"><input class="btn btn-outline-dark rounded-pill" type="submit" value="Send SMS"></div></form></div>
</div>
</body>
</html>