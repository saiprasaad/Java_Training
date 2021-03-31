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
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js" integrity="sha384-xrRywqdh3PHs8keKZN+8zzc5TX0GRTLCcmivcbNJWm2rs5C8PRhcEn3czEjhAO9o" crossorigin="anonymous"></script>
<style>
body {
    background: #ddd;
    min-height: 100vh;
    vertical-align: middle;
    display: flex;
    font-family: sans-serif;
    font-size: 0.8rem;
    font-weight: bold
}

.title {
    margin-bottom: 5vh
}

.card {
    margin: auto;
    max-width: 950px;
    width: 90%;
    box-shadow: 0 6px 20px 0 rgba(0, 0, 0, 0.19);
    border-radius: 1rem;
    border: transparent
}
.cart {
    background-color: #fff;
    padding: 4vh 5vh;
    border-radius: 1rem;
}


.row {
    margin: 0
}

.title b {
    font-size: 1.5rem
}

.main {
    margin: 0;
    padding: 2vh 0;
    width: 100%
}

.col-2,
.col {
    padding: 0 1vh
}

a {
    padding: 0 1vh
}

.close {
    margin-left: auto;
    font-size: 0.7rem
}

img {
    width: 3.5rem
}

.back-to-shop {
    margin-top: 4.5rem
}

h5 {
    margin-top: 4vh
}

hr {
    margin-top: 1.25rem
}

form {
    padding: 10vh 0
}

select {
    border: 1px solid rgba(0, 0, 0, 0.137);
    padding: 1.5vh 1vh;
    margin-bottom: 4vh;
    outline: none;
    width: 100%;
    background-color: rgb(247, 247, 247)
}

input {
    border: 1px solid rgba(0, 0, 0, 0.137);
    padding: 1vh;
    margin-bottom: 4vh;
    outline: none;
    width: 100%;
    background-color: rgb(247, 247, 247)
}

.form-control {
    width:70px;
}

#code {
    background-image: linear-gradient(to left, rgba(255, 255, 255, 0.253), rgba(255, 255, 255, 0.185)), url("https://img.icons8.com/small/16/000000/long-arrow-right.png");
    background-repeat: no-repeat;
    background-position-x: 95%;
    background-position-y: center
}</style>
</head>
<body>
	<div class="container">
	<form action="shopping.do" method="post">
	<input type="hidden" name="formid" value="shopping">
	<input type="hidden" name="shopid" value="grocery">
	<input type="hidden" name="currentid" value="jewellery"> 

	<div class="card">
    <div class="row">
        <div class="col-md-12 cart">
            <div class="title">
                <div class="row">
                    <div class="col">
                        <h4><b>Jewellery Shop</b></h4>
                    </div>
                </div>
            </div>
            <div class="row border-top border-bottom">
                <div class="row main align-items-center">
                    <div class="col"><h6 class="font-weight-bolder">Product Image</h6></div>
                    <div class="col">
                        <div class="row"><h6 class="font-weight-bolder">Item Name</h6></div>
                    </div>
                    <div class="col"><h6 class="font-weight-bolder">Item Quantity</h6></div>
                    <div class="col"><h6 class="font-weight-bolder">Item Unit</h6></div>
                    <div class="col"><h6 class="font-weight-bolder">Price</h6></div>
                    <div class="col"><h6 class="font-weight-bolder">Select</h6></div>
                </div>
            </div>
            <c:forEach items="${items}" var="item">
            <div class="row">
                <div class="row main align-items-center">
                    <div class="col"><img class="img-fluid" src=<c:out value='${item.getImage()}'/>></div>
                    <div class="col">
                        <div class="row">${item.getItemdescription()}</div>
                    </div>
                    <div class="col mt-3"><input type="number" class="form-control" name=<c:out value='${item.getItemno()}' />></div>
                    <div class="col">${item.getItemunit()} </div>
                    <div class="col">&#8377; ${item.getItemprice()} </div>
                    <div class="col"><input class="form-control" type="checkbox" name="selected" value=<c:out value='${item.getItemno()}' />></div>
                </div>
            </div>
            </c:forEach>
            <div class="back-to-shop">
		<input type="submit" value="Next Shop" class="btn btn-outline-dark rounded-pill"></div>
        </div>
    </div>
</div>

	</form>
	</div>
</body>
</html>