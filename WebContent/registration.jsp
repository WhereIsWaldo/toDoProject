<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    
    <!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- ----------------------- STYLES----------------------------------- -->
 <jsp:include page="style.jsp"></jsp:include>
<!-------------------------------------------------------------------- --->


<title>Reg</title>
</head>
<body>


<div class='container'>
	<div class='wrapper'>
		<form action="regist" method="post" name="LoginForm" class="form-signin">
  			<h3 class="form-signin-heading">
  			
  			<img src="${pageContext.request.contextPath}/resources/images/icon2.png" />
  			Registration!</h3>
  			
  			 <hr class="colorgraph"><br>
  			 <p style="color:red"><b>${invalidInput}</b> </p>
  			 <input type="text" class="form-control" name="username" placeholder="Username" required="" autofocus="" />
			  <input type="password" class="form-control" name="password" placeholder="Password" required=""/> 
			    <input type="password" class="form-control" name="password2" placeholder="Password again" required=""/>  
			    
			    <br><br>   		  
			  <button class="btn btn-lg btn-primary btn-block"  name="Submit" value="create" type="Submit">Create</button>
			  <h6>Accomplish more, every day.</h6>  
		</form>
	</div>
</div>



</body>
</html>