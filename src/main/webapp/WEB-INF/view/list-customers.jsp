<%--
  Created by IntelliJ IDEA.
  User: dlwan
  Date: 5/20/2020
  Time: 11:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
            <%-- button for add cutomer--%>
                <input type="button" value="Add Customer" onclick="window.location.href='showFormForAdd'; return false;"
                class="add-button"/>
                <br><br>
                <!--  add a search box -->
                <form:form action="search" method="GET">
                    Search customer: <input type="text" name="theSearchName" />

                    <input type="submit" value="Search" class="add-button" />
                </form:form>
            <table>
                <tr>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Email</th>
                    <th>Value</th>
                    <th>Action</th>
                </tr>
                <c:forEach var="curCustomer" items="${customers}">

                    <c:url var="updateLink" value="/customer/showFormForUpdate">
                        <c:param name="customerId" value="${curCustomer.id}"/>
                    </c:url>

                    <c:url var="deleteLink" value="/customer/delete">
                        <c:param name="customerId" value="${curCustomer.id}"/>
                    </c:url>

                    <tr>
                        <td>${curCustomer.firstName}</td>
                        <td>${curCustomer.lastName}</td>
                        <td>${curCustomer.email}</td>
                        <td>${curCustomer.value}</td>
                        <td>
                            <a href="${updateLink}">Update</a>
                            |
                            <a href="${deleteLink}" onclick="if(!(confirm('Are you sure you wanna delete this user? ${curCustomer.lastName} ${curCustomer.firstName}')))
                                return false"
                            >Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
</body>
</html>
