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
<title>Create Job</title>
 <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
<body>
<div class="container mt-5">
   <h1>Edit Job</h1>
   
   <form:form action="/jobs/new" method="Post" modelAttribute="job" class="form">
      <input type="hidden" name="_method" value="put"/>
	<div>
		<form:label path="title">Job title: </form:label><br />
		<form:errors path="title" class="text-danger"/>
		<form:input path="title" class="form-control"/>
	</div>
		<form:label path="description">Description </form:label><br />
		<form:errors path="description" class="text-danger"/>
		<form:textarea rows="6" path="description" class="form-control"/>
	</div>
		<div>
		<form:label path="location">Location</form:label><br />
		<form:errors path="location" class="text-danger"/>
		<form:input path="location" class="form-control"/>
	</div>
	<div>
		<form:label path="salary">Salary</form:label><br />
		<form:errors path="salary" class="text-danger"/>
		<form:input path="salary" class="form-control"/>
	</div>	
	<form:hidden path="user" value="${userId}" />
	<div>
		<input type="submit" value="Submit"/>
		<button><a href="/home">Cancel</a></button>
	</div>
    </form:form>
</body>
</html>