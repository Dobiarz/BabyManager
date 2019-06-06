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
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <title>BabyManager</title>
</head>
<body>

<%@include file="headerHome.jspf" %>

<div class="container">

    <header>Diaper</header>

    <div class="card">
        <div class="card-body">
            <a href="/diaper/add" class="btn btn-primary">Add Diaper</a>

        </div>
    </div>
    <div class="card mt-4">
        <div class="card-body">

            <table class="table table-hover">
                <tr>

                    <th>Baby</th>
                    <th>Time</th>
                    <th>Content</th>
                    <th style="width: 15%">Actions</th>
                </tr>
                <c:forEach items="${diapers}" var="diaper">
                    <tr>
                        <td>${diaper.baby.name}</td>
                        <td>${diaper.beginning.toLocalDate()} ${diaper.beginning.toLocalTime()}</td>
                        <td>${fn:join(diaper.content,', ')}</td>
                        <td>
                            <a href="/diaper/update/${diaper.id}"
                               class="btn btn-success"><i class="fa fa-pencil" aria-hidden="true"></i></a>
                            <a href="#" onclick="confirmDelete(${diaper.id}, '${diaper['class'].simpleName}')"
                               class="btn btn-danger"><i class="fa fa-trash" aria-hidden="true"></i></a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
<script>
    function confirmDelete(id, type) {
        if (confirm("Are you sure you want to delete a \"" + type + "\"?")) {
            window.location.href = "delete/" + id;
        }
    }
</script>
</body>
</html>
