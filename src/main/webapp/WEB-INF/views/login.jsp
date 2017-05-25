<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <TITLE>登录页面</TITLE>
    <META content="IE=11.0000" http-equiv="X-UA-Compatible">
    <META http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" type="text/css" href="<c:url value="/static/css/login_latest.css"/>"/>
    <link rel="stylesheet" type="text/css"
          href="<c:url value="/static/plugins/font-awesome/css/font-awesome.min.css"/>">
    <link rel="stylesheet" type="text/css"
          href="<c:url value="/static/plugins/pace/themes/white/pace-theme-minimal.css"/>"/>
    <link rel="stylesheet" type="text/css"
          href="<c:url value="/static/plugins/toastr/toastr.min.css"/>"/>

    <script src="<c:url value="/static/plugins/jQuery/jquery-2.2.3.min.js"/>"></script>
    <script type="text/javascript"
            src="<c:url value="/static/plugins/jquery-validate/jquery.validate.min.js"/>"></script>
    <script src="<c:url value="/static/plugins/pace/pace.min.js"/>"></script>
    <script type="text/javascript"
            src="<c:url value="/static/plugins/jquery-validate/messages_cn.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/static/js/md5.js"/>"></script>
    <script src="<c:url value="/static/plugins/toastr/toastr.min.js"/>"></script>
    <script src="<c:url value="/static/js/toastr.type.js"/>"></script>
    <link rel="stylesheet" type="text/css"
          href="<c:url value="/static/plugins/font-awesome/css/font-awesome.min.css"/>"/>
</head>

<body>
<div class="top_div"></div>
<form id="login-form" class="form-signin" method="post" onsubmit="return false" action="<c:url value="/web/login" />">
    <div class="login-box">
        <DIV class="squirrel" style="">
            <DIV class="tou"></DIV>
        </DIV>
        <P style="padding: 30px 0px 10px; position: relative;">
            <SPAN class="u_logo"></SPAN>
            <INPUT id="username" name="uId" class="ipt" type="text" placeholder="请输入用户名" required>
        </P>
        <P style="position: relative;">
            <SPAN class="p_logo"></SPAN>
            <INPUT id="userPwd" name="userPwd" class="ipt" type="password" placeholder="请输入密码" required>
        </P>
        <div class="verify-line" style="">
            <i class="fa fa-check logo" aria-hidden="true"></i>
            <div class="inner-box">
                <INPUT class="ipt" id="rand" name="rand" type="text" placeholder="请输入验证码" required
                       style="width: 100px; float: left;">
                <div class="verifycode">
                    <img src="<c:url value="/authImage"/>" id="randImg" width="80" height="30"/>
                </div>
            </div>
        </div>
        <div class="btn-box">
            <p class="btn-line">
               <span style="float: right;">
                    <A class="btn-login" href="javascript:void(0)" onclick="sub();">登录</A>
               </span>
            </p>
        </div>
    </div>
</form>
</div>
</body>
<script type="text/javascript">
    $(function () {
        //得到焦点
        $("#userPwd").focus(function () {
            $("#left_hand").animate({
                left: "150",
                top: " -38"
            }, {
                step: function () {
                    if (parseInt($("#left_hand").css("left")) > 140) {
                        $("#left_hand").attr("class", "left_hand");
                    }
                }
            }, 2000);
            $("#right_hand").animate({
                right: "-64",
                top: "-38px"
            }, {
                step: function () {
                    if (parseInt($("#right_hand").css("right")) > -70) {
                        $("#right_hand").attr("class", "right_hand");
                    }
                }
            }, 2000);
        });
        //失去焦点
        $("#userPwd").blur(function () {
            $("#left_hand").attr("class", "initial_left_hand");
            $("#left_hand").attr("style", "left:100px;top:-12px;");
            $("#right_hand").attr("class", "initial_right_hand");
            $("#right_hand").attr("style", "right:-112px;top:-12px");
        });
    });

    function sub() {
        var form = $('form');
        var uId = $(':input[name="uId"]');
        var rand = $(':input[name="rand"]');
        var userPwd = $(':input[name="userPwd"]');
        var md5Pwd = hex_md5(userPwd.val());

        var valid = form.validate();
        if (!valid.valid()) {
            return false;
        }
        Pace.start();
        $.ajax({
            url: form.attr('action'),
            type: 'post',
            dataType: 'json',
            data: {
                uId: uId.val(),
                userPwd: md5Pwd,
                rand: rand.val(),
            },
            success: function (data) {
                Pace.stop();
                if (data.result_code == "000000") {
                    location.reload();
                } else {
                    toastrerror(data.result_msg);
                    if (data.result_code = '000029') {
                        $("img#randImg").click();
                    }
                }
            },
            error: function (data) {
                Pace.stop();
                modal({
                    type: 'error',
                    title: '错误',
                    text: data
                });
            }
        });
        return false;
    }

    $('img#randImg').click(function () {
        var timestamp = (new Date()).valueOf();
        var imgSrc = $("img#randImg");
        imgSrc.attr('src', '<c:url value="/authImage"/>?data=' + timestamp);
    });


    $(document).keydown(function (e) {
        if (e.keyCode === 13) sub();
    });
</script>
</html>
