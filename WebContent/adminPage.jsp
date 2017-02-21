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
  			<p >2 + 2 = ${scala} , Hello from Scala class</p>
  			
<jsp:setProperty name="name" property="userName" value="${user.userName}"/>
	<p style='color:black'><jsp:getProperty name="name" property="userName" /> , Java Beans </p>
  			 <hr class="colorgraph"><br>
  			
  	
			  <%@ taglib uri="/WEB-INF/tagLink.tld" prefix="stam" %>
<stam:mylink youtubeLINK="wRyBlFAhOh8" />   		  
			
			  <p style="color: black;">
    <strong style="color: black;">Total Visitors:  <%= pageContext.getServletContext().getAttribute("userCounter") %></strong><br>
    <strong style="color: black;">Users online:  <%= pageContext.getServletContext().getAttribute("onlineUsers") %></strong><br>
    <strong style="color: black;">Sessions created:  <%= pageContext.getServletContext().getAttribute("addedCounter") %></strong> <br>
    <strong style="color: black;">Session deleted:  <%= pageContext.getServletContext().getAttribute("deletedCounter") %></strong> <br>
    <strong style="color: black;">Session replaced:  <%= pageContext.getServletContext().getAttribute("replacedCounter") %></strong></p>
			
			
			  <h6>Accomplish more, every day.</h6>  
			  <button type="button" class="btn btn-danger" onclick="location.href='logout'" name="logout"  >Log out</button>
			  <button type="button" class="btn btn-info" onclick="location.href='homep'" name="homep" >Home page</button>
		</form>
	</div>
</div>



</body>
</html>