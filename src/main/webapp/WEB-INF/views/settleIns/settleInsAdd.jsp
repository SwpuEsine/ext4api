<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title></title>
<script type="text/javascript"
            src="<c:url value="/static/plugins/jquery-validate/jquery.validate.min.js"/>"></script>
    <script src="<c:url value="/static/plugins/pace/pace.min.js"/>"></script>
    <script type="text/javascript"
            src="<c:url value="/static/plugins/jquery-validate/messages_cn.js"/>"></script>
     
<meta charset="UTF-8">
</head>
<body>

	<div class="box box-info">
		<div class="box-header with-border">
			<h3 class="box-title">清算通道增加</h3>
		</div>
		<form name="child" class="form-inline"
			action="<c:url value="/settleIns/add" />" method="post">
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
			 onfocusout: function(element) { 
				 $(element).valid();
			 },
		  rules:{ 
			  stlmId:{
				  required:true,  
                  rangelength:[1,4],
			  }
		  },
		
		})
		 $('form[name="child"]').submit(function() {
			var form = $('form[name="child"]');
			
			Defaults.submitForm(form);
			
			return false;
		}); 

		$(".select2").select2({
			placeholder : '请选择...',
			allowClear : true
		});

	});
</script>