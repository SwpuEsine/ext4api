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
            <label>费率编号：</label>
            <input type="text" name="discCd" class="form-control" size="12">
            <label>使用通道：</label>
            <input type="text" name="instCode" class="form-control" size="12">
            <label>卡种：</label>
            <input type="text" name="friIn" class="form-control" size="12">
            <label>商户mcc：</label>
            <input type="text" name="mcc" class="form-control" size="12">
            <button type="button" onclick="query();" class="btn btn-info">
                <i class="glyphicon glyphicon-search"></i>查询
            </button>
        </form>
    </div>
</div>

<div class="box box-success">
    <div class="box-header with-border">
        <h3 class="box-title">通道成本</h3>
        <div class="box-tools pull-right">
            <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
        </div>
        <div id="toolbar" class="btn-group box-tools">
            <button type="button" class="btn btn-default" onclick="Defaults.openAdd(this)" url="passageCost/add">
                <i class="fa fa-plus"></i>&nbsp;新增
            </button>
            <button type="button" class="btn btn-default" onclick="Defaults.openEdit(this,'USER_ID')" url="passageCost/edit">
                <i class="fa fa-edit"></i>&nbsp;修改
            </button>
            <button type="button" class="btn btn-default" onclick="Defaults.openDel(this,'USER_ID')" url="passageCost/del">
                <i class="glyphicon glyphicon-remove"></i>&nbsp;删除
            </button>
        </div>
    </div>
    <div class="box-body">
        <table id="table"/>
    </div>
</div>
<script>
    var TableInit = TableInit.init({
        url: '<c:url value="/passageCost/list" />',
        columns: [
            {field: 'DISC_CD', title: '费率编号'},
            {field: 'INST_CODE', title: '使用通道'},
            {field: 'FRI_IN', title: '卡种'},
            {field: 'MCC', title: '商户mcc'},
            {field: 'FEE_TYPE', title: '计费类型'},
            {field: 'FEE_FIXED', title: '固定手续费'},
            {field: 'FLOOR_AMOUNT', title: '交易上限'},
            {field: 'UPPER_AMOUNT', title: '交易下限'},
            {field: 'FEE_MAX_AMT', title: '手续费上限'},
            {field: 'FEE_MIN_AMT', title: '手续费下限'},
            {field: 'FEE_RATE', title: '扣率（%）'},
            {field: 'DISC_DESC', title: '费率说明'},
            {field: 'CRT_OPR', title: '录入柜员'},
            {field: 'UPD_OPR', title: '修改柜员'},
            {field: 'CRT_TS', title: '录入时间'},
            {field: 'UPD_TS', title: '修改时间'}           
        ],
        params: function () {
            return {
            	"discCd": $('form [name="discCd"]').val(),
            	"instCode": $('form [name="instCode"]').val(),
            	"friIn": $('form [name="friIn"]').val(),
            	"mcc": $('form [name="mcc"]').val(),
            };
        }
    });
    function query() {
        TableInit.refresh();
    }
</script>
</body>
</html>