<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

    <jsp:include page="style.jsp"></jsp:include>
    <title>New Task</title>
</head>
<body>
<div class='container'>
    <div class='wrapper'>
        <form action="updateTask" method="post" name="LoginForm" class="form-signin">
            <h3 class="form-signin-heading">
                <img src="${pageContext.request.contextPath}/resources/images/icon2.png"/>
                Welcome ${user.userName}!</h3>
            <hr class="colorgraph">
            <br>
            <div class="form-group">
                <input class="form-control" type="text" value="${task.task}" name="task" placeholder="Task" required=""/>

            </div>
            <div class="form-group">
                <input class="form-control" type="text" value="${task.description}" name="description" placeholder="Description"/>
            </div>
            <div>
                <button type="submit" class='btn btn-primary' name="save">Save</button>
                <button type="button" onclick="location.href='homep'" class='btn btn-danger' name='homep'>Cancel</button>
            </div>
            <h6>Accomplish more, every day.</h6>
        </form>
    </div>
</div>
</body>
</html>