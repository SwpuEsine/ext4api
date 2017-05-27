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
        <h3 class="box-title">通道成本修改</h3>
    </div>
    <form name="child" action="<c:url value="passageCost/edit" />" method="post">
        <jsp:include page="psgCostForm.jsp">
            <jsp:param name="readonly" value="readonly"/>
        </jsp:include>
    </form>
    <jsp:include page="../common/box-footer.jsp"/>
</div>
</body>
</html>
