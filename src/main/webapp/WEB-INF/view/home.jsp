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
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
    <style>
        .success {
            color: #09c332;
        }
        .error {
            color: red;
        }
    </style>
</head>
<body>
    <h3>This is a home page for all users.</h3>


    <%-- A link only for admin--%>
    <security:authorize access="hasRole('ADMIN')">
        <p>
            <a href="${pageContext.request.contextPath}/admin/list"> List all users </a>
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

    <table>
        <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Email</th>
            <th>Value</th>
            <th>Action</th>
        </tr>

        <c:url var="deposit" value="/user/deposit">
            <c:param name="userId" value="${user.id}"/>
        </c:url>

        <c:url var="withdraw" value="/user/withdraw">
            <c:param name="userId" value="${user.id}"/>
        </c:url>

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
        <input type="submit" value="Logout">
    </form:form>

</body>
</html>
