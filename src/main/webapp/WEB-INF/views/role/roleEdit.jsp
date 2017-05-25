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
        <h3 class="box-title">权限修改</h3>
    </div>
    <form name="child" onsubmit="return check()" class="form-inline" action="<c:url value="/role/edit" />"
          method="post" class="definewidth m20">
        <jsp:include page="roleForm.jsp"/>
    </form>
    <jsp:include page="../common/box-footer.jsp"/>
</div>

</body>
</html>
<script>
    function check() {
        var roleMenu = $(':input[name="roleMenu"]');
        var spCodesTemp = "";
        $(':input:checkbox:checked').each(function (i) {
            if (0 == i) {
                spCodesTemp = $(this).val();
            } else {
                spCodesTemp += ("," + $(this).val());
            }
        });
        if (spCodesTemp == "") {
            alert("您未选择任何权限!");
            return false;
        }
        roleMenu.val(spCodesTemp);
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
    });
</script>