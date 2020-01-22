<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/29 0029
  Time: 下午 15:07
  To change this template use File | Settings | File Templates.
--%>
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
<div style="border: solid 1px;margin: 12% 3%;width: 80%;height: 70%">
    <h1 style="margin-top: 10%; margin-left: 40%">地点目录</h1>
    <div style="margin-left: 5%; margin-right: 5%">
        <table border="1px" style="font-size: 120%">
            <c:forEach items="${pageInfo.list}" var="place">
                <tr>
                    <td width="20%" height="20%"><a href="/xupt/showPath?name=${place.name}">${place.name}</a></td>
                    <td>${place.msg}</td>
                </tr>
            </c:forEach>
        </table>
        <a href="/xupt/showPlace?pageNum=${pageInfo.pageNum - 1}" <c:if test="${pageInfo.pageNum <=1 }"> style="display: none" </c:if>>上一页</a>
        <a href="/xupt/showPlace?pageNum=${pageInfo.pageNum + 1}" <c:if test="${pageInfo.pageNum >= pageInfo.pageSum}"> style="display: none" </c:if>>下一页</a>

    </div>
</div>
</body>
</html>