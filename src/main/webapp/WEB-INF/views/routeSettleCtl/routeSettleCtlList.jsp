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
            <label>通道编号：</label>
            <input name="id" class="form-control" size="12">
            <label>通道名称：</label>
            <input type="text" name="routeName" class="form-control" size="12">
            <label>优先级：</label>
            <select name="routeCtlId" class="form-control select2" style="width:15%;">
                <option value=""></option>
                <c:forEach items="${brhTypeList.keySet()}" var="item">
                    <option value="${item}">
                        <c:out value="${brhTypeList.get(item)}"/>
                    </option>
                </c:forEach>
            </select>
            <label>通道状态：</label>
            <select name="routeCtlSta" class="form-control select2" style="width:15%;">
                <option value=""></option>
                <c:forEach items="${routeStatus.keySet()}" var="item">
                    <option value="${item}">
                        <c:out value="${routeStatus.get(item)}"/>
                    </option>
                </c:forEach>
            </select>
            <button type="button" onclick="query();" class="btn btn-info">
                <i class="glyphicon glyphicon-search"></i>查询
            </button>
        </form>
    </div>
</div>

<div class="box box-success">
    <div class="box-header with-border">
        <h3 class="box-title">清算通道控制列表</h3>

        <div class="box-tools pull-right">
            <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
        </div>
        <div id="toolbar" class="btn-group box-tools">
            <button type="button" class="btn btn-default" onclick="Defaults.openAdd(this)"
                    url="<c:url value="/routeSettleCtl/add"/>"><i class="fa fa-plus"></i>&nbsp;新增
            </button>
            <button type="button" class="btn btn-default" onclick="Defaults.openEdit(this,'ID')"
                    url="<c:url value="/routeSettleCtl/edit"/>"><i class="fa fa-edit"></i>&nbsp;修改
            </button>
            <button class="btn btn-default" onclick="Defaults.openDel(this,'ID')"
                    url="<c:url value="/routeSettleCtl/del"/>"><i class="fa fa-remove"></i>&nbsp;删除
            </button>
            <button class="btn btn-default" onclick="Defaults.openDetail(this,'ID')"
                    url="<c:url value="/routeSettleCtl/detail"/>"><i class="fa fa-eye"></i>&nbsp;详情
            </button>
        </div>
    </div>
    <div class="box-body">
        <table id="table"/>
    </div>
</div>

<script>
    var TableInit = TableInit.init({
        url: '<c:url value="/routeSettleCtl/list" />',
        columns: [
            {field: 'ID', title: '通道编号'},
            {field: 'ROUTE_NAME', title: '通道名称'},
            {field: 'ROUTE_CTL_ID', title: '优先级'},
            {field: 'ROUTE_CTL_STA', title: '通道使用标识'},
            {field: 'STLM_TYPE', title: '账户类型'},
            {field: 'INST_CODE', title: '使用的通道'},
            {field: 'LAST_OPER_IN', title: '录入操作员'},
            {field: 'REC_CRT_TS', title: '录入时间'},

        ],
        params: function () {
            return {
                brhId: $('form [name="brhId"]').val(),
                brhName: $('form [name="brhName"]').val(),
                brhType: $('form [name="brhType"]').val(),
                brhSta: $('form [name="brhSta"]').val()
            };
        }
    });
    function query() {
        TableInit.refresh();
    }

    $(function () {
        $(".select2").select2({
            placeholder: '请选择...', allowClear: true
        });
        $('input[name=regDt]').datepicker({
            format: 'yyyymmdd',
            weekStart: 1,
            autoclose: true,
            todayBtn: 'linked',
            language: 'zh-CN'
        });
    });
</script>
</body>
</html>
