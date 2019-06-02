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

<form:form method="post" modelAttribute="pump">

    <div class="container">
        <header>Add Pump</header>
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
                        <form:input path="beginning" class="form-control" id="beginningId" placeholder="yyyy-MM-dd HH:mm:ss"/>
                        <form:errors path="beginning" element="div" cssClass="error"/>

                    </div>
                    <div class="form-group col-md-4">
                        <label for="volumeId">Volume(ml):</label>
                        <form:input type="number" min="0" step="5" path="volume" class="form-control" id="volumeId" />
                        <form:errors path="volume" element="div" cssClass="error"/>
                    </div>
                    <div class="form-group col-md-4">
                        <label for="breastId" >Breast:</label>
                        <form:select items="${breasts}" path="breast" class="form-control" id="breastId"/>
                        <form:errors path="breast" element="div" cssClass="error"/>
                    </div>
                </div>
                <input type="submit" class="btn btn-primary" value="Save">
            </div>
        </div>
    </div>

</form:form>

</body>
</html>
