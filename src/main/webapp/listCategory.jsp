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
            <th>${cs.name}</th>
            <th><a href="editCategory?id=${cs.id}">编辑</a></th>
            <th><a href="deleteCategory?id=${cs.id}">删除</a></th>
        </tr>
    </c:forEach>
</table>
<form action="addCategory" method="post">
    <input type="text" name="name"><br/>
    <input type="submit" value="新增">
</form>
</body>
</html>
