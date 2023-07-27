<%--
  Created by IntelliJ IDEA.
  User: GUAN
  Date: 2023/7/27
  Time: 15:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <link href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
    <script src="//cdn.bootcss.com/jquery/2.1.4/jquery.min.js"></script>
    <script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">

    <form class="form-signin" action="register" method="post">
        <h2 class="form-signin-heading">请注册</h2>
        <label for="username" class="sr-only">用户名:</label>
        <input type="text" id="username" class="form-control" placeholder="用户名" name="username"  autofocus>
        <label for="password" class="sr-only">密码:</label>
        <input type="password" id="password" class="form-control" placeholder="密码" name="password" >
        <button class="btn btn-lg btn-primary btn-block" type="submit">注册</button>
    </form>

</div> <!-- /container -->

</body>
<style>
    .container{
        background-image: url("imgs/kun.jpg");
        background-size: 100% 100%;
        width: 100vw;
        height: 100vh;
    }
    body {
        margin: 0px;
        background-color: #eee;
    }

    .form-signin {
        max-width: 330px;
        padding: 15px;
        margin: 0 auto;
    }
    .form-signin .form-signin-heading,
    .form-signin .checkbox {
        margin-bottom: 10px;
    }
    .form-signin .checkbox {
        font-weight: 400;
    }
    .form-signin .form-control {
        position: relative;
        -webkit-box-sizing: border-box;
        -moz-box-sizing: border-box;
        box-sizing: border-box;
        height: auto;
        padding: 10px;
        font-size: 16px;
    }
    .form-signin .form-control:focus {
        z-index: 2;
    }
    .form-signin input[type="text"] {
        margin-bottom: -1px;
        border-bottom-right-radius: 0;
        border-bottom-left-radius: 0;
    }
    .form-signin input[type="password"] {
        margin-bottom: 10px;
        border-top-left-radius: 0;
        border-top-right-radius: 0;
    }
</style>
</html>
