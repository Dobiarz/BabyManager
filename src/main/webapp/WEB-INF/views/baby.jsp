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

<%@include file="headerBaby.jspf" %>

<div class="container">

    <header>Babies</header>

    <div class="card">
        <div class="card-body">
            <a href="/baby/add" class="btn btn-primary">Add Baby</a>

        </div>
    </div>
    <div class="card mt-4">
        <div class="card-body">

            <table class="table table-hover">
                <tr>

                    <th>Baby</th>
                    <th>Birthdate</th>
                    <th>Weight(kg)</th>
                    <th>Height(cm)</th>
                    <th>Head Circumference(cm)</th>
                    <th style="width: 15%">Actions</th>
                </tr>
                <c:forEach items="${babiesWithActualMeasurement}" var="baby">
                    <tr>
                        <td>${baby.name}</td>
                        <td>${baby.birthDate.toString()}</td>
                        <td>

                            <c:choose>
                                <c:when test="${baby.weight == 0 || baby.weight == null}">
                                    Add Measurement
                                </c:when>

                                <c:otherwise>
                                    ${baby.weight}
                                </c:otherwise>
                            </c:choose>

                        </td>
                        <td>
                            <c:choose>
                                <c:when test="${baby.height == 0 || baby.height == null}">
                                    Add Measurement
                                </c:when>

                                <c:otherwise>
                                    ${baby.height}
                                </c:otherwise>
                            </c:choose>
                        </td>
                        <td>
                            <c:choose>
                                <c:when test="${baby.headCircumference == 0 || baby.headCircumference == null}">
                                    Add Measurement
                                </c:when>

                                <c:otherwise>
                                    ${baby.headCircumference}
                                </c:otherwise>
                            </c:choose>
                        </td>
                        <td>
                            <a href="/baby/update/${baby.id}"
                               class="btn btn-success"><i class="fa fa-pencil" aria-hidden="true"></i></a>
                            <a href="#" onclick="confirmDelete(${baby.id}, '${baby.name}')"
                               class="btn btn-danger"><i class="fa fa-trash" aria-hidden="true"></i></a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
<script>
    function confirmDelete(id, name) {
        if (confirm("Are you sure you want to delete a \"" + name + "\" and all related records?")) {
            window.location.href = "delete/" + id;
        }
    }
</script>
</body>
</html>
