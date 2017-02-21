<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- ----------------------- STYLES----------------------------------- -->
 <jsp:include page="style.jsp"></jsp:include>
<!-------------------------------------------------------------------- --->

<title>Home</title>
</head>
<body>
<div class='container'>
	<div class='wrapper'>
		<form action="newT" method="get" name="LoginForm" class="form-signin">
  			<h3 class="form-signin-heading">
  			
  			<img src="${pageContext.request.contextPath}/resources/images/icon2.png" />
  			Welcome ${user.userName}! </h3>
  		

  			 <hr class="colorgraph"><br>
  			
  			<table class="table">
  			<thead>
  			<th>Task</th>
  			<th>Description</th>
  			</thead>
  			<c:forEach items="${listTasks}" var="item">
			<tr>
				
	   			<td class="row" height="30px">${item.task}</td>
	   			<td class="row" height="30px">${item.description}</td>
	   			<td class="row" height="30px">
	   			<button  type="button" class="btn btn-info" style="color:black" onclick="location.href='edit?idTask=${item.id}'">edit</button>
	   			<button type="button" class="btn btn-danger"style="color:black" onclick="location.href='delete?idTask=${item.id}'">delete</button>
	   			</td>
	   		 </tr>	 
		</c:forEach>
  			</table>
  			
			    <br><br>   		  
			  <button class="btn btn-lg btn-primary btn-block"  name="create" value="create" type="Submit">Create new task</button>
			  <h6>Accomplish more, every day.</h6>  
			  <button type="button" class="btn btn-danger" onclick="location.href='logout'" name="logout"  >Log out</button>
			  <button type="button" class="btn btn-info" onclick="location.href='adminp'" name="adminp" >Admin panel</button>
		</form>
	</div>
</div>

</body>
</html>