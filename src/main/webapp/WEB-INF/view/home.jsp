<%--
  Created by IntelliJ IDEA.
  User: dlwan
  Date: 5/22/2020
  Time: 3:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>Home Page</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/home.css">
    <link href="https://fonts.googleapis.com/css?family=Lato:400,700&display=swap" rel="stylesheet">
    <%--<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">--%>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
    <script src="https://kit.fontawesome.com/31051bc840.js" crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
</head>
<body>

<c:url var="deposit" value="/user/deposit">
    <c:param name="userId" value="${user.id}"/>
</c:url>

<c:url var="withdraw" value="/user/withdraw">
    <c:param name="userId" value="${user.id}"/>
</c:url>

    <nav class="navbar navbar-default">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="${pageContext.request.contextPath}/user/">ET Bank</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="${pageContext.request.contextPath}/user/">Home</a></li>
                    <li><a href="${deposit}">Deposit</a></li>
                    <li><a href="${withdraw}">Withdraw</a></li>
                </ul>

            </div><!-- /.navbar-collapse -->
        </div><!-- /.container-fluid -->
    </nav>


    <%-- A link only for admin--%>
    <security:authorize access="hasRole('ADMIN')">
        <p>
            <a href="${pageContext.request.contextPath}/admin/list" class="btn btn-info" id="listAll"> List all users </a>
        </p>
    </security:authorize>

    <c:if test="${success != null}">
        <div class=success>
            ${success}
        </div>
    </c:if>

    <c:if test="${error != null}">
        <div class=error>
                ${error}
        </div>
    </c:if>

    <table class="table table-striped">
        <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Email</th>
            <th>Value</th>
            <th>Action</th>
        </tr>

        <tr>
            <td>${user.firstName}</td>
            <td>${user.lastName}</td>
            <td>${user.email}</td>
            <td>${user.value}</td>
            <td>
                <a href="${deposit}">Deposit</a>
                |
                <a href="${withdraw}">Withdraw</a>
            </td>


        </tr>
    </table>
    <%-- log out support--%>
    <form:form action="${pageContext.request.contextPath}/logout" method="post">
        <input type="submit" value="Logout" class="btn btn-danger">
    </form:form>

    <script src="https://code.jquery.com/jquery-2.2.4.js" integrity="sha256-iT6Q9iMJYuQiMWNd9lDyBUStIq/8PuOW33aOqmvFpqI=" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</body>
</html>
