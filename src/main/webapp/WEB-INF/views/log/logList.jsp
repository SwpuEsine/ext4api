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
        </div>
    </div>
    <div class="box-body">
        <form class="form-inline">
            <div class="form-group">
                <label>开始日期:</label>
                <div class="input-group date">
                    <div class="input-group-addon">
                        <i class="fa fa-calendar"></i>
                    </div>
                    <input type="text" class="form-control pull-right" name="startDate" size="15">
                </div>
            </div>
            <div class="form-group">
                <label>结束日期:</label>
                <div class="input-group date">
                    <div class="input-group-addon">
                        <i class="fa fa-calendar"></i>
                    </div>
                    <input type="text" class="form-control pull-right" name="endDate" size="15">
                </div>
            </div>
            <label>操作URL：</label>
            <input type="text" name="oprUrl" class="form-control" size="12">
            <label>用户编号：</label>
            <select name="oprId" class="select2 form-control" style="width: 150px"/>
            <button type="button" onclick="query();" class="btn btn-info"><i
                    class="glyphicon glyphicon-search"></i>&nbsp;查询&nbsp;
            </button>
        </form>
    </div>
</div>
<div class="box box-success">
    <div class="box-header with-border">
        <h3 class="box-title">日志列表</h3>
        <div class="box-tools pull-right">
            <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
        </div>
        <div id="toolbar" class="btn-group box-tools">
            <%--<button type="button" class="btn btn-default" onclick="Defaults.openDel(this,'USER_ID')" url="log/del">
                <i class="glyphicon glyphicon-remove"></i>&nbsp;删除
            </button>--%>
        </div>
    </div>
    <div class="box-body">
        <table id="table"/>
    </div>
</div>

<script>

    var TableInit = TableInit.init({
        url: '<c:url value="/log/list" />',
        columns: [
            {field: 'OPR_NAME', title: '操作员'},
            {field: 'OPR_TS', title: '操作时间', formatter: TableInit.formatDate},
            {field: 'MENU_NAME', title: '操作功能'},
            {field: 'OPR_URL', title: '操作URL'},
        ],
        params: function () {
            return {
                oprUrl: $('form [name="oprUrl"]').val(),
                oprId: $('form [name="oprId"]').val(),
                startDate: $('form [name="startDate"]').val(),
                endDate: $('form [name="endDate"]').val()
            };
        }
    });
    function query() {
        TableInit.refresh();
    }

    $(".select2").select2();
    Select.init({
        conName: 'oprId',
        url: '<%=request.getContextPath()%>/user/userSel',
        multiple: false,
    });

    $('input[name=startDate]').datepicker({
        format: 'yyyymmdd',
        weekStart: 1,
        autoclose: true,
        todayBtn: 'linked',
        language: 'zh-CN',
    });
    $('input[name=endDate]').datepicker({
        format: 'yyyymmdd',
        weekStart: 1,
        autoclose: true,
        todayBtn: 'linked',
        language: 'zh-CN',
    });
</script>
</body>
</html>
