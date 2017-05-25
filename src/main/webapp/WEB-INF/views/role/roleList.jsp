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
            <label>角色名称：</label>
            <input type="text" name="roleName" class="form-control" size="12">
            <button type="button" onclick="query();" class="btn btn-info">
                <i class="glyphicon glyphicon-search"></i>查询
            </button>
        </form>
    </div>
</div>

<div class="box box-success">
    <div class="box-header with-border">
        <h3 class="box-title">角色列表</h3>
        <div class="box-tools pull-right">
            <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
        </div>
        <div id="toolbar" class="btn-group box-tools">
            <button type="button" class="btn btn-default" onclick="Defaults.openAdd(this)"
                    url="<c:url value="/role/add"/>"><i class="fa fa-plus"></i>&nbsp;新增
            </button>
            <button type="button" class="btn btn-default" onclick="Defaults.openEdit(this,'ROLE_ID')"
                    url="<c:url value="/role/edit"/>"><i class="fa fa-edit"></i>&nbsp;修改
            </button>
            <button class="btn btn-default" onclick="Defaults.openDel(this,'ROLE_ID')"
                    url="<c:url value="/role/del"/>"><i class="fa fa-remove"></i>&nbsp;删除
            </button>
        </div>
    </div>
    <div class="box-body">
        <table id="table"/>
    </div>
</div>

<script>
    var TableInit = TableInit.init({
        url: '<c:url value="/role/list" />',
        columns: [
            {field: 'ROLE_ID', title: '角色编号'},
            {field: 'ROLE_NAME', title: '角色名称'}],
        params: function () {
            return {
                roleName: $('form [name="roleName"]').val()
            };
        }
    });
    function query() {
        TableInit.refresh();
    }
</script>
</body>
</html>
