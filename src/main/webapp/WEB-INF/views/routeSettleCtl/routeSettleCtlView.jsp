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
        <h3 class="box-title">机构详情</h3>
    </div>
    <form name="child" onsubmit="return check()" class="form-inline" action="#"
          method="post" class="definewidth m20">
        <jsp:include page="routeSettleCtlForm.jsp"/>
    </form>
    <div class="box-footer">
        <div class="center-block" style="width:200px;">
            <button type="button" class="btn btn-social btn-default " onclick="back()"><i class="fa  fa-close">&nbsp;</i>关闭
            </button>
        </div>
    </div>
</div>

</body>
</html>
<script>
    $(function(){
        $(".select2").select2();
        $('#iframe-child form :input').attr('disabled', 'disabled');
        console.log($('#iframe-child form :input'));
        $('input[name=regDt]').datepicker({
            format: 'yyyymmdd',
            weekStart: 1,
            autoclose: true,
            todayBtn: 'linked',
            language: 'zh-CN'
        });
    });

</script>