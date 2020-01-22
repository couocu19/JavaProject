<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/29 0029
  Time: 下午 15:56
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
<div style="border: solid 1px;margin: 7% 3%;width: 80%">
    <h1 style="margin-top: 25%; margin-left: 40%">删除路径</h1>
    <div style="margin-left: 33%;margin-bottom: 38%; margin-top: 4%">
        <form action="/xupt/delete">
            <table style="font-size: 120%">
                <tr>
                    <td>请选择起点</td>
                    <td>
                        <select name="deletestart">
                            <c:forEach items="${list}" var="path">
                                <option value="${path.name}">${path.name}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>请选择终点<br></td>
                    <td> <select name="deleteend">
                        <c:forEach items="${list}" var="path">
                            <option value="${path.name}">${path.name}</option>
                        </c:forEach>
                    </select></td>
                </tr>
                <tr>
                    <td colspan="2" align="center" height="200%"><input type="submit" value="提交" style="font-size: 80%; width: 60%;"></td>
                </tr>
        </form>
    </div>
</div>
</body>
</html>
