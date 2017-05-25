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
            <label>机构编码：</label>
            <input name="brhId" class="form-control" size="12">
            <label>机构名称：</label>
            <input type="text" name="brhName" class="form-control" size="12">
            <label>机构类别：</label>
            <select name="brhType" class="form-control select2" style="width:15%;">
                <option value=""></option>
                <c:forEach items="${brhTypeList.keySet()}" var="item">
                    <option value="${item}">
                        <c:out value="${brhTypeList.get(item)}"/>
                    </option>
                </c:forEach>
            </select>
            <label>机构状态：</label>
            <select name="brhSta" class="form-control select2" style="width:15%;">
                <option value=""></option>
                <c:forEach items="${brhStatusList.keySet()}" var="item">
                    <option value="${item}">
                        <c:out value="${brhStatusList.get(item)}"/>
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
        <h3 class="box-title">机构列表</h3>

        <div class="box-tools pull-right">
            <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
        </div>
        <div id="toolbar" class="btn-group box-tools">
            <button type="button" class="btn btn-default" onclick="Defaults.openAdd(this)"
                    url="<c:url value="/brh/add"/>"><i class="fa fa-plus"></i>&nbsp;新增
            </button>
            <button type="button" class="btn btn-default" onclick="Defaults.openEdit(this,'BRH_ID')"
                    url="<c:url value="/brh/edit"/>"><i class="fa fa-edit"></i>&nbsp;修改
            </button>
            <button class="btn btn-default" onclick="Defaults.openDel(this,'BRH_ID')"
                    url="<c:url value="/brh/del"/>"><i class="fa fa-remove"></i>&nbsp;删除
            </button>
            <button class="btn btn-default" onclick="Defaults.openDetail(this,'BRH_ID')"
                    url="<c:url value="/brh/detail"/>"><i class="fa fa-eye"></i>&nbsp;详情
            </button>
        </div>
    </div>
    <div class="box-body">
        <table id="table"/>
    </div>
</div>

<script>
    var TableInit = TableInit.init({
        url: '<c:url value="/brh/list" />',
        columns: [
            {field: 'BRH_ID', title: '机构编号'},
            {field: 'BRH_NAME', title: '机构名称'},
            {
                field: 'BRH_TYPE', title: '机构类型',
                formatter: function (value) {
                    return getParams("${brhTypeList.keySet()}", "${brhTypeList.values()}", value);
                }
            },
            {field: 'BRH_LEVEL', title: '机构等级'},
            {field: 'CUP_BRH_ID', title: '上级机构编号'},
            {
                field: 'BRH_STA', title: '机构状态',
                formatter: function (value) {
                    return getParams("${brhStatusList.keySet()}", "${brhStatusList.values()}", value);
                }
            },
            {field: 'UP_BRH_ID', title: '银联机构号'},
            {field: 'POST_CD', title: '邮政编码'},
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
