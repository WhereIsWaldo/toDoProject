 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

    <jsp:include page="style.jsp"></jsp:include>


    <title>Login</title>
</head>
<body>


<div class='container'>
    <div class='wrapper'>
        <form action="login" method="post" name="LoginForm" class="form-signin">
            <h3 class="form-signin-heading">

                <img src="${pageContext.request.contextPath}/resources/images/icon2.png"/>
                To DO!</h3>
                <p style="color:black"><b>Hello again ${cookie.savedCookie.value}!</b></p>

            <hr class="colorgraph">
            <br>
            <div class="form-group has-feedback has-feedback-left">

                <input type="text" class="form-control has-feedback-left" name="name" placeholder="Username"
                       required="" autofocus=""/>
                <i class="form-control-feedback glyphicon glyphicon-user"></i>
            </div>
            <div class="form-group has-feedback has-feedback-;eft">
                <input type="password" class="form-control " name="password" placeholder="Password" required=""/>
                <i class="form-control-feedback glyphicon glyphicon-lock"></i>
            </div>

            <br><br>
            <button class="btn btn-lg btn-primary btn-block" name="login" value="login" type="Submit">Login</button>
            <button type="button" onclick="location.href='registp'" class="btn btn-lg btn-danger btn-block" name="create">Create
                New Account
            </button>
           
            <h6>Accomplish more, every day.</h6>
        </form>
    </div>
</div>

</body>



</html>