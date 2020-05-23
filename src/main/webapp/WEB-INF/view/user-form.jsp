<%--
  Created by IntelliJ IDEA.
  User: dlwan
  Date: 5/21/2020
  Time: 12:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add a customer</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
</head>
<body>
    <div id="wrapper">
        <div id="header">
            <h2>ET Bank System</h2>
        </div>
    </div>

    <div id="container">
        <h3>Save a user</h3>
        <form:form action="saveUser" modelAttribute="user" method="post">
            <form:hidden path="id" />
            <form:hidden path="password" />
            <table>
                <tbody>
                    <tr>
                        <td><label>Username:</label></td>
                        <td> <form:input path="userName"  /> </td>
                    </tr>
                    <tr>
                        <td><label>First Name:</label></td>
                        <td> <form:input path="firstName"  /> </td>
                    </tr>

                    <tr>
                        <td><label>Last Name:</label></td>
                        <td> <form:input path="lastName" /> </td>
                    </tr>

                    <tr>
                        <td><label>Email:</label></td>
                        <td> <form:input path="email" /> </td>
                    </tr>

                    <tr>
                        <td><label>Balance:</label></td>
                        <td> <form:input path="value" /> </td>
                    </tr>

                    <tr>
                        <td><label></label></td>
                        <td><input type="submit" value="Save" class="save"></td>
                    </tr>
                </tbody>
            </table>
        </form:form>

        <div style="clear: both">
        </div>

        <p>
            <a href="${pageContext.request.contextPath}/admin/list">Back to Users List</a>
        </p>
    </div>

</body>
</html>
