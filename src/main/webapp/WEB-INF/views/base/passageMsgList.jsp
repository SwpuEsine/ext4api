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
            <input type="text" name="instCode" class="form-control" size="12">
            <label>通道名称：</label>
            <input type="text" name="instName" class="form-control" size="12">
            <label>状态：</label>
            <input type="text" name="instStat" class="form-control" size="12">
            <label>超限标志：</label>
            <input type="text" name="overrunFlag" class="form-control" size="12">
            <button type="button" onclick="query();" class="btn btn-info">
                <i class="glyphicon glyphicon-search"></i>查询
            </button>
        </form>
    </div>
</div>

<div class="box box-success">
    <div class="box-header with-border">
        <h3 class="box-title">通道信息</h3>
        <div class="box-tools pull-right">
            <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
        </div>
        <div id="toolbar" class="btn-group box-tools">
            <button type="button" class="btn btn-default" onclick="Defaults.openAdd(this)"
                    url="<c:url value="/passageMsg/add"/>"><i class="fa fa-plus"></i>&nbsp;新增
            </button>
            <button type="button" class="btn btn-default" onclick="Defaults.openEdit(this,'BRH_ID')"
                    url="<c:url value="/passageMsg/edit"/>"><i class="fa fa-edit"></i>&nbsp;修改
            </button>
            <button class="btn btn-default" onclick="Defaults.openDel(this,'BRH_ID')"
                    url="<c:url value="/passageMsg/del"/>"><i class="fa fa-remove"></i>&nbsp;删除
            </button>
        </div>
    </div>
    <div class="box-body">
        <table id="table"/>
    </div>
</div>
<script>
    var TableInit = TableInit.init({
        url: '<c:url value="/passageMsg/list" />',
        columns: [
            {field: 'INST_CODE', title: '通道编号'},
            {field: 'INST_NAME', title: '通道名称'},
            {field: 'INST_STAT', title: '状态'},
            {field: 'SRV_ID', title: '进程编号'},
            {field: 'CHG_FLAG', title: '转换标志'},
            {field: 'X_MCHT_NO', title: '转换商户号'},
            {field: 'X_TERM_ID', title: '转换终端号'},
            {field: 'X_BRH_CODE', title: '转换机构号'},
            {field: 'DAY_TOT_MAX_AMT', title: '通道当日交易上限(元)'},
            {field: 'MON_TOT_MAX_AMT', title: '通道当月交易上限(元)'},
            {field: 'RISK_CTL_TYPE', title: '受控动作(元)'},
            {field: 'RISK_MAX_TXN_AMT', title: '单笔预警金额(元)'},
            {field: 'RISK_DAY_TXN_NUM', title: '日交易预警笔数(元)'},
            {field: 'RISK_DAY_TXN_AMT', title: '日交易预警金额(元)'},
            {field: 'OVERRUN_FLAG', title: '是否超限'}         
        ],
        params: function () {
            return {
            	"instCode": $('form [name="instCode"]').val(),
            	"instName": $('form [name="instName"]').val(),
            	"instStat": $('form [name="instStat"]').val(),
            	"overrunFlag": $('form [name="overrunFlag"]').val(),
            };
        }
    });
    function query() {
        TableInit.refresh();
    }
</script>
</body>
</html>