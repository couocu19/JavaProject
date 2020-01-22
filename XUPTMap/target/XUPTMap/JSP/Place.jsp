<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/1/3 0003
  Time: 下午 16:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div style="border: solid 1px;margin: 12% 3%;width: 80%;height: 70%">
    <h1 style="margin-top: 10%; margin-left: 40%">${name}</h1>
    <div style="margin-left: 15%; margin-right: 5%">
        <table border="1px" style="font-size: 120%">
            <tr>
                <td width="20%" height="20%">起点</td>
                <td>终点</td>
                <td>长度</td>
            </tr>
            <c:forEach items="${path}" var="apath">
                <tr>
                    <td>${apath.start}</td>
                    <td>${apath.end}</td>
                    <td>${apath.length}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
