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
    function check() {
        return true;

    }
    $(function () {
        $(':checkbox').click(function () {
            $(':checkbox', $(this).closest('li')).prop('checked', this.checked);
        });

        $('form[name="child"]').submit(function () {
            var form = $('form[name="child"]');
            if (!check())
                return false;
            Defaults.submitForm(form);
            return false;
        });

        $(".select2").select2({
            placeholder: '请选择...',
            allowClear: true
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