<%--
  Created by IntelliJ IDEA.
  User: 10216
  Date: 2019/6/13
  Time: 11:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

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
    <img id="avatar"><span id="user"></span><a href="servlet/OutLogin">点击退出</a>
    <span id="user1"></span><a href="/javaweb/inseret.jsp">点击添加</a>
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

        let header = ["empno", "ename", "job", "mgr", "hiredate", "sal", "com", "deptno", "操作"];

        $.ajax({
            url: requestURL,
            method:'GET',
            dataType:'json',
            success:function (response) {
                let $table=$("<table></table>");
                $('body').append($table);
                let $tr=$("<tr></tr>");
                $("table").append($tr);
                for (let i = 0; i <header.length; i++) {
                    let $th= $("<th></th>");
                    $tr.append($th);
                    $th.html(header[i]);
                }
                for (let i = 0; i < response.length; i++) {
                    let $tr1=$("<tr></tr>");
                    $("table").append($tr1);
                    for (let j = 0; j < header.length; j++) {
                        let $th= $("<td></td>");
                        $tr1.append($th);
                        if(j==(header.length-1)){
                            $th.html("<a href='servlet/DeleteEmpServlet?empno="+response[i][header[0]]+"'>刪除</a>"+"|"
                                +"<a href='/javaweb/EmpDemo.html?empno="+response[i][header[0]]
                                +"'>修改</a>");

/*                            $th.html("<a href='servlet/DeleteEmpServlet?empno="+response[i][header[0]]+"'>刪除</a>"+"|"
                                +"<a href='/javaweb/EmpDemo.html?empno="+response[i][header[0]]+"&ename="
                                +response[i][header[1]]+"&job="+response[i][header[2]]
                                +"&mgr"+response[i][header[3]]+"&hiredate"+response[i][header[4]]
                                +"&sal"+response[i][header[5]]+"&com"+response[i][header[6]]
                                +"&deptno"+response[i][header[7]]+"'>修改</a>");*/
                        }else{
                            $th.html(response[i][header[j]]);
                        }
                    }
                }
            }
        });
    });

</script>


</body>
</html>
