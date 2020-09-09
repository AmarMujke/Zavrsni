<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<html>
<head>
<title>Firma</title>
<link rel="stylesheet"
href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
crossorigin="anonymous">
</head>
<body>


<header>
  <nav class="navbar navbar-expand-md navbar-dark"
  style="background-color : 007399">
  <div>
     <a href="Logged.jsp" class = "navbar-brand"> Firma </a>
  </div>
  
      <ul class="navbar-nav">
      <li><a href = "<%=request.getContextPath()%>/list"
      class="nav-link">Zaposleni</a></li> 
    </ul>
  </nav>
</header>
<br>
<div class = "container col-md-5">
<div class = "card">
<div class="card-body">
<c:if test="${user !=null}">
<form action="update" method = "post">
</c:if>
<c:if test="${user == null }">
<form action="insert" method = "post">

</c:if>

<caption>
<h2>
   <c:if test="${user !=null}">
   Uredi
   </c:if>
   <c:if test="${user == null }">
   Dodaj 
   </c:if>
   </h2>
   </caption>
   
   <c:if test = "${user !=null }">
   <input type="hidden" name="empId" value="<c:out value = '${user.empId}' />"/>
   </c:if>
   <fieldset class = "form-group">
   <label>Ime</label><input type = "text"
   value="<c:out value = '${user.firstname}'/> " class = "form-control"
   name="Firstname" required="required">
   </fieldset>
   
     <fieldset class = "form-group">
   <label>Prezime</label>
   <input type="text"
   value="<c:out value = '${user.lastname}' />" class="form-control"
   name="Lastname">
      </fieldset>
   
     <fieldset class = "form-group">
   <label>Godine</label>
   <input type="number" value="<c:out value = '${user.age}' />" class="form-control"
   name="age">
   </fieldset>
   
   
   <fieldset class = "form-group">
   <label>Adresa</label><input type="text"
   value="<c:out value = '${user.adress}' />" class="form-control"
   name="Adress">
   </fieldset>
  
    <fieldset class = "form-group">
   <label>Spol</label><input type="text"
   value="<c:out value = '${user.sex}' />" class="form-control"
   name="Sex">
   </fieldset>
   
    <fieldset class = "form-group">
   <label>Pozicija</label><input type="text"
   value="<c:out value = '${user.post}' />" class="form-control"
   name="post">
   </fieldset>
 
     <fieldset class = "form-group">
   <label>Id grane poslovanja(1,2 ili 3)</label>
   <input type="number"  value="<c:out value = '${user.branchId}' />" class="form-control"
   name="branchId">
   </fieldset>
   
     <fieldset class = "form-group">
   <label>Plata</label>
   <input type="number"  value="<c:out value = '${user.salary}' />" class="form-control"
   name="salary">
   </fieldset>
   
      <fieldset class = "form-group">
   <label>Email</label><input type="Email"
   value="<c:out value = '${user.email}' />" class="form-control"
   name="Email">
   </fieldset>
   
      <fieldset class = "form-group">
   <label>Telefon</label>
   <input type="number"  value="<c:out value = '${user.phone}' />" class="form-control"
   name="phone">
   </fieldset>
    
    
   <button type="submit" class ="btn btn-success">Spasi</button>
 </form>
</div>
</div>
</div>
</body>
</html>