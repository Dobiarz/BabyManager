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
    <%--<link rel="stylesheet" type="text/css" href="webjars/bootstrap/4.0.0/css/bootstrap.min.css">--%>
    <%--<link rel="stylesheet" href="webjars/font-awesome/4.7.0/css/font-awesome.css">--%>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">



    <%--<script src="<c:url value="/webjars/jquery/3.0.0/jquery.min.js"/>"></script>--%>
    <%--<script src="<c:url value="/webjars/bootstrap/4.3.1/js/bootstrap.min.js"/>"></script>--%>
    <%--<link href="<c:url value="/webjars/bootstrap/4.3.1/css/bootstrap.min.css"/>" rel="stylesheet">--%>
    <%--<link href="<c:url value="/resources/css/main.css"/>" rel="stylesheet">--%>

    <%--<link href="webjars/bootstrap/4.3.1/css/bootstrap.min.css"--%>
    <%--rel="stylesheet">--%>
    <%--<meta name="viewport" content="width=device-width, initial-scale=1">--%>
    <%--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">--%>
    <%--<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>--%>
    <%--<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>--%>


    <title>BabyManager</title>
</head>
<body>

<%@include file="headerHome.jspf" %>

<div class="container">
    <header>What would you like to log?</header>

    <div class="card">
        <div class="card-body">
            <a href="/feeding/list" class="btn btn-primary">Feeding</a>
            <a href="/nap/list" class="btn btn-primary">Nap</a>
            <a href="/measurement/list" class="btn btn-primary">Measurement</a>
            <a href="/diaper/list" class="btn btn-primary">Diaper</a>
        </div>
    </div>

    <div class="card mt-4">
        <div class="card-body">
            <h4 class="card-title">Summary Today</h4>
            <header>Feedings</header>
            <table class="table table-hover">
                <tr>
                    <th>Baby</th>
                    <th>Feeding Type</th>
                    <th>Beginning/Time</th>
                    <th>End</th>
                    <th>Milk Type</th>
                    <th>Foods</th>
                    <th>Volume</th>
                    <th>Breast</th>
                    <th style="width: 15%">Actions</th>
                </tr>
                <c:forEach items="${todayFeedings}" var="feeding">
                    <tr>
                        <td>${feeding.baby.name}</td>
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
        <div class="card-body">
            <header>Naps</header>

            <table class="table table-hover">
                <tr>

                    <th>Baby</th>
                    <th>Begining</th>
                    <th>End</th>
                    <th style="width: 15%">Actions</th>
                </tr>
                <c:forEach items="${todayNaps}" var="nap">
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
        <div class="card-body">
            <header>Diapers</header>

            <table class="table table-hover">
                <tr>

                    <th>Baby Name</th>
                    <th>Time</th>
                    <th>Content</th>
                    <th style="width: 15%">Actions</th>
                </tr>
                <c:forEach items="${todayDiapers}" var="diaper">
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
