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
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

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

    <header>Feeding</header>

    <div class="card">
        <div class="card-body">
            <a href="/feeding/leftBreast/add" class="btn btn-primary">Add Feeding Left Breast</a>
            <a href="/feeding/rightBreast/add" class="btn btn-primary">Add Feeding Right Breast</a>
            <a href="/feeding/bottle/add" class="btn btn-primary">Add Feeding Bottle</a>
            <a href="/feeding/pump/add" class="btn btn-primary">Add Feeding Pump</a>
            <a href="/feeding/solid/add" class="btn btn-primary">Add Feeding Solid</a>
        </div>
    </div>
    <div class="card mt-4">
        <div class="card-body">

            <table class="table table-hover">
                <tr>
                    <th>Baby</th>
                    <%--<th>DTYPE</th>--%>
                    <th>Feeding Type</th>
                    <th>Beginning/Time</th>
                    <th>End</th>
                    <th>Milk Type</th>
                    <th>Foods</th>
                    <th>Volume</th>
                    <th>Breast</th>
                    <th style="width: 15%">Actions</th>
                </tr>
                <c:forEach items="${feedings}" var="feeding">
                    <tr>
                        <td>${feeding.baby.name}</td>
                            <%--<td>${feeding.DTYPE}</td>--%>
                        <td>${feeding['class'].simpleName}</td>
                        <td>${feeding.beginning.toLocalDate()} ${feeding.beginning.toLocalTime()}</td>
                        <td>
                            <c:choose>
                                <c:when test="${feeding['class'].simpleName == 'LeftBreast' || feeding['class'].simpleName == 'RightBreast'}">
                                    ${feeding.end.toLocalDate()} ${feeding.end.toLocalTime()}
                                </c:when>

                                <c:otherwise>
                                    -
                                </c:otherwise>
                            </c:choose>
                        </td>
                        <td>

                            <c:choose>
                                <c:when test="${feeding['class'].simpleName == 'Bottle'}">
                                    ${feeding.milkType}
                                </c:when>

                                <c:otherwise>
                                    -
                                </c:otherwise>
                            </c:choose>

                        </td>
                        <td>

                            <c:choose>
                                <c:when test="${feeding['class'].simpleName == 'Solid'}">
                                    ${fn:join(feeding.foods,', ')}
                                </c:when>

                                <c:otherwise>
                                    -
                                </c:otherwise>
                            </c:choose>

                        </td>
                        <td>
                            <c:choose>
                                <c:when test="${feeding['class'].simpleName == 'Bottle' || feeding['class'].simpleName == 'Pump'}">
                                    ${feeding.volume}
                                </c:when>

                                <c:otherwise>
                                    -
                                </c:otherwise>
                            </c:choose>


                        </td>
                        <td>

                            <c:choose>
                                <c:when test="${feeding['class'].simpleName == 'Pump'}">
                                    ${feeding.breast}
                                </c:when>

                                <c:otherwise>
                                    -
                                </c:otherwise>
                            </c:choose>

                        </td>
                        <td>
                            <a href="/feeding/${feeding['class'].simpleName}/update/${feeding.id}"
                               class="btn btn-success"><i class="fa fa-pencil" aria-hidden="true"></i></a>
                            <a href="#" onclick="confirmDelete(${feeding.id}, '${feeding['class'].simpleName}')"
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
        if (confirm("Are you sure you want to delete a feeding \"" + type + "\"?")) {
            window.location.href = "delete/" + id;
        }
    }
</script>

</body>
</html>
