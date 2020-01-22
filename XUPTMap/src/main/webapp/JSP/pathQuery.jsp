<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/29 0029
  Time: 下午 15:07
  To change this template use File | Settings | File Templates.
--%>
<%@page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <title>
        校园导航
    </title>
    <style>
        td {
            font-size: 120%;
            height: 10000%;
        }
        tr{
            height: 200%;
        }
    </style>
</head>
<body>
<div style="border: solid 1px;margin: 7% 3%;width: 80%">
    <h1 style="margin-top: 25%; margin-left: 40%">查询路径</h1>
    <div style="margin-left: 33%;margin-bottom: 38%; margin-top: 4%">
        <form action="/xupt/query">
            <table height="20%">
                <tr>
                    <td>请选择起点</td>
                    <td>
                        <select name="start">
                            <c:forEach items="${list}" var="place">
                                <option value="${place.name}">${place.name}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>请选择终点<br></td>
                    <td> <select name="end">
                        <c:forEach items="${list}" var="place">
                            <option value="${place.name}">${place.name}</option>
                        </c:forEach>
                    </select></td>
                </tr>
                <tr>
                    <td colspan="2" align="center" height="200%"><input type="submit" value="查询" style="font-size: 80%; width: 60%;"></td>
                </tr>
            </table>
        </form>
    </div>
</div>
</body>
</html>