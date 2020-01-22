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
    <h1 style="margin-top: 25%; margin-left: 40%">添加地点</h1>
    <div style="margin-left: 33%;margin-bottom: 8%; margin-top: 4%">
        <form action="/xupt/insert">
            <table height="30%">
                <tr>
                    <td>地点名称:&nbsp;&nbsp; <br></td>
                    <td><input type="text" name="name"></td>
                </tr>
                <tr>
                    <td>简介: <br></td>
                    <td><textarea name="msg" cols="20%" rows="10%"></textarea></td>
                </tr>
                <tr>
                    <td colspan="2" align="center"><input type="submit" value="提交" style="font-size: 80%; width: 60%;"></td>
                </tr>
            </table>
        </form>
    </div>
</div>
</body>
</html>