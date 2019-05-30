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

    <title>BabyManager</title>
</head>
<body>

<%@include file="header.jspf" %>
<%--<div class="form-group">--%>
<%--<jsp:useBean id="now" class="java.util.Date" />--%>
<%--<fmt:formatDate var="year" value="${now}" pattern="yyyy-MM-dd HH:mm:ss" />--%>
<%--${year}--%>
<%--</div>--%>

<%--<div class="form-group">--%>
<%--<form:form method="post" modelAttribute="leftBreast">--%>
<%--<jsp:useBean id="now" class="java.util.Date"/>--%>
<%--<fmt:formatDate var="year" value="${now}" pattern="yyyy-MM-dd HH:mm:ss"/>--%>
<%--<form:hidden path="beginning" value="${year}"/>--%>
<%--<form:errors path="beginning" element="div" cssClass="error"/>--%>
<%--<input type="submit" value="send">--%>
<%--</form:form>--%>
<%--</div>--%>

<%--<button onclick="myFunction()">Start</button>--%>
<%--<p id="demo"></p>--%>

<%--<div class="form-group">--%>

<%--<form:form method="post" modelAttribute="leftBreast">--%>

<%--<label for="beginningId">Beginning:</label>--%>
<%--<form:input path="beginning" class="form-control" id="beginningId" value="cos"/>--%>
<%--<form:errors path="beginning" element="div" cssClass="error"/>--%>
<%--<input type="submit" class="btn btn-primary" value="Start">--%>

<%--</form:form>--%>
<%--</div>--%>

<form:form method="post" modelAttribute="leftBreast">

    <div class="container">

        <header>Add LeftBreast</header>

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
                        <form:errors path="baby.id" element="div" cssClass="error"/>
                    </div>

                    <div class="form-group col-md-4">


                        <label for="beginningId">Beginning:</label>
                        <form:input path="beginning" class="form-control" id="beginningId" value=""/>
                        <form:errors path="beginning" element="div" cssClass="error"/>
                        <button type="button" onclick="setBeginningTime()" class="btn btn-primary">Start</button>

                    </div>

                        <%--<div class="form-group col-md-4">--%>
                        <%--<label for="beginningId">Beginning:</label>--%>

                        <%--<form:input type="datetime-local" path="beginning" class="form-control" id="beginningId"--%>
                        <%--placeholder="yyyy-MM-dd HH:mm:ss"/>--%>
                        <%--<form:errors path="beginning" element="div" cssClass="error"/>--%>
                        <%--</div>--%>

                    <div class="form-group col-md-4">

                        <label for="endId">End:</label>
                        <form:input path="end" class="form-control" id="endId" value=""/>
                        <form:errors path="end" element="div" cssClass="error"/>
                        <button type="button" onclick="setEndTime()" class="btn btn-primary">End</button>

                        <%--<label for="endId">End:</label>--%>
                        <%--<form:input path="end" class="form-control" id="endId" placeholder="yyyy-MM-dd HH:mm:ss"/>--%>
                        <%--<form:errors path="end" element="div" cssClass="error"/>--%>
                    </div>


                        <%--<div class="form-group col-md-4">--%>
                        <%--<label for="ratingId">Rating:</label>--%>
                        <%--<form:input type="number" path="rating" min="1" max="10" class="form-control" id="ratingId"/>--%>
                        <%--<form:errors path="rating" element="div" cssClass="error"/>--%>
                        <%--</div>--%>

                        <%--<div class="form-group col-md-4">--%>
                        <%--<label for="pagesId">Pages:</label>--%>
                        <%--<form:input type="number" path="pages" class="form-control" id="pagesId"/>--%>
                        <%--<form:errors path="pages" element="div" cssClass="error"/>--%>
                        <%--</div>--%>

                </div>

                    <%--<div class="form-group">--%>
                    <%--<label for="publisherId">Publisher:</label>--%>
                    <%--<form:select path="publisher.id" items="${publishers}" itemLabel="name" itemValue="id"--%>
                    <%--class="form-control" id="publisherId"/>--%>
                    <%--<form:errors path="publisher.id" element="div" cssClass="error"/>--%>
                    <%--</div>--%>

                    <%--<div class="form-group">--%>
                    <%--<label for="authorsId">Authors:</label>--%>
                    <%--<form:select path="authors" items="${authors}" itemLabel="fullName" itemValue="id"--%>
                    <%--class="form-control" id="authorsId"/>--%>
                    <%--<form:errors path="authors" element="div" cssClass="error"/>--%>
                    <%--</div>--%>

                    <%--<div class="row">--%>
                    <%--<div class="form-group col-md-12">--%>
                    <%--<label for="descriptionId">Description:</label>--%>
                    <%--<form:textarea path="description" cols="60" rows="3" class="form-control" id="descriptionId"/>--%>
                    <%--<form:errors path="description" element="div" cssClass="error"/>--%>
                    <%--</div>--%>
                    <%--</div>--%>

                <input type="submit" class="btn btn-primary" value="Stop/Save">

            </div>

        </div>

    </div>

</form:form>

<script>
    function getCurrentTime() {
        var currentTime = new Date();
        currentTime.setHours(currentTime.getHours() + 2);
        // ISO Format
        // 2019-05-25T12:02:10.81
        // document.getElementById("beginningId").value = date.toISOString();
        //     date.getFullYear() + "-"
        //     + date.getMonth() + "-"
        //     + date.getDate() + "T"
        //     + date.getHours() + ":"
        //     + date.getMinutes() + ":"
        //     + date.getSeconds();
        return currentTime;
    }

    function setBeginningTime(){
        document.getElementById("beginningId").value = getCurrentTime().toISOString()
    }
    function setEndTime(){
        document.getElementById("endId").value = getCurrentTime().toISOString()
    }
</script>


</body>
</html>
