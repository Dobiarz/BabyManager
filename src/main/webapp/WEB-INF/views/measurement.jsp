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
    <%--<link rel="stylesheet" type="text/css" href="webjars/bootstrap/4.0.0/css/bootstrap.min.css">--%>
    <%--<link rel="stylesheet" href="webjars/font-awesome/4.7.0/css/font-awesome.css">--%>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
              integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <title>BabyManager</title>
</head>
<body>

<%@include file="header.jspf" %>

<div class="container">

    <header>Measurement</header>

    <div class="card">
        <div class="card-body">
            <a href="/measurement/add" class="btn btn-primary">Add Measurement</a>

        </div>
    </div>
    <div class="card mt-4">
        <div class="card-body">

            <table class="table table-hover">
                <tr>

                    <th>Baby</th>
                    <th>Time</th>
                    <th>Weight(kg)</th>
                    <th>Height(cm)</th>
                    <th>Head Circumference(cm)</th>
                    <th style="width: 15%">Actions</th>
                </tr>
                <c:forEach items="${measurements}" var="measurement">
                    <tr>
                        <td>${measurement.baby.name}</td>
                        <td>${measurement.beginning.toLocalDate()} ${measurement.beginning.toLocalTime()}</td>
                        <td>${measurement.weight}</td>
                        <td>${measurement.height}</td>
                        <td>${measurement.headCircumference}</td>
                        <td>
                            <a href="/measurement/update/${measurement.id}"
                               class="btn btn-success"><i class="fa fa-pencil" aria-hidden="true"></i></a>
                            <a href="#" onclick="confirmDelete(${measurement.id}, '${measurement['class'].simpleName}')"
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
