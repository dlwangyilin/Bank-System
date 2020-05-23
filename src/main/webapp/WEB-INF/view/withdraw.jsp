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
    <title>Withdraw</title>
    <style>
        .error {
            color: red;
        }
    </style>
</head>
<body>
    <<div id="wrapper">
        <div id="header">
            <h2>Great day to make a withdrawal!</h2>
        </div>
    </div>

    <br><br>

    <div>
    <form:form action="${pageContext.request.contextPath}/user/processWithdraw" modelAttribute="delta">
        <table>
            <tbody>
            <tr>
                <td><label>Withdraw: </label></td>
                <form:hidden path="userId" />
                <td>
                    <form:input path="deltaVal" placeholder="Withdraw" />
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
