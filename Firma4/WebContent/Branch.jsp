<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<title> FIRMA </title>
</head>
<body>
			<header>
			<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color:  007399">
			<div>
			<ul class="navbar-nav"> 
				<a href = "Logged.jsp" class="navbar-brand">Firma</a>
				</ul>
			</div>

				<ul class="navbar-nav"> 
				<a href="<%=request.getContextPath()%>/list"
					class="nav-link"  >ZAPOSLENI</a>
					<a href = "Login.jsp" class="nav-link">ODJAVA </a>
			</ul>
      </header>
      <br>
	<div class="row">
	
		<div class="container">
			<h3 class="text-center">Lista grana poslovanja</h3>
			<hr>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Ime grane poslovanja </th>
						<th>ID grane poslovanja </th>
					</tr>
				</thead>
				
				<tbody>
				
					<c:forEach var="Branch" items="${branch}">

						<tr>
							<td><c:out value="${Branch.branchName}" /></td>
							<td><c:out value="${Branch.branchId}" /></td>
							&nbsp;&nbsp;
						</tr>
					</c:forEach>
					
				</tbody>

			</table>
		</div>
	</div>
  
  
  
</body>
</html>