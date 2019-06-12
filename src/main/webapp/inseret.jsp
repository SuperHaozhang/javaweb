<%--
  Created by IntelliJ IDEA.
  User: 10216
  Date: 2019/6/12
  Time: 11:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
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
        .cell {
            display: inline-block;
        }
        .row {
            margin: 0 auto;
            width: 800px;
        }
        .row + .row {
            margin-top: 30px;
        }
        .row:nth-of-type(1) {
            margin-top: 100px;
        }
        .row:nth-of-type(5) {
            margin-bottom: 100px;
        }
        label {
            display: inline-block;
            width: 50px;
            font-weight: bold;
            margin-right: 10px;
        }
        .cell {
            margin-right: 50px;
        }
        input {
            height: 25px;
            width: 250px;
        }
        button {
            width: 150px;
            height: 40px;
            background-color: rgba(22, 155, 213, 1);
            border-radius: 10px;
            border: 0;
            margin-left: 60px;
        }
    </style>
</head>
<body>

<form action="servlet/InseretServlet" method="get">
    <div id="top">
        <div class="row">
            <div class="cell">
                <label for="empno">empno</label><input type="text" name="user" id="empno">
            </div>
            <div class="cell">
                <label for="ename">ename</label><input type="text" name="user" id="ename">
            </div>
        </div>
        <div class="row">
            <div class="cell">
                <label for="mgr">mgr</label><input type="text" name="user" id="mgr">
            </div>
            <div class="cell">
                <label for="job">job</label><input type="text" name="user" id="job">
            </div>
        </div>
        <div class="row">
            <div class="cell">
                <label for="hiredate">hire</label><input type="text" name="user" id="hiredate">
            </div>
            <div class="cell">
                <label for="sal">sal</label><input type="text" name="user" id="sal">
            </div>
        </div>
        <div class="row">
            <div class="cell">
                <label for="com">com</label><input type="text" name="user" id="com">
            </div>
            <div class="cell">
                <label for="deptno">deptno</label><input type="text" name="user" id="deptno">
            </div>
        </div>
        <div class="row">
            <button type="submit">add</button>
        </div>
    </div>
</form>

<hr>

<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script >
/*    $(function () {
        $('button').click(function () {
            $("tr:last").after("<tr><td>" + $("#empno").val() + "</td>" +
                "<td>" + $("#ename").val() + "</td>" +
                "<td>" + $("#job").val() + "</td>" +
                "<td>" + $("#mgr").val() + "</td>" +
                "<td>" + $("#hiredate").val() + "</td>" +
                "<td>" + $("#sal").val() + "</td>" +
                "<td>" + $("#com").val() + "</td>" +
                "<td>" + $("#deptno").val() + "</td>" +
                "<td><a href='servlet/DeleteEmpServlet?empno="+$("#empno").val()+"'>点击刪除</a></td></tr>");
        });
    });*/
</script>
</body>
</html>
