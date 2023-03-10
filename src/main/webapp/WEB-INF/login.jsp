<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
    <meta charset="UTF-8">

    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <title>Login</title>
</head>
<body>
	<div class="form-group">
	<h1>Login</h1>
	<form:form action="/login" method="POST" modelAttribute="newLogin">
	<!--Login form  -->
		   		<div class="form-group">
		   			<form:label path="email">Email</form:label>
		   			<form:input  path="email" class="form-control"/>
		   			<form:errors path="email" class="text-danger"/>
		   		</div>
		   		<div class="form-group">
		   			<form:label path="password">password</form:label>
		   			<form:input  path="password" type="password" class="form-control"/>
		   			<form:errors path="password" class="text-danger"/>
		   		</div>
		   		<button type="submit" class="btn btn-primary">Login</button>
	</form:form>
	</div>
</body>
</html>