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
            <label>参数键：</label>
            <input type="text" name="key" class="form-control" size="12">
            <label>参数名称：</label>
            <input type="text" name="name" class="form-control" size="12">
            <label>分组名称：</label>
            <input type="text" name="groupName" class="form-control" size="12">
            <button type="button" onclick="query();" class="btn btn-info"><i class="glyphicon glyphicon-search"></i>&nbsp;查询
            </button>
        </form>
    </div>
</div>

<div class="box box-success">
    <div class="box-header with-border">
        <h3 class="box-title">参数列表</h3>
        <div class="box-tools pull-right">
            <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
        </div>
        <div id="toolbar" class="btn-group box-tools">
            <button type="button" class="btn btn-default" onclick="Defaults.openAdd(this)"
                    url="<c:url value="/param/add"/>"><i class="fa fa-plus"></i>&nbsp;新增
            </button>
            <button type="button" class="btn btn-default" id="edit" url="<c:url value="/param/edit"/>"><i
                    class="fa fa-edit"></i>&nbsp;修改
            </button>
            <button type="button" class="btn btn-default" id="refshCache" url="<c:url value="/param/refshCache"/>"><i
                    class="fa fa-refresh"></i>&nbsp;刷新缓存
            </button>
        </div>
    </div>
    <div class="box-body">
        <table id="table"/>
    </div>
</div>

<script>
    var TableInit = TableInit.init({
        url: '<c:url value="/param/list" />',
        columns: [
            {field: 'GROUP_NAME', title: '分组名称'},
            {field: 'NAME', title: '参数名称'},
            {field: 'KEY', title: '参数键'},
            {field: 'VALUE', title: '参数值'},
            {field: 'GROUP_ID', title: '分组ID'}],
        params: function () {
            return {
                key: $('form [name="key"]').val(),
                name: $('form [name="name"]').val(),
                groupName: $('form [name="groupName"]').val()
            };
        }
    });
    function query() {
        TableInit.refresh();
    }

    $(function () {
        $('#edit').click(function () {
            var record = TableInit.getRecord();
            if (record == null) {
                return;
            }
            var url = $(this).attr("url") + "?key=" + record['KEY'] + "&value=" + record['VALUE'];
            reload(url);
        });

        $('#refshCache').click(function () {
            var _this = this;
            modal({
                type: 'confirm',
                title: '提示',
                text: '确认立即刷新缓存？',
                callback: function (result) {
                    if (result) {
                        $.ajax({
                            url: '<%=request.getContextPath()%>' + $(_this).attr("url"),
                            type: 'post',
                            dataType: 'json',
                            success: function (data) {
                                modal({
                                    type: 'success',
                                    title: '提示',
                                    text: data,
                                    center: false,
                                });
                            },
                        });
                    }
                }
            });
        });
    });
</script>
</body>
</html>
