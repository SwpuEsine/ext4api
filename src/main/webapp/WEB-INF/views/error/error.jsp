<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>error page</title>
    <meta charset="UTF-8">

    <%--bootstrup 框架及优化组件--%>
    <link rel="stylesheet" type="text/css" href="<c:url value="/static/bootstrap/css/bootstrap.min.css"/>"/>
    <script src="<c:url value="/static/plugins/jQuery/jquery-2.2.3.min.js"/>"></script>
    <script src="<c:url value="/static/bootstrap/js/bootstrap.min.js"/>"></script>
    <link href="<c:url value="/static/plugins/jquery-modal/jquery.modal.css"/>" type="text/css" rel="stylesheet"/>
    <link href="<c:url value="/static/plugins/jquery-modal/jquery.modal.theme-xenon.css"/>" type="text/css"
          rel="stylesheet"/>
    <script type="text/javascript" src="<c:url value="/static/plugins/jquery-modal/jquery.modal.min.js"/>"></script>
</head>
<body>
<script type="text/javascript">
    var error = "${error}";
    var code = "${code}";
    if ("000003" == code) {
        modal({
            type: 'error',
            title: '错误',
            text: error,
            callback: function (result) {
                window.location.href = "<c:url value='/web/loginOut.do'/>";
            }
        });

    } else {
        modal({
            type: 'error',
            title: '错误',
            text: error,
            callback: function (result) {
                history.go(-1);
            }
        });

    }


</script>
</body>
</html>
