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
        <div class="tophalf">
            <div class="leftside col-9">
                <h1>Add a Book to Your Shelf</h1>
            </div>
            <div class="rightside col-9">
                <h4><a href="/dashboard">Back to the Shelves</a></h4>
            </div>
        </div>
        <div class="main d-flex">
            <div class="register col-9">
                <h6 class="text-danger"><c:out value="${error}" /></h6>
                <form:form action="/books" method="post" modelAttribute="book"> 
                    <div class="form-group">
                        <form:label path="title">Title:</form:label>
                        <form:input type="text"  path="title" />
                        <form:errors class="text-danger"  path="title" />
                    </div>
                    <div class="form-group">
                        <form:label path="author">Author:</form:label>
                        <form:input type="text"  path="author" />
                        <form:errors class="text-danger"  path="author" />
                    </div>
                    <div class="form-group">
                        <form:label path="thoughts">My Thoughts:</form:label>
                        <form:input type="textarea"  path="thoughts" />
                        <form:errors class="text-danger"  path="thoughts" />
                    </div>
                    <input type="submit" value="Submit" class="btn btn-primary"/>
                </form:form>
            </div>
            </div>
        </div>
        
    </div>
</body>
</html>
