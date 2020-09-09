<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>
<html>
   <head>
   <link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
   
      <title>Firma</title>
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
					<a href = "Login.jsp" class="nav-link"> ODJAVA</a>
			</ul>
      </header>
      <br>
   
   
   
   
   <sql:setDataSource var = "snapshot" driver = "com.mysql.cj.jdbc.Driver"
      url = "jdbc:mysql://localhost/firma?allowPublicKeyRetrieval=true&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"
      user = "root" password = "123456aa"/>
       <sql:update dataSource = "${snapshot}" var = "count">
       truncate table contact;
      </sql:update>
   <sql:update dataSource = "${snapshot}" var = "count">
     insert into contact(Firstname,Lastname,Email) select Firstname, Lastname, Email from zaposleni where EmpId>0; 
      </sql:update>
      <sql:query dataSource = "${snapshot}" var = "result">
       
    		select * from contact; 
      </sql:query>
      
<div class="row">   
   <div class="container">
     <div class="container">
			<h3 class="text-center">Email kontakt zaposlenih</h3>
			<hr>
			<br>
      <table class="table table-bordered">
      <thead>
         <tr>
            <th>Ime</th>
            <th>Prezime</th>
            <th>Email</th>
        
         </tr>
         </thead>
         <tbody>
              <c:forEach var = "row" items = "${result.rows}">
            <tr>
               <td> <c:out value = "${row.Firstname}"/></td>
               <td> <c:out value = "${row.Lastname}"/></td>
               <td> <c:out value = "${row.Email}"/></td>
               
            </tr>
         </c:forEach>
         </tbody>
      </table>
   </body>
</html>