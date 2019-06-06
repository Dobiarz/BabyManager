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
<html>
<head>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <script src="https://cdn.jsdelivr.net/npm/chart.js@2.8.0"></script>

    <title>BabyManager</title>
</head>
<body>

<%@include file="headerReports.jspf" %>

<div class="container">

    <header>What report would you like to see?</header>

    <div class="card">
        <ul class="nav nav-tabs">
            <li class="nav-item">
                <a class="nav-link " href="/reports/feeding">Feeding</a>
            </li>
            <li class="nav-item">
                <a class="nav-link active" href="/reports/nap">Nap</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/reports/diaper">Diaper</a>
            </li>
        </ul>
        <%--<div class="card-body">--%>
        <%--<a href="/reports/feeding" class="btn btn-primary">Feeding</a>--%>
        <%--<a href="#" class="btn btn-primary">Nap</a>--%>
        <%--<a href="#" class="btn btn-primary">Diaper</a>--%>
        <%--<a href="#" class="btn btn-primary">Measurement</a>--%>
        <%--</div>--%>
        <form method="post">

                <div class="card-body">
                    <div class="row">
                        <div class="form-group">
                        Choose Baby:
                        </div>
                        <div class="form-group col-md-4">
                            <%--<label for="babyId">Baby:</label>--%>
                                <select name="baby" class="form-control">
                                <c:forEach items="${babies}" var="baby">
                                    <option value="${baby.name}">${baby.name}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group col-md-4">
                            <input type="submit" class="btn btn-primary" value="Refresh">
                        </div>
                    </div>
                </div>

        </form>
        <div class="card-body">
            <canvas id="myChart"></canvas>
        </div>
    </div>

    <%--<div class="card mt-4">--%>

    <%--</div>--%>

</div>

<script>
    var ctx = document.getElementById('myChart').getContext('2d');
    var chart = new Chart(ctx, {
        // The type of chart we want to create
        type: 'bar',

        // The data for our dataset
        data: {
            labels: ['6 days ago', '5 days ago ', '4 days ago', '3 days ago', '2 days ago', 'yesterday', 'today'],
            datasets: [{
                label: 'Number of Naps' + '-${babyName}',
                backgroundColor: 'rgb(255, 99, 132)',
                borderColor: 'rgb(255, 99, 132)',
                // data: [0, 10, 5, 2, 20, 30, 45]
                data:
                    [
                        <c:forEach items="${numberOfNapsLastWeekByBaby}" var="element">
                        ${element.intValue()},
                        </c:forEach>
                    ]
            }]
        },

        // Configuration options go here
        options: {}
    });
</script>

</body>
</html>
