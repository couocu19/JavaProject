<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/1/4 0004
  Time: 下午 15:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<%
//    System.out.println(request.getSession().getAttribute("shortPath"));
//    System.out.println(request.getSession().getAttribute("lowPath"));
    List<String> list = (List) request.getSession().getAttribute("main");

%>
<html>
<head>
    <title>Title</title>
</head>
<body>
        <h1>最佳路径</h1> <br>${shortPath}
        <br>
        <h1>长度</h1>${minSum}
        <br>
        <h1>最短简单路径</h1> <br>${lowPath}
        <br>
        <h1>所有简单路径</h1>
        <c:forEach items="<%=list%>" var="i">
            <c:out value="${i}"></c:out> <br>
        </c:forEach>

</body>
</html>
