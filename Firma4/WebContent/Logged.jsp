<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>

<div  class="jumbotron text-center">
  <h1>FIRMA</h1>
  <p>Aplikacija za lakse vodjenje firme</p>
</div>

<style>
.box{
   width: 200px;
   height: 100 px;
   padding: 20 px;
   margin: 100px auto;
   box-shadow: 0px 0px 10px 2px;
}
</style>

<title>FIRMA</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>




	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: 007399">
			<div>
				<a class="navbar-brand">FIRMA</a>
			</div>
	

	</header>
<body>
<div class="container">
<div class = "slika">
  <div class="row">
    <div class = "box" class="col-sm-4">
     <a href ="<%=request.getContextPath()%>/list"  >Zaposleni</a>
      <p>Lista zaposlenih</p>
    </div>
    <div class = "box" class="col-sm-4">
     <a href = "<%=request.getContextPath()%>/branch"> Lista grana poslovanja</a>
      <p>Lista koja pokazuje ID odredjene grane poslovanja</p>
    </div>
    <div class="box" class="col-sm-4">
      <a href = "Login.jsp">ODJAVI SE</a> 
      <p> Odjava iz aplikacije</p>
    </div>
    </div>
  </div>
</div>



</body>

</html>