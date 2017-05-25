<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title></title>
    <meta charset="UTF-8">
    <script src="<c:url value="/static/js/submit.js"/>"/>
</head>
<body>

<div class="box box-info">
    <div class="box-header with-border">
        <h3 class="box-title">菜单修改</h3>
    </div>
    <form action="<c:url value="/menu/edit" />" name="child" method="post">
        <jsp:include page="menuForm.jsp"/>
    </form>
    <jsp:include page="../common/box-footer.jsp"/>
</div>

</body>
</html>
