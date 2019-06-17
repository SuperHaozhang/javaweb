<%--
  Created by IntelliJ IDEA.
  User: 10216
  Date: 2019/6/16
  Time: 21:58
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
        #main {
            margin: 0 auto;
            width: 60%;
            position: relative;
            top: 200px;
        }

        .cell {
            display: inline-block;
        }

        .row .cell:nth-of-type(1) {
            width: 45%;
        }

        .row .cell:nth-of-type(2) {
            width: 45%;
        }

        .row {
            margin: 0 auto;
            width: 100%;
        }

        .row + .row {
            margin-top: 30px;
        }

        label {
            display: inline-block;
            width: 20%;
            font-weight: bold;
            margin-right: 10px;
        }

        .cell + .cell {
            margin-left: 100px;
        }

        input {
            height: 25px;
            width: 65%;
        }

        button {
            width: 150px;
            height: 40px;
            background-color: rgba(22, 155, 213, 1);
            border-radius: 10px;
            border: 0;
        }
    </style>
</head>
<body>
<div id="main">
    <form action="servlet/UserRegisterServlet" method="post" enctype="multipart/form-data">
        <div class="row">
            <div class="cell">
                <label for="username">Username</label><input type="text" name="username" id="username" value="">
            </div>
            <div class="cell">
                <label for="password">Password</label><input type="password" name="password" id="password">
            </div>
        </div>
        <div class="row">
            <div class="cell">
                <label for="confirmPassword">Confirm Password</label><input type="password" name="confirmPassword"
                                                                            id="confirmPassword">
            </div>
            <div class="cell">
                <label for="avatar">Avatar</label><input type="file" name="avatar" id="avatar">
            </div>
        </div>
        <div class="row">
            <button type="submit">Register</button>
        </div>
    </form>
</div>

<div>
    <c:forEach items="${usernamelist}" var="s">
        ${s.username}
    </c:forEach>
</div>

<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script>
    $(function () {
        $("button").click(function (e) {
            // 阻止单击默认行为
            e.preventDefault();

            let password = $("#password").val();
            let confirmPassword = $("#confirmPassword").val();
            if (password !== confirmPassword) {
                alert("确认密码必须与密码相同！");
                return;
            }

            // 提交表单
            $("form").submit();
        });

        $("#username").change(function () {
            //console.log("username值改变！");
            $.ajax({
                url: "servlet/UsernameCheckServlet",
                method: "POST",
                dataType: "JSON",
                data: {"username": $("#username").val()},
                success: function (response) {
                    if (response.code === "-1") {
                        $("button").attr("disabled", "disabled");
                        alert(response.message);
                    } else {
                        $("button").removeAttr("disabled");
                    }
                }
            });
        });
    });
</script>
</body>
</html>