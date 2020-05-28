<%--
  Created by IntelliJ IDEA.
  User: dlwan
  Date: 5/22/2020
  Time: 9:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Withdraw</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link href="https://fonts.googleapis.com/css?family=Lato:400,700&display=swap" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/deposit.css">
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

    <div id="wrapper">
        <div id="header">
            <h2>Great day to make a withdrawal!</h2>
        </div>
    </div>

    <br><br>

    <div id="container">
    <form:form action="${pageContext.request.contextPath}/user/processWithdraw" cssClass="form-inline" modelAttribute="delta">
        <table class="table table-striped">
            <tbody>
            <tr>
                <td><label>Withdraw: </label></td>
                <form:hidden path="userId" />
                <td>
                    <form:input path="deltaVal" placeholder="Withdraw" />
                    <form:errors path="deltaVal" cssClass="error"/>
                </td>
                <td><input type="submit" value="Save" class="btn btn-primary"></td>

            </tr>

            </tbody>
        </table>

    </form:form>

        <a href="${pageContext.request.contextPath}/user/">Back to home page</a>

    </div>


</body>
</html>
