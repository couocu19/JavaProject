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
    <h1 style="margin-top: 25%; margin-left: 40%">新增路径</h1>
    <div style="margin-left: 33%;margin-bottom: 38%; margin-top: 4%">
        <form action="/xupt/insert">
            <table height="20%">
                <tr>
                    <td>路径起点:&nbsp;&nbsp; <br></td>
                    <td><input type="text" name="start"></td>
                </tr>
                <tr>
                    <td>路径终点: &nbsp;&nbsp;<br></td>
                    <td><input type="text" name="end"></td>
                </tr>
                <tr>
                    <td>路径长度: &nbsp;&nbsp;<br></td>
                    <td><input type="text" name="length"></td>
                </tr>
                <tr>
                    <td colspan="2" align="center" height="200%"><input type="submit" value="提交" style="font-size: 80%; width: 60%;"></td>
                </tr>
            </table>
        </form>
    </div>
</div>
</body>
</html>