<%--
  Created by IntelliJ IDEA.
  User: tomasz
  Date: 21.05.19
  Time: 10:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <title>BabyManager</title>
</head>
<body>

<%@include file="header.jspf" %>

<div class="container">

    <header>Nap</header>

    <div class="card">
        <div class="card-body">
            <a href="/books/add" class="btn btn-primary">Add Nap</a>

        </div>
    </div>
    <div class="card mt-4">
        <div class="card-body">

            <table class="table table-hover">
                <tr>

                    <th>Begining</th>
                    <th>End</th>
                    <th>Baby Name</th>
                    <th style="width: 15%">Actions</th>
                </tr>
                <c:forEach items="${naps}" var="nap">
                    <tr>
                        <td>${nap.beginning.toLocalDate()} ${nap.beginning.toLocalTime()}</td>
                        <td>${nap.end.toLocalTime()} ${nap.end.toLocalDate()}</td>
                        <td>${nap.baby.name}</td>
                        <td>
                            <%--<a href="/books/update/${book.id}" class="btn btn-success">Edit</a>--%>
                            <%--<a href="#" onclick="confirmDelete(${book.id}, '${book.title}')" class="btn btn-danger">Delete</a>--%>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>

</body>
</html>