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
<title>Insert title here</title>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="/css/style.css">


</head>
<body>
<nav id="navbar" class="navbar   d-flex bg-primary justify-content-evenly">
  <div class="container-fluid">
    <span class="navbar-brand mb-0 h1">Chapter2</span>
  </div>
  <div class="mx-auto"><form class="d-flex" role="search">
      <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
      <button class="btn btn-outline-success" type="submit">Search</button>
    </form>
  </div>
  <div class="btn-group">
  <a href="/login" class="btn btn-primary loginbtn">Login</a>
  <a href="/register" class="btn btn-success">Sign up</a>
  <a href="/jobs/new" class="btn btn-primary">Create Job</a>
  </div>
</nav>
<div>
<h1>We aspire to provide new opportunities to our brethren 
who have come out of prison and are looking to work</h1>
<img src="image/worker.jpg" class="img-fluid"  style="float:left;width:6000px;height:600px; alt="worker">
</div>
<div>
<h4>Unfortunately, ex-offenders might find that they don't qualify for certain jobs because of their criminal record.
 Additionally, in many cases, 
 parolees face discrimination due to the stigma associated with having been in prison.</h4>
 <h4> The graph below displays this</h4>
 <img src="image/unemployment" class="img-fluid" style="float:left;width:6000px;height:600px;alt="unemployment">
</div>


<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>

</body>
</html>