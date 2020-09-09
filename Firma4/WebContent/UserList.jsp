<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>

<head>
<title>FIRMA</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
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
					 <a href = "<%=request.getContextPath()%>/branch" class = "nav-link"> Lista grana poslovanja</a>
					<a href = "Kontakt.jsp" class = "nav-link">Email zaposlenih</a>
					<a href = "Login.jsp" class="nav-link"> ODJAVA </a>
			</ul>
	</header>
	<br>

	<div class="row">
		

		<div class="container">
			<h3 class="text-center">Lista zaposlenih</h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/new" class="btn btn-success">Dodaj</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Ime </th>
						<th>Prezime </th>
						<th>Godine </th>
					    <th>Adresa </th>
					    <th>Spol </th>
					    <th>Pozicija </th>
					    <th>Id grane poslovanja  </th>
					    <th>Plata  </th>
					    <th>Email  </th>
					    <th>Telefon </th>
					    <th>ID</th>
					    <th></th>
					</tr>
				</thead>
				<tbody>
				
					<c:forEach var="user" items="${list}">

						<tr>
							<td><c:out value="${user.firstname}" /></td>
							<td><c:out value="${user.lastname}" /></td>
							<td><c:out value="${user.age}" /></td>
							<td><c:out value="${user.adress}" /></td>
							<td><c:out value="${user.sex}" /></td>
							<td><c:out value="${user.post}" /></td>
							<td><c:out value="${user.branchId}" /></td>
							<td><c:out value="${user.salary}" /></td>
							<td><c:out value="${user.email}" /></td>
                            <td><c:out value="${user.phone}" /></td>
                            <td><c:out value="${user.empId}" /></td>				
							<td><a href="edit?empId=<c:out value='${user.empId}' />">Uredi</a>
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="delete?empId=<c:out value='${user.empId}' />">Obrisi</a></td>
						</tr>
					</c:forEach>
				</tbody>

			</table>
		</div>
	</div>
</body>
</html>