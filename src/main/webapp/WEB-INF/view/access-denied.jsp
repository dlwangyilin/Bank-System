<%--
  Created by IntelliJ IDEA.
  User: dlwan
  Date: 5/21/2020
  Time: 10:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Access Denied</title>
    <style>
        h2 {
            color: red;
        }
    </style>
</head>
<body>
    <h2> Access Denied!</h2>
    <a href="${pageContext.request.contextPath}/customer">Back to home page</a>
</body>
</html>
