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
        <h3 class="box-title">通道成本增加</h3>
    </div>
    <form name="child" action="<c:url value="/passageControl/add" />" method="post">
        <jsp:include page="psgControlForm.jsp"/>
    </form>
    <jsp:include page="../common/box-footer.jsp"/>
</div>
</body>
</html>
<script>
    $(".select2").select2();
    $(function () {
        $('form[name="child"]').submit(function () {
            var form = $('form[name="child"]');
            Defaults.submitForm(form);
            return false;
        });
    });
</script>