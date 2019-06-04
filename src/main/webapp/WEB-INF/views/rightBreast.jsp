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
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <title>BabyManager</title>

</head>
<body>

<%@include file="header.jspf" %>

<form:form method="post" modelAttribute="rightBreast">

    <div class="container">
        <header>Add RightBreast</header>
        <div class="card">
            <div class="card-body">
                <a href="/feeding/list" class="btn btn-primary">Back</a>
            </div>
        </div>
        <div class="card mt-4">
            <div class="card-body">
                <div class="row">
                    <div class="form-group col-md-4">
                        <label for="babyId">Baby:</label>
                        <form:select path="baby.id" items="${babies}" itemLabel="name" itemValue="id"
                                     class="form-control" id="babyId"/>
                        <form:errors path="baby" element="div" cssClass="text-danger"/>
                    </div>
                    <div class="form-group col-md-4">
                        <label for="beginningId">Beginning:</label>
                        <form:input path="beginning" class="form-control" id="beginningId" value=""/>
                        <form:errors path="beginning" element="div" cssClass="text-danger"/>
                        <button type="button" onclick="setBeginningTime()" class="btn btn-primary">Start</button>
                    </div>
                    <div class="form-group col-md-4">
                        <label for="endId">End:</label>
                        <form:input path="end" class="form-control" id="endId" value=""/>
                        <form:errors path="end" element="div" cssClass="text-danger"/>
                        <button type="button" onclick="setEndTime()" class="btn btn-primary">End</button>
                    </div>
                </div>
                <input type="submit" class="btn btn-primary" value="Save">
            </div>
        </div>
    </div>

</form:form>

<script>

    function getCurrentTime() {

        var currentTime = new Date();

        if (currentTime.getMonth() < 10) {
            var month = currentTime.getMonth() + 1;
            month = "0" + month;
        } else {
            month = currentTime.getMonth() + 1
        }

        if (currentTime.getDate() < 10) {
            var dayOfMonth = "0" + currentTime.getDate();
        } else {
            dayOfMonth = currentTime.getDate();
        }

        if (currentTime.getHours() < 10) {
            var hour = "0" + currentTime.getHours();
        } else {
            hour = currentTime.getHours();
        }

        if (currentTime.getMinutes() < 10) {
            var minute = "0" + currentTime.getMinutes();
        } else {
            minute = currentTime.getMinutes();
        }

        if (currentTime.getSeconds() < 10) {
            var second = "0" + currentTime.getSeconds();
        } else {
            second = currentTime.getSeconds();
        }

        var currentTimeString =
            currentTime.getFullYear() + "-"
            + month + "-"
            + dayOfMonth + " "
            + hour + ":"
            + minute + ":"
            + second;

        return currentTimeString;
    }

    function setBeginningTime() {
        document.getElementById("beginningId").value = getCurrentTime()
    }

    function setEndTime() {
        document.getElementById("endId").value = getCurrentTime()
    }

</script>

</body>
</html>
