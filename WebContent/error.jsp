<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:useBean id="name" class="il.ac.hit.tables.Users" scope="session"/>
 <jsp:include page="style.jsp"></jsp:include>
<title>Insert title here</title>
</head>
<body>
<a href="" onclick="location.href="rest" "></a>
<div class='container'>
	<div class='wrapper'>
		<form action="newT" method="get" name="LoginForm" class="form-signin">
  			<h3 class="form-signin-heading">
  			
  			<img src="${pageContext.request.contextPath}/resources/images/icon2.png" />
  			Welcome ${user.userName}! </h3>
  			
  				<p>Error</p>
  				<p>Sorry, something went wrong.</p>
  				<p>A team of highly trained monkeys has been dispatched to deal with this situation.</p>
  				<p>If you see them, you can try to show them the problem:</p>
				<img src="${pageContext.request.contextPath}/resources/images/errorMonkey.jpg" />
  			
  	

			
			  <h6>Accomplish more, every day.</h6>  
			  <button type="button" class="btn btn-danger" onclick="location.href='logout'" name="logout"  >Log out</button>
			  <button type="button" class="btn btn-info" onclick="location.href='homep'" name="homep" >Home page</button>
		</form>
	</div>
</div>
</body>
</html>