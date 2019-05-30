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

<%@include file="header.jspf" %>

<div class="container">

    <header>What would you like to log?</header>

    <div class="card">
        <div class="card-body">
            <a href="/feeding/list" class="btn btn-primary">Feeding</a>
            <a href="/nap/list" class="btn btn-primary">Nap</a>
            <a href="/books/add" class="btn btn-primary">Measurement</a>
            <a href="/diaper/list" class="btn btn-primary">Diaper</a>
        </div>
    </div>

</div>



</body>
</html>
