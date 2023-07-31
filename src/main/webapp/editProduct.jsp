<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 79840
  Date: 2023/7/28
  Time: 20:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="updateProduct" method="post">
    <input type="hidden" value="${product.id}" name="id">
    <input type="text"  value="${product.name}" name="name"><br/>
    <input type="text"  value="${product.price}" name="price"><br/>
    <input type="text"  value="${product.stock}" name="stock"><br/>
    <input type="text"  value="${product.category}" name="category"><br/>
    <c:if test="${!(empty EditProductError)}">
        <p style="color: red">${EditProductError}</p>
    </c:if>
    <button type="submit">完成</button>
</form>
</body>
</html>
