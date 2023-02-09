<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
    <meta charset="UTF-8">
    <title>Dashboard</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5" > 
<h1>Welcome! <c:out value="${userName}"/></h1>

   <p><a href="/logout">Logout</a></p>
   <p> <a href="/jobs/new">create another opportunity</a></p>
   <table class="table">
<thead>
      <tr>

          <th>Title</th>
          <th> Job Location</th>
          <th>Salary</th>
          <th>Posted By</th>
         </tr>
</thead>
<tbody>
  <c:forEach var="job" items="${jobList}">
			<tr>
				<td><a href="/jobs/show/${job.id}"> <c:out value="${job.title}"/></a></td>				
				<td><c:out value="${job.location}"/></td>
				<td><c:out value="${job.salary}"/></td>
				<td><c:out value="${job.user.userName}"/></td>				
			</tr>
	</c:forEach>
  </tbody>
</table>
   
   
   
   
   </div>
</body>
  
</html>