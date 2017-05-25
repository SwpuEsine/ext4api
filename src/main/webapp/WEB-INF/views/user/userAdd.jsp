<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title></title>
    <meta charset="UTF-8">
</head>
<body>

<div class="box box-info">
    <div class="box-header with-border">
        <h3 class="box-title">用户增加</h3>
    </div>
    <form name="child" action="<c:url value="/user/add" />" method="post">
        <jsp:include page="userForm.jsp"/>
    </form>
    <jsp:include page="../common/box-footer.jsp"/>
</div>
</body>
</html>
<script>
    $(".select2").select2();
    function check() {
        var userPwd = $(':input[name="userPwdShow"]');
        var userPwd2 = $(':input[name="userPwd2Show"]');
        var userPwdHide = $(':input[name="passwd"]');
        var userPwd2Hide = $(':input[name="passwd2"]');
        if (userPwd.val() == null || userPwd.val() == "") {
            userPwd.focus();
            return false;
        }

        var md5Pwd1 = hex_md5(userPwd.val());
        var md5Pwd2 = hex_md5(userPwd2.val());

        if (md5Pwd1 != md5Pwd2) {
            userPwd2.focus();
            return false;
        }
        userPwdHide.val(md5Pwd1);
        userPwd2Hide.val(md5Pwd2);
        return true;
    }

    $(function () {
        $('form[name="child"]').submit(function () {
            var form = $('form[name="child"]');
            if (!check())
                return false;

            Defaults.submitForm(form);
            return false;
        });

        $('#userId').blur(function () {
            var userId = $('#userId').val();
            $.ajax({
                url: '<%=request.getContextPath()%>/user/check.do',
                type: 'get',
                data: {'userId': userId},
                dataType: 'json',
                success: function (json) {
                    if (json.result_code == "000000") {
                    } else {
                        modal({
                            type: 'error',
                            title: '错误',
                            text: json.result_msg
                        });
                        $('#userId').val("");
                    }
                },
            });
        });
    });
</script>