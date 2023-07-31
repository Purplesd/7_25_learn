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
<form action="searchProduct" method="post">
    <input type="text" name="pname">
    <input type="submit" value="搜索">
</form>
<table style="">
    <tr>
        <td>id</td>
        <td>name</td>
        <td>价格</td>
        <td>数量</td>
        <td>分类</td>
        <td>编辑</td>
        <td>删除</td>
        <td>购买</td>
    </tr>
    <c:forEach items="${products}" var="ps" varStatus="st">
        <tr>
            <th>${ps.id}</th>
            <th>${ps.name}</th>
            <th>${ps.price}</th>
            <th>${ps.stock}</th>
            <th>${ps.category}</th>
            <th><a href="editProduct?id=${ps.id}">编辑</a></th>
            <th><a href="deleteProduct?id=${ps.id}">删除</a></th>
            <th><a href="purchaseProduct?id=${ps.id}">购买</a></th>
        </tr>
    </c:forEach>
</table>
<c:if test="${!(empty ProductError)}">
    <p style="color: red">${ProductError}</p>
</c:if>
<form action="addProduct" method="post">
    商品名称:<input type="text" name="name"><br/>
    商品价格:<input type="text" name="price"><br/>
    商品数量:<input type="text" name="stock"><br/>
    <input type="hidden" value="${categoryName}" name="category"><br/>
    <input type="submit" value="新增">
</form>
<form action="shopp.jsp" method="post">
    <input type="submit" value="购物车">
</form>
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
