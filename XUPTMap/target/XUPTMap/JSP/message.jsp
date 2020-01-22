<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div style="border: solid 1px;margin: 7% 3%;width: 80%; height: 80%">
    <h1 style="margin-top: 25%; margin-left: 40%">${msg}<br><a href="/JSP/main.jsp">跳转</a></h1>
</div>
</body>
</html>
<%
    response.setHeader("Refresh","3;URL=/JSP/main.jsp");
%>