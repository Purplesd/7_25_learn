<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 79840
  Date: 2023/7/27
  Time: 16:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <meta charset="UTF-8">
</head>
<body>
<table>
    <tr>
        <td>id</td>
        <td>pid</td>
        <td>地址</td>
        <td>详情</td>
    </tr>
    <c:forEach items="${orders}" var="cs" varStatus="st">
        <tr>
            <th>${cs.id}</th>
            <th>${cs.pid}</th>
            <th>${cs.address}</th>
            <th><a href="orderDetail?pid=${cs.pid}">详情</a></th>
        </tr>
    </c:forEach>
</table>
<c:if test="${!(empty CategoryError)}">
    <p style="color: red">${CategoryError}</p>

</c:if>
<form action="addCategory" method="post">
    <input type="text" name="name"><br/>
    <input type="submit" value="新增">
</form>
</body>
<style>
    table {
        border-collapse: collapse;
        border: 1px solid black;
    }
    th, td {
        border: 1px solid black;
        padding: 8px;
        text-align: center;
    }
</style>
</html>
