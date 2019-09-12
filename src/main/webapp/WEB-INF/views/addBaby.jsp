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

<%@include file="headerHome.jspf" %>

<form:form method="post" modelAttribute="baby">

    <div class="container">
        <header>Add Baby</header>
        <div class="card">
            <div class="card-body">
                <a href="/baby/list" class="btn btn-primary">Back</a>
            </div>
        </div>
        <div class="card mt-4">
            <div class="card-body">
                <div class="row">
                    <div class="form-group col-md-4">
                        <label for="nameId">Name:</label>
                        <form:input path="name" class="form-control" id="nameId"/>
                        <form:errors path="name" element="div" cssClass="text-danger"/>
                    </div>
                    <div class="form-group col-md-4">
                        <label for="beginningId">Birthdate:</label>
                        <form:input path="birthDate" class="form-control" id="beginningId" placeholder="yyyy-MM-dd"/>
                        <form:errors path="birthDate" element="div" cssClass="text-danger"/>
                    </div>
                    <div class="form-group col-md-4">
                        <label for="genderId">Gender:</label>
                        <form:select items="${genders}" path="gender" class="form-control" id="genderId"/>
                        <form:errors path="gender" element="div" cssClass="text-danger"/>
                    </div>
                </div>
                <input type="submit" class="btn btn-primary" value="Save">
            </div>
        </div>
    </div>

</form:form>

</body>
</html>
