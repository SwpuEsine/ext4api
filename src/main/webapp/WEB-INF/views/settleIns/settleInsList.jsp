<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title></title>
<meta charset="UTF-8">
</head>
<body>
	<div class="box">
		<div class="box-header with-border">
			<h3 class="box-title">
				<i class="fa fa-search"></i> 查询
			</h3>

			<div class="box-tools pull-right">
				<button type="button" class="btn btn-box-tool"
					data-widget="collapse">
					<i class="fa fa-minus"></i>
				</button>
			</div>
		</div>
		<div class="box-body">
			<form class="form-inline">
				<label>通道编号：</label> <input name="stlmID" class="form-control"
					size="12"> <label>通道名称：</label> <input type="text"
					name="descr" class="form-control" size="12"> <label>通道状态：</label>
				<select name="useFlag" class="form-control select2"
					style="width: 15%;">
					<option value=""></option>
					<c:forEach items="${routeStatus.keySet()}" var="item">
						<option value="${item}">${routeStatus.get(item)}</option>
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
			<h3 class="box-title">通道列表</h3>

			<div class="box-tools pull-right">
				<button type="button" class="btn btn-box-tool"
					data-widget="collapse">
					<i class="fa fa-minus"></i>
				</button>
			</div>
			<div id="toolbar" class="btn-group box-tools">
				<button type="button" class="btn btn-default"
					onclick="Defaults.openAdd(this)"
					url="<c:url value="/settleIns/add"/>">
					<i class="fa fa-plus"></i>&nbsp;新增
				</button>
				<button type="button" class="btn btn-default"
					onclick="Defaults.openEdit(this,'STLM_ID')"
					url="<c:url value="/settleIns/edit"/>">
					<i class="fa fa-edit"></i>&nbsp;修改
				</button>
				<button class="btn btn-default"
					onclick="Defaults.openDel(this,'STLM_ID')"
					url="<c:url value="/settleIns/del"/>">
					<i class="fa fa-remove"></i>&nbsp;删除
				</button>

			</div>
		</div>
		<div class="box-body">
			<table id="table" />
		</div>
	</div>

	<script>
		var TableInit = TableInit.init({
			url : '<c:url value="/settleIns/list" />',
			columns : [
					{
						field : 'STLM_ID',
						title : '通道编号'
					},
					{
						field : 'DESCR',
						title : '通道名称'
					},
					{
						field : 'USE_FLAG',
						title : '状态',
						formatter : function(value) {
							return getParams("${routeStatus.keySet()}",
									"${routeStatus.values()}", value)
						}
					}, {
						field : 'REC_CRT_TS',
						title : '创建时间'
					}, {
						field : 'REC_UPD_TS',
						title : '修改时间'
					}, {
						field : 'UPD_USR_ID',
						title : '修改人'
					},

			],
			params : function() {
				return {
					stlmID : $('form [name="stlmID"]').val(),
					descr : $('form [name="descr"]').val(),
					useFlag : $('form [name="useFlag"]').val()

				};
			}
		});
		function query() {
			TableInit.refresh();
		}

		$(function() {
			$(".select2").select2({
				placeholder : '请选择...',
				allowClear : true
			});
		});
	</script>
</body>
</html>
