<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript" src="<c:url value="/static/js/md5.js"/>"></script>
<div class="modal-header">
    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
    </button>
    <h4>修改密码</h4>
</div>
<div class="modal-body">
    <form name="updatePasswd">
        <div class="form-group row">
            <label for="oldPassword" class="col-sm-offset-2 col-sm-2 control-label align-right">原密码</label>
            <div class="col-sm-6">
                <input type="password" class="form-control" name="oldPassword" id="oldPassword"
                       placeholder="请输入原密码">
                <p class="text-danger" id="oldPasswordWarning"></p>
            </div>
        </div>
        <div class="form-group row">
            <label for="newPassword" class="col-sm-offset-2 col-sm-2 control-label align-right">新密码</label>
            <div class="col-sm-6">
                <input type="password" class="form-control" name="newPassword" id="newPassword"
                       placeholder="请输入新密码">
                <p></p>
            </div>
        </div>
        <div class="form-group row">
            <label for="confirmPassword" class="col-sm-offset-2 col-sm-2 control-label align-right">确认密码</label>
            <div class="col-sm-6">
                <input type="password" class="form-control" id="confirmPassword" placeholder="请再次输入新密码">
                <p class="text-danger" id="confirmPasswordWarning"></p>
            </div>

        </div>
        <div class="modal-footer" style="background-color: #FFFFFF">
            <button type="button" id="cancel" class="btn btn-default" data-dismiss="modal">取消</button>
            <button type="button" id="confirm" class="btn btn-primary">确认</button>
        </div>
    </form>
</div>

<script>
    $(function () {
        $("#confirm").click(function () {
            var oldPassword = $("#oldPassword").val();
            var newPassword = $("#newPassword").val();
            var confirmPassword = $("#confirmPassword").val();
            if (newPassword != confirmPassword) {
                $("#confirmPasswordWarning").text("两次输入的密码不一致");
                $("#confirmPassword").val("");
                return false;
            }
            oldPassword = hex_md5(oldPassword);
            newPassword = hex_md5(newPassword);
            $.ajax({
                type: "GET",
                url: "<%=request.getContextPath()%>/user/updPwd",
                contentType: "application/json",
                dataType: "json",
                data: {newPassword: newPassword, oldPassword: oldPassword},
                success: function (data) {
                    if (data.result_code == "000000") {
                        modal({
                            type: 'success',
                            title: '成功',
                            text: data.result_msg,
                            callback: function () {
                                loginOut();
                            }
                        });
                    } else {
                        $("#oldPasswordWarning").text(data.result_msg);
                    }
                }
            })
        });
    });
</script>

