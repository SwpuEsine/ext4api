<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title></title>
    <meta charset="UTF-8">
</head>
<body>

<div class="box box-info">
    <div class="box-header with-border">
        <h3 class="box-title">机构增加</h3>
    </div>
    <form name="child" class="form-inline" action="<c:url value="/brh/add" />" method="post" >
        <jsp:include page="brhForm.jsp"/>
    </form>
    <jsp:include page="../common/box-footer.jsp"/>
</div>

</body>
</html>

<script>
    $(function () {
        $(".select2").select2({
            placeholder: '请选择...',
            allowClear: true
        });
        $(':input[name=regDt]').datepicker({
            format: 'yyyymmdd',
            weekStart: 1,
            autoclose: true,
            todayBtn: 'linked',
            language: 'zh-CN'
        });

        $('form[name="child"]').submit(function () {
            var form = $('form[name="child"]');
            if (!check())
                return false;
            Defaults.submitForm(form);
            return false;
        });

        $("#iframe-child :input[name='brhId']").blur(checkBrhId)
    });

    function checkBrhId() {
        var brhId = $("#iframe-child :input[name='brhId']");
        var flag = true;
        var id = brhId.val();
        $.ajax({
            type: 'get',
            url: '<%=request.getContextPath()%>/brh/check.do',
            data: {'brhId': id},
            dataType: 'json',
            success: function(json) {
                if (json.result_code == "000000") {
                }else {
                    $(brhId).val("");
                    modal({
                        type: 'error',
                        title: '错误',
                        text: json.result_msg
                    });
                    flag = false;
                }
            }
        });
        return flag;
    }

    function check() {
        var brhId = $("#iframe-child :input[name='brhId']");
        if(brhId.val().trim() == "") {
            modal({
                type: 'error',
                title: '错误',
                text: '请输入机构编号'
            });
            return false;
        }

        return true;
    }
</script>
<script src="<c:url value="/static/js/submit.js"/>"/>