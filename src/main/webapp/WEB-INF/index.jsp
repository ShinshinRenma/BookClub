<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
</head>
<body>
    <div class="container">
        <h1>Login and Registration</h1>
        <div class="main d-flex">
            <div class="register col-9">
                <h2>Register</h2>
                <form:form action="/register" method="post" modelAttribute="newUser">
                    <div class="form-group">
                        <form:label path="userName">User Name:</form:label>
                        <form:input type="text"  path="userName" />
                        <form:errors class="text-danger"  path="userName" />
                    </div>
                    <div class="form-group">
                        <form:label path="email">Email:</form:label>
                        <form:input type="text"  path="email" />
                        <form:errors class="text-danger"  path="email" />
                    </div>
                    <div class="form-group">
                        <form:label path="password">Password:</form:label>
                        <form:input type="text"  path="password" />
                        <form:errors class="text-danger"  path="password" />
                    </div>
                    <div class="form-group">
                        <form:label path="confirm">Confirm Password:</form:label>
                        <form:input type="text"  path="confirm" />
                        <form:errors class="text-danger"  path="confirm" />
                    </div>
                    <input type="submit" value="Register" class="btn btn-primary"/>
                </form:form>
            </div>
            <div class="login col-9">
                <h2>Login</h2>
                <form:form action="/login" method="post" modelAttribute="newLogin">
                    <div class="form-group">
                        <form:label path="email">Email:</form:label>
                        <form:input type="text"  path="email" />
                    </div>
                    <div class="form-group">
                        <form:label path="password">Password:</form:label>
                        <form:input type="password"  path="password" />
                    </div>
                    <input type="submit" value="Login" class="btn btn-primary"/>
                    <form:errors class="text-danger" path="email"/>
                    <form:errors class="text-danger" path="password" />
                </form:form>
            </div>
        </div>
        <h3 class="text-danger"><c:out value="${error}" /></h3>
    </div>
</body>
</html>
