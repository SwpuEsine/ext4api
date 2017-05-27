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
            <label>优先级：</label>
            <input type="text" name="routeCtlId" class="form-control" size="12">
            <label>通道名称：</label>
            <input type="text" name="routeName" class="form-control" size="12">
            <label>卡类型设置：</label>
            <input type="text" name="cardTp" class="form-control" size="12">
            <label>商户类型：</label>
            <input type="text" name="mchtType" class="form-control" size="12">
            <label>终端类型：</label>
            <input type="text" name="termType" class="form-control" size="12">
            <button type="button" onclick="query();" class="btn btn-info">
                <i class="glyphicon glyphicon-search"></i>查询
            </button>
        </form>
    </div>
</div>

<div class="box box-success">
    <div class="box-header with-border">
        <h3 class="box-title">通道控制</h3>
        <div class="box-tools pull-right">
            <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
        </div>
        <div id="toolbar" class="btn-group box-tools">
            <button type="button" class="btn btn-default" onclick="Defaults.openAdd(this)"
                    url="passageControl/add"><i class="fa fa-plus"></i>&nbsp;新增
            </button>
            <button type="button" class="btn btn-default" onclick="Defaults.openEdit(this,'ID')"
                    url="<c:url value="passageControl/edit"/>"><i class="fa fa-edit"></i>&nbsp;修改
            </button>
            <button class="btn btn-default" onclick="Defaults.openDel(this,'ID')"
                    url="<c:url value="passageControl/del"/>"><i class="fa fa-remove"></i>&nbsp;删除
            </button>
        </div>
    </div>
    <div class="box-body">
        <table id="table"/>
    </div>
</div>
<script>
    var TableInit = TableInit.init({
        url: '<c:url value="/passageControl/list" />',
        columns: [
            {field: 'ID', title: '通道编号'},
            {field: 'ROUTE_CTL_ID', title: '优先级'},
            {field: 'ROUTE_NAME', title: '通道名称'},
            {field: 'ROUTE_CTL_STA', title: '通道使用标识'},
            {field: 'CARD_TP_USE_FLAG', title: '卡类型使用标识'},
            {field: 'CARD_TP', title: '卡类型设置'},
            {field: 'ISSUER_USE_FLAG', title: '发卡方设置'},
            {field: 'ISSUER_CD', title: '发卡方编号'},
            {field: 'BIN_LEN', title: '卡BIN长度'},
            {field: 'BIN_NO', title: '卡BIN'},
            {field: 'TXN_NUM_USE_FLAG', title: '交易代码设置'},
            {field: 'TXN_NUM', title: '交易代码'},
            {field: 'TXN_AMT_USE_FLAG', title: '交易金额设置'},
            {field: 'MIN_TXN_AMT', title: '最小金额(元)'},
            {field: 'MAX_TXN_AMT', title: '最大金额(元)'},
            {field: 'MCHT_TYPE_USE_FLAG', title: '商户类型设置'},
            {field: 'MCHT_TYPE', title: '商户类型'},
            {field: 'TERM_TYPE_USE_FLAG', title: '终端类型设置'},
            {field: 'TERM_TYPE', title: '终端类型'},
            {field: 'MCHT_GROUP_USE_FLAG', title: '集团使用标志'},
            {field: 'MCHT_GROUP_ID', title: '集团编号'},
            {field: 'MCHT_FEE_TYPE_USE_FLAG', title: '商户费率类型设置'}, 
            {field: 'MCHT_FEE_TYPE', title: '商户费率类型'}, 
            {field: 'MCHT_TP_GRP_USE_FLAG', title: '商户组别使用标志'},
            {field: 'MCHT_TP_GRP', title: '商户组别'},
            {field: 'CITY_CODE_USE_FLAG', title: '商户地区码使用标志'},
            {field: 'CITY_CODE', title: '商户地区码'}, 
            {field: 'MCHT_MODE_USE_FLAG', title: '商户特殊类型使用标志'}, 
            {field: 'MCHT_MODE', title: '商户特殊类型'}, 
            {field: 'MCHT_NO_USE_FLAG', title: '商户池使用标志'},
            {field: 'MCHT_NO', title: '指定商户池'}, 
            {field: 'INST_CODE', title: '使用的通道池'},
            {field: 'CRT_OPR', title: '录入操作员'},
            {field: 'UPD_OPR', title: '修改操作员'},
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