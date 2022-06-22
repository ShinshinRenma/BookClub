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
    <link rel="stylesheet"href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
    <div class="container">
        <div class="tophalf">
            <div class="leftside col-9">
                <h1><c:out value="${book.title}"/></h1>
            </div>
            <div class="rightside col-9">
                <h4><a href="/dashboard">Back to the Shelves</a></h4>
            </div>
        </div>
        <div class="main d-flex">
            <div class="register col-9">
                <h6><c:out value="${book.user.userName}"/> read <c:out value="${book.title}"/> by <c:out value="${book.author}"/></h6>
                <h6>Here are <c:out value="${book.user.userName}"/>'s thoughts:</h6>
                <div class="thoughts">
                    <h6><c:out value="${book.thoughts}"/></h6>
                </div>
            </div>
            </div>
        </div>
        
    </div>
</body>
</html>
