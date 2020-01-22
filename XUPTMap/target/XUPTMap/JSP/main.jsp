<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>
        校园导航
    </title>
    <style>
        li{
            margin-bottom: 8%;
            font-size: 120%;
        }
    </style>
</head>
<body>
<div style="border: solid 1px;margin: 12% 5%;width: 80%">
    <h1 style="margin-top: 10%; margin-left: 40%">校园导航</h1>
    <ul style="margin-top: 10%; margin-left: 38%">
        <li><a href="/xupt/showPlace">地点信息</a></li>
        <li><a href="/xupt/selList?act=query">问路查询</a></li>
        <li><a href="addPlace.jsp">新增地点</a></li>
        <li><a href="/xupt/selList?act=delete1">删除地点</a></li>
        <li><a href="addPath.jsp">新增路径</a></li>
        <li><a href="/xupt/selList?act=delete2">删除路径</a></li>
        <br> <br>
        <br>
        <br>
    </ul>
</div>
</body>
</html>