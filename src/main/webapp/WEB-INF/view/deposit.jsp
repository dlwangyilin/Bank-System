<%--
  Created by IntelliJ IDEA.
  User: dlwan
  Date: 5/22/2020
  Time: 9:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Deposit</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link href="https://fonts.googleapis.com/css?family=Lato:400,700&display=swap" rel="stylesheet">
    <%--<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">--%>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
    <script src="https://kit.fontawesome.com/31051bc840.js" crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
    <style>
        .error {
            color: red;
        }
    </style>
</head>
<body>

    <div id="wrapper">
        <div id="header">
            <h2>Great day to make a deposit!</h2>
        </div>
    </div>

    <br><br>

    <div id="container">

    <form:form action="${pageContext.request.contextPath}/user/processDeposit" modelAttribute="delta">
        <table>
            <tbody>
                <tr>
                    <td><label>Deposit: </label></td>
                    <form:hidden path="userId" />
                    <td>
                        <form:input path="deltaVal" placeholder="Deposit" />
                        <form:errors path="deltaVal" cssClass="error"/>
                    </td>

                </tr>

                <tr>
                    <td><label></label></td>
                    <td><input type="submit" value="Save" class="save"></td>
                </tr>

            </tbody>
        </table>

    </form:form>

    </div>



    <a href="${pageContext.request.contextPath}/user/">Back to home page</a>
</body>
</html>
