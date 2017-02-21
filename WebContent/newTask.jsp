<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

       <jsp:include page="style.jsp"></jsp:include>

    <title>New Task</title>
</head>
<body>

<div class='container'>
    <div class='wrapper'>
        <form action="addnew" method="post" name="LoginForm" class="form-signin">
            <h3 class="form-signin-heading">

                <img src="${pageContext.request.contextPath}/resources/images/icon2.png"/>
                Welcome ${user.userName}!</h3>

            <hr class="colorgraph">
            <br>
          
       
          
            <div class="form-group">
                <div>
                    <input class="form-control" type="text" name="task" placeholder="Task" required=""/>
                </div>
            </div>
            <div class="form-group">

                <div>
                    <input class="form-control" type="text" name="description" placeholder="Description"/>
                </div>
            </div>

            <div>
                <button type="submit" class='btn btn-primary' name="create">Create</button>
                <button type='button'  onclick="location.href='homep'"class='btn btn-danger' name='cancel'>Cancel</button>
            </div>
            <h6>Accomplish more, every day.</h6>
        </form>
    </div>
</div>

</body>
</html>