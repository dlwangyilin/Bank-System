<%--
  Created by IntelliJ IDEA.
  User: dlwan
  Date: 5/20/2020
  Time: 11:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>List Customers</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2>DaBaoBao Bank System</h2>
    </div>
    <div id="container">
        <div id="content">
            <table>
                <tr>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Email</th>
                    <th>Value</th>
                </tr>
                <c:forEach var="curCustomer" items="${customers}">
                    <tr>
                        <td>${curCustomer.firstName}</td>
                        <td>${curCustomer.lastName}</td>
                        <td>${curCustomer.email}</td>
                        <td>${curCustomer.value}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
</body>
</html>
