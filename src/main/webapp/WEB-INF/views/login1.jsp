<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"  %>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8" />
    <title>框架</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/static/css/login_style.css"/>"/>
    <link rel="stylesheet" type="text/css" href="<c:url value="/static/css/login.css"/>"/>
    <script src="<c:url value="/static/plugins/jQuery/jquery-2.2.3.min.js"/>"></script>
    <%--表单验证--%>
    <script type="text/javascript"
            src="<c:url value="/static/plugins/jquery-validate/jquery.validate.min.js"/>"></script>
    <script type="text/javascript"
            src="<c:url value="/static/plugins/jquery-validate/messages_cn.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/static/js/md5.js"/>"></script>
</head>
<body>
<div class="container">
    <!-- Codrops top bar -->
    <div class="codrops-top">
        <a href="">

        </a>
        <span class="right">

            <a target="_blank" href="http://rj.baidu.com/soft/detail/14744.html?ald">
                <strong>谷歌浏览器 </strong>
            </a>
            <a target="_blank" href="http://www.firefox.com.cn/download/">
                <strong>火狐浏览器 </strong>
            </a>
            <a target="_blank" href="<c:url value="/file/downApk"/>">
                <strong>安卓端下载 </strong>
            </a>
        </span>
        <div class="clr"></div>
    </div>
    <header>
        <h1>框架</h1>
    </header>
    <section>
        <div id="container_demo" >
            <a class="hiddenanchor" id="toregister"></a>
            <a class="hiddenanchor" id="tologin"></a>
            <div id="wrapper">
                <div id="login" class="animate form">
                    <form class="form-signin" method="post" onsubmit="return false" action="<c:url value="/web/login" />">
                        <h1>登录</h1>
                        <p>
                            <label for="username"> 用户账号</label>
                            <input id="username" name="uId" required="required" type="text" placeholder="账号"/>
                        </p>
                        <p>
                            <label for="userPwd"> 密码</label>
                            <input type="password" id="userPwd" name="userPwd" class="form-control" placeholder="密码" required>
                        </p>
                        <p>
                            <div style="float: left;margin-right: 30px;margin-top: 0px;">
                        <label for="rand" style="float: left;"> 验证码</label>
                                <input type="text" class="form-control" id="rand" name="rand" placeholder="验证码" required>
                            </div>
                            <div style="margin-top: 40px">
                                <img  src="<c:url value="/authImage"/>" id="randImg" width="80" height="30"/>
                            </div>
                        </p>
                        <p></p>
                        <label id="message" style="color: blue"></label>
                        <p class="login button">
                            <input type="submit" value="登录" />
                        </p>
                    </form>
                </div>
            </div>
        </div>
    </section>
</div>

<script>
    $('form').submit(function () {
        var form = $('form');
        var uId = $(':input[name="uId"]');
        var rand = $(':input[name="rand"]');
        var userPwd = $(':input[name="userPwd"]');
        var md5Pwd = hex_md5(userPwd.val());

        var valid = form.validate();
        if (!valid.valid()) {
            return false;
        }

        $.ajax({
            url: form.attr('action'),
            type: 'post',
            dataType: 'json',
            data: {
                uId:uId.val(),
                userPwd:md5Pwd,
                rand:rand.val(),
            },
            success: function (data) {
                if (data.result_code == "000000") {
                    $('#message').text("登录成功,加载中...");
                    location.reload();
                } else {
                    var error = data.result_msg;
                    $('#message').text(error);
                    if (data.result_code = '000029') {
                        $("img#randImg").click();
                    }
                }

            },
            error: function (data) {
                modal({
                    type: 'error',
                    title: '错误',
                    text: data
                });
            }
        });
        return false;
    });

    $('img#randImg').click(function () {
        var timestamp = (new Date()).valueOf();
        var imgSrc = $("img#randImg");
        imgSrc.attr('src', '<c:url value="/authImage"/>?data=' + timestamp);
    });


</script>
</body>
</html>