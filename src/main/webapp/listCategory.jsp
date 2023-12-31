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
        <td>name</td>
        <td>编辑</td>
        <td>删除</td>
    </tr>
    <c:forEach items="${categories}" var="cs" varStatus="st">
        <tr>
            <th>${cs.id}</th>
            <th><a href="listProduct?categoryName=${cs.name}">${cs.name}</a></th>
            <th><a href="editCategory?id=${cs.id}">编辑</a></th>
            <th><a href="deleteCategory?id=${cs.id}">删除</a></th>
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
