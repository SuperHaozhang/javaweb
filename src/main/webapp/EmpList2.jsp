<%--
  Created by IntelliJ IDEA.
  User: 10216
  Date: 2019/6/17
  Time: 8:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <style>
        table {
            margin: 50px auto 0 auto;
            border-collapse: collapse;
            text-align: center;
            vertical-align: center;
        }
        table, th, td {
            border: 1px solid black;
        }
        th, td {
            width: 100px;
            height: 30px;
        }
        #header{
            height: 20px;
            text-align: center;
        }

        #user,#user1{
            margin-right: 20px;
        }
        #avatar {
            width: 45px;
            height: 45px;
            margin-right: 20px;
        }
    </style>
</head>
<body>

<div id="header">
    <img id="avatar"><span id="user"></span><a href="OutLogin">点击退出</a>
    <span id="user1"></span><a href="/javaweb/inseret.jsp">点击添加</a>
</div>

<div>
    <table border="1px">
        <tr>
            <th>empno</th>
            <th>ename</th>
            <th>job</th>
            <th>mgr</th>
            <th>hiredate</th>
            <th>sal</th>
            <th>com</th>
            <th>deptno</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${emplist}" var="s">
            <tr>
                <td>${s.empno}</td>
                <td>${s.ename}</td>
                <td>${s.job}</td>
                <td>${s.mgr}</td>
                <td>${s.hiredate}</td>
                <td>${s.sal}</td>
                <td>${s.com}</td>
                <td>${s.deptno}</td>
                <td><a href="/javaweb/DeleteEmpServlet?empno=${s.empno}">删除</a>|<a href="/javaweb/servlet/EmpDemo02?empno=${s.empno}">修改</a></td>
            </tr>
        </c:forEach>
    </table>
</div>


<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script>

    let requestURL='servlet/EmpServlet';

    $(function () {
        $.ajax({
            url: "servlet/UserServlet",
            dataType: "json",
            method: "GET",
            success: function (response) {
                let username = response.username;
                $("#user").text(username);
                let avatar = response.avatar;
                $("#avatar").attr("src", "upload/avatar/" + avatar)
            }
        });
    });

</script>


</body>
</html>
