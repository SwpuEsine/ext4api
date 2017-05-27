<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title></title>
<meta charset="UTF-8">
<script type="text/javascript"
	src="<c:url value="/static/plugins/jquery-validate/jquery.validate.min.js"/>"></script>
<script src="<c:url value="/static/plugins/pace/pace.min.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/static/plugins/jquery-validate/messages_cn.js"/>"></script>
</head>
<body>

	<div class="box box-info">
		<div class="box-header with-border">
			<h3 class="box-title">通道修改</h3>
		</div>
		<form name="child" onsubmit="return check()" class="form-inline"
			action="<c:url value="/settleIns/edit" />" method="post"
			class="definewidth m20">
			<jsp:include page="settleInsForm.jsp" />
		</form>
		<jsp:include page="../common/box-footer.jsp" />
	</div>

</body>
</html>
<script>
	$(function() {
		$('form[name="child"]').validate({
			//失去焦点验证
			onfocusout : function(element) {
				$(element).valid();
			},
		})
		$('#iframe-child :input[name="stlmId"]').attr('readonly', 'readonly');
		$(".select2").select2({
			placeholder : '请选择...',
			allowClear : true
		});

		$('form[name="child"]').submit(function() {
			var form = $('form[name="child"]');

			Defaults.submitForm(form);
			return false;
		});
	});
</script>