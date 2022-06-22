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
    <div class="tophalf d-flex">
        <div class="leftside col-9">
            <h1>Welcome <c:out value="${user.userName}"/></h1>
            <h3>Books from Everyone's Shelves: </h3>
        </div>
        <div class="rightside col-9">
            <h4><a href="/logout">Logout</a></h4>
            <h6><a href="/books/new">Add a book to my shelf</a></h6>
        </div>
    </div>
    <div class="bottom d-flex">
        <table class="table col-9">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Title</th>
                    <th>Author Name</th>
                    <th>Posted By</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="book" items="${books}">
                <tr>
                    <td><c:out value="${book.id}" /></td>
                    <td><a href="/books/${book.id}"><c:out value="${book.title}" /></a></td>
                    <td><c:out value="${book.author}" /></td>
                    <td><c:out value="${book.user.userName}" /></td>
                </tr>   
                </c:forEach>
            </tbody>
       
        </table>
    </div>
</body>
</html>
