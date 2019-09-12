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
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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

    <header>Nap</header>

    <div class="card">
        <div class="card-body">
            <a href="/nap/add" class="btn btn-primary">Add Nap</a>

        </div>
    </div>
    <div class="card mt-4">
        <div class="card-body">

            <table class="table table-hover">
                <tr>

                    <th>Baby</th>
                    <th>Begining</th>
                    <th>End</th>
                    <th style="width: 15%">Actions</th>
                </tr>
                <c:forEach items="${naps}" var="nap">
                    <tr>
                        <td>${nap.baby.name}</td>
                        <td>${nap.beginning.toLocalDate()} ${nap.beginning.toLocalTime()}</td>
                        <td>${nap.end.toLocalDate()} ${nap.end.toLocalTime()} </td>
                        <td>
                            <a href="/nap/update/${nap.id}"
                               class="btn btn-success"><i class="fa fa-pencil" aria-hidden="true"></i></a>
                            <a href="#" onclick="confirmDelete(${nap.id}, '${nap['class'].simpleName}')"
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
