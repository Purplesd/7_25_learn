<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 79840
  Date: 2023/7/28
  Time: 14:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table style="">
    <tr>
        <td>id</td>
        <td>name</td>
        <td>价格</td>
        <td>数量</td>
        <td>分类</td>

    </tr>
    <c:forEach items="${orderdetail}" var="ps" varStatus="st">
        <tr>
            <th>${ps.id}</th>
            <th>${ps.name}</th>
            <th>${ps.price}</th>
            <th>${ps.stock}</th>
            <th>${ps.category}</th>
        </tr>
    </c:forEach>
</table>

</body>
<style>
    table {
        border-collapse: collapse; /* 合并边框 */
        border: 1px solid black;   /* 设置边框 */
    }
    th, td {
        border: 1px solid black; /* 设置单元格边框 */
        padding: 8px;            /* 设定单元格内边距 */
        text-align: center;        /* 文字左对齐 */
    }
</style>
</html>