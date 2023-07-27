<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 79840
  Date: 2023/7/27
  Time: 19:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" isELIgnored="false" %>
<html>
<head>
    <link href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
    <script src="//cdn.bootcss.com/jquery/2.1.4/jquery.min.js"></script>
    <script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <form action="updateCategory" method="get">
        <input type="text"  placeholder="分类名" name="name">
        <c:if test="${!(empty EditCategoryError)}">
            <p style="color: red">${EditCategoryError}</p>
        </c:if>
        <button type="submit">完成</button>
    </form>
</body>
</html>
