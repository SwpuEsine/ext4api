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
            <label>上级名称：</label>
            <input type="text" name="suName" size="12" class="form-control">
            <label>菜单名称：</label>
            <input type="text" name="menuName" size="12" class="form-control">
            <label>URL：</label>
            <input type="text" name="menuUrl" size="12" class="form-control">
            <button type="button" onclick="query();" class="btn btn-info"><i class="glyphicon glyphicon-search"></i>&nbsp;查询
            </button>
        </form>
    </div>
</div>

<div class="box box-success">
    <div class="box-header with-border">
        <h3 class="box-title">菜单列表</h3>
        <div class="box-tools pull-right">
            <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
        </div>
        <div id="toolbar" class="btn-group box-tools">
            <button type="button" class="btn btn-default"
                    onclick="Defaults.openAdd(this)"
                    url="<c:url value="/menu/add"/>"><i class="fa fa-plus"></i>&nbsp;新增
            </button>
            <button type="button" class="btn btn-default"
                    onclick="Defaults.openEdit(this,'MENU_ID')"
                    url="<c:url value="/menu/edit"/>"><i class="fa fa-edit"></i>&nbsp;修改
            </button>
            <button type="button" class="btn btn-default"
                    onclick="Defaults.openDel(this,'MENU_ID')"
                    url="<c:url value="/menu/del"/>"><i class="fa fa-times"></i>&nbsp;删除
            </button>
        </div>
    </div>
    <div class="box-body">
        <table id="table"/>
    </div>
</div>

</body>
</html>
<script>
    var TableInit = TableInit.init({
        url: '<c:url value="/menu/list" />',
        columns: [
            {field: 'MENU_ID', visible: false, title: '菜单编号'},
            {field: 'SU_NAME', title: '上级名称'},
            {field: 'MENU_NAME', title: '菜单名称'},
            {field: 'MENU_URL', title: 'URL'}],
        params: function () {
            return {
                menuName: $('form [name="menuName"]').val(),
                menuUrl: $('form [name="menuUrl"]').val(),
                suName: $('form [name="suName"]').val(),
                groupName: $('form [name="groupName"]').val()
            };
        }
    });
    function query() {
        TableInit.refresh();
    }
</script>