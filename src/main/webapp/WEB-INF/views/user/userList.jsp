<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title></title>
    <meta charset="UTF-8">
</head>
<body>
<div class="box">
    <div class="box-header with-border">
        <h3 class="box-title"><i class="fa fa-search"></i> 查询</h3>
        <div class="box-tools pull-right">
            <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
            <%--<button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>--%>
        </div>
    </div>
    <div class="box-body">
        <form class="form-inline">
            <label>昵称：</label>
            <input type="text" name="name" class="form-control" size="12">
            <label>账号：</label>
            <input type="text" id="userIdQuery" name="userId" class="form-control" size="12">
            <label>用户状态：</label>
            <select name="userStatus" class="select2 form-control" style="width: 150px;">
                <option value="">请选择</option>
                <c:forEach var="item" items="${userStatus.keySet()}" varStatus="status">
                    <option value="${item}">${userStatus.get(item)}</option>
                </c:forEach>
            </select>
            <button type="button" onclick="query();" class="btn btn-info"><i
                    class="glyphicon glyphicon-search"></i>&nbsp;查询&nbsp;
            </button>
        </form>
    </div>
</div>
<div class="box box-success">
    <div class="box-header with-border">
        <h3 class="box-title">用户列表</h3>
        <div class="box-tools pull-right">
            <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
        </div>
        <div id="toolbar" class="btn-group box-tools">
            <button type="button" class="btn btn-default" onclick="Defaults.openAdd(this)" url="user/add">
                <i class="fa fa-plus"></i>&nbsp;新增
            </button>
            <button type="button" class="btn btn-default" onclick="Defaults.openEdit(this,'USER_ID')" url="user/edit">
                <i class="fa fa-edit"></i>&nbsp;修改
            </button>
            <button type="button" class="btn btn-default" onclick="Defaults.openDel(this,'USER_ID')" url="user/del">
                <i class="glyphicon glyphicon-remove"></i>&nbsp;删除
            </button>
            <button type="button" class="btn btn-default" onclick="reset(this)" url="user/reset"><i
                    class="glyphicon glyphicon-lock"></i>&nbsp;重置密码
            </button>
        </div>
    </div>
    <div class="box-body">
        <table id="table"/>
    </div>
</div>

<script>
    var TableInit = TableInit.init({
        url: '<c:url value="/user/list" />',
        columns: [
            {field: 'ROLE_ID', title: '用户角色'},
            {field: 'USER_ID', title: '用户账号'},
            {field: 'NAME', title: '姓名'},
            {field: 'TEL', title: '手机号'},
            {field: 'EMAIL', title: '邮箱'},
            {
                field: 'CRT_TS', title: '创建时间',
                formatter: TableInit.formatDate
            }, {
                field: 'UPD_TS', title: '更新时间',
                formatter: TableInit.formatDate
            }, {
                field: 'USER_STATUS', title: '用户状态',
                formatter: function (value) {
                    return getParams("${userStatus.keySet()}", "${userStatus.values()}", value);
                }
            }, {
                field: 'BRH_ID', title: '机构编号'
            }
        ],
        params: function () {
            return {
                name: $('form [name="name"]').val(),
                userId: $('form [name="userId"]').val(),
                userStatus: $('form [name="userStatus"]').val()
            };
        }
    });
    function query() {
        TableInit.refresh();
    }

    function reset(_this) {
        var record = TableInit.getRecord();
        if (record == null) {
            return;
        }
        var val = record['USER_ID'];
        modal({
            type: 'confirm',
            title: '重置密码',
            text: '确认立即重置密码？',
            callback: function (result) {
                if (result) {
                    var userId = val;
                    var userPwd = hex_md5('111111');
                    Defaults.submitEvent({
                        url: $(_this).attr("url"),
                        data: {
                            userId: userId,
                            userPwd: userPwd
                        },
                    });
                }
            }
        });
    }

    $(function () {
        $(".select2").select2();
    });
</script>
</body>
</html>
