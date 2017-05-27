<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title></title>
<meta charset="UTF-8">
</head>
<body>

	<div class="box box-info">
		<div class="box-header with-border">
			<h3 class="box-title">机构修改</h3>
		</div>
		<form name="child" onsubmit="return check()" class="form-inline"
			action="<c:url value="/routeSettleCtl/edit" />" method="post"
			class="definewidth m20">
			<jsp:include page="routeSettleCtlForm.jsp" />
		</form>
		<jsp:include page="../common/box-footer.jsp" />
	</div>

</body>
</html>
<script>
	$(function() {
		$('#iframe-child :input[name="id"]').attr('readonly', 'readonly');
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