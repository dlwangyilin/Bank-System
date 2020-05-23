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
                        <form:input path="deltaVal" placeholder="Deposit" />
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
