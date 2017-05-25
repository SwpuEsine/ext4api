<%@ page import="zft.control.manager.entity.UserInfo" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <title>主页</title>
    <%--bootstrup 框架及优化组件--%>
    <link rel="stylesheet" type="text/css" href="<c:url value="/static/plugins/bootstrap/css/bootstrap.min.css"/>"/>
    <link rel="stylesheet" type="text/css"
          href="<c:url value="/static/plugins/font-awesome/css/font-awesome.min.css"/>"/>
    <link rel="stylesheet" type="text/css" href="<c:url value="/static/plugins/select2/css/select2.min.css"/>"/>
    <link rel="stylesheet" type="text/css" href="<c:url value="/static/plugins/adminlte/css/AdminLTE.min.css"/>"/>
    <link rel="stylesheet" type="text/css"
          href="<c:url value="/static/plugins/adminlte/css/skins/_all-skins.min.css"/>"/>
    <link rel="stylesheet" type="text/css"
          href="<c:url value="/static/plugins/icheck/skins/square/_all.css"/>"/>
    <link rel="stylesheet" type="text/css"
          href="<c:url value="/static/plugins/pace/themes/purple/pace-theme-material.css"/>"/>
    <link rel="stylesheet" type="text/css"
          href="<c:url value="/static/plugins/bootstrap-fileupload/fileinput.min.css"/>"/>
    <link rel="stylesheet" type="text/css"
          href="<c:url value="/static/plugins/toastr/toastr.min.css"/>"/>

    <script src="<c:url value="/static/plugins/jQuery/jquery-2.2.3.min.js"/>"></script>

    <script src="<c:url value="/static/plugins/icheck/icheck.js"/>"></script>
    <script src="<c:url value="/static/plugins/bootstrap-fileupload/fileinput.min.js"/>"></script>
    <script src="<c:url value="/static/plugins/bootstrap-fileupload/zh.js"/>"></script>
    <script src="<c:url value="/static/plugins/bootstrap/js/bootstrap.min.js"/>"></script>
    <script src="<c:url value="/static/plugins/pace/pace.min.js"/>"></script>
    <%--bootstrup-table--%>
    <link rel="stylesheet" type="text/css"
          href="<c:url value="/static/plugins/bootstrap-table/bootstrap-table.min.css"/>"/>
    <script src="<c:url value="/static/plugins/bootstrap-table/bootstrap-table.min.js"/>"></script>
    <script src="<c:url value="/static/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"/>"></script>
    <script src="<c:url value="/static/js/components/TableInit.js"/>"></script>
    <script src="<c:url value="/static/js/components/Select.js"/>"></script>
    <%--表单验证--%>
    <script type="text/javascript"
            src="<c:url value="/static/plugins/jquery-validate/jquery.validate.min.js"/>"></script>
    <script type="text/javascript"
            src="<c:url value="/static/plugins/jquery-validate/messages_cn.js"/>"></script>
    <%--alert弹出框--%>
    <link href="<c:url value="/static/plugins/jquery-modal/jquery.modal.css"/>" type="text/css" rel="stylesheet"/>
    <link href="<c:url value="/static/plugins/jquery-modal/jquery.modal.theme-xenon.css"/>" type="text/css"
          rel="stylesheet"/>
    <script type="text/javascript" src="<c:url value="/static/plugins/jquery-modal/jquery.modal.min.js"/>"></script>
    <%--时间控件--%>
    <script src="<c:url value="/static/plugins/datepicker/bootstrap-datepicker.js"/>"></script>
    <script src="<c:url value="/static/plugins/datepicker/locales/bootstrap-datepicker.zh-CN.js"/>"></script>
    <link rel="stylesheet" type="text/css" href="<c:url value="/static/plugins/datepicker/datepicker3.css"/>"/>
    <script type="text/javascript" src="<c:url value="/static/js/md5.js"/>"></script>
    <%--下拉组件--%>
    <script src="<c:url value="/static/plugins/select2/js/select2.js"/>"></script>
    <script src="<c:url value="/static/plugins/select2/js/i18n/zh-CN.js"/>"></script>
    <%--主界面框架--%>
    <script src="<c:url value="/static/plugins/adminlte/js/app.min.js"/>"></script>
    <script src="<c:url value="/static/plugins/toastr/toastr.min.js"/>"></script>
    <script src="<c:url value="/static/js/toastr.type.js"/>"></script>
    <style>
        .label-center {
            margin-top: 8px;
        }

        a {
            cursor: pointer;
            text-decoration: none;
        }

        a:link {
            text-decoration: none;
        }

        .datepicker {
            z-index: 1151 !important;
        }
    </style>
</head>
<%
    UserInfo userInf = (UserInfo) request.getSession().getAttribute("USER");
%>

<body onload="menuPers()" class="hold-transition skin-green sidebar-mini">
<div class="wrapper">
    <header class="main-header">
        <a href="javascript:void(0)" class="logo">
            <span class="logo-mini"><b>Z</b>FT</span>
            <span class="logo-lg"><b>支付通</b></span>
        </a>
        <nav class="navbar navbar-static-top">
            <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
                <span class="sr-only">Toggle navigation</span>
            </a>
            <div class="navbar-custom-menu">
                <ul class="nav navbar-nav">
                    <li class="dropdown messages-menu">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <span>账号</span> <i class="fa fa-gears"></i>
                        </a>
                        <ul class="dropdown-menu">
                            <li class="header">个人中心</li>
                            <li>
                                <ul class="menu">
                                    <li>
                                        <a href="<c:url value="/user/updPwdView" />" data-toggle="modal"
                                           data-target="#ajax">
                                            <div class="pull-left">
                                                <img src="<c:url value="/static/imgs/icon_head.png" />"
                                                     class="img-circle">
                                            </div>
                                            <h4>
                                                修改密码
                                            </h4>
                                            <p><%=userInf.getName()%>
                                            </p>
                                        </a>
                                        <a onclick="loginOut()">
                                            <div class="pull-left">
                                                <img src="<c:url value="/static/imgs/icon_head.png" />"
                                                     class="img-circle">
                                            </div>
                                            <h4>
                                                注销
                                            </h4>
                                            <p>${roleInf.roleName}</p>
                                        </a>
                                    </li>
                                </ul>
                            </li>
                        </ul>
                    </li>

                </ul>
            </div>
            <%--<div class="navbar-custom-menu">

                <ul class="nav navbar-nav">
                    <li class="dropdown user user-menu">
                        <a href="javascript:void(0)" class="dropdown-toggle" data-toggle="dropdown">
                            <i class="glyphicon glyphicon-user"></i>
                            <span class="hidden-xs">个人中心</span>
                        </a>
                        <ul class="dropdown-menu">
                            <li class="user-header">
                                <h3 style="color: #ffffff"><%=userInf.getName()%>
                                </h3>
                                <h5 style="color: #ffffff">${roleInf.roleName}
                                </h5>
                                <h5 style="color: #ffffff"><%=userInf.getUserId()%>
                                </h5>
                            </li>

                            <li class="user-footer">
                                <div class="pull-left">
                                    <a href="<c:url value="/user/updPwdView" />" data-toggle="modal"
                                       data-target="#ajax" class="btn btn-default btn-flat">修改密码</a>

                                </div>
                                <div class="pull-right">
                                    <a onclick="loginOut()" class="btn btn-default btn-flat">退出登录</a>
                                </div>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>--%>
        </nav>
    </header>

    <jsp:include page="common/modal.jsp">
        <jsp:param name="id" value="ajax"/>
    </jsp:include>

    <aside class="main-sidebar">
        <section class="sidebar">
            <ul class="sidebar-menu">
                <c:forEach var="item" items="${menuAll}" varStatus="status">
                    <li class="treeview">
                        <c:if test="${empty item.superId}">
                            <a href="#">
                                <i class="${item.menuIcon}"></i> <span>${item.menuName}</span>
                                <span class="pull-right-container">
                                            <i class="fa fa-angle-left pull-right"></i>
                                    </span>
                            </a>
                            <ul class="treeview-menu">
                                <c:forEach var="childItem" items="${menuAll}" varStatus="status">
                                    <c:if test="${ not empty childItem.superId && childItem.superId == item.menuId}">
                                        <li>
                                            <a target='<c:url value="${childItem.menuUrl}"/>' target="iframe-content">
                                                <i class="${childItem.menuIcon}"></i>
                                                    ${childItem.menuName}
                                            </a>
                                        </li>
                                    </c:if>
                                </c:forEach>
                            </ul>
                        </c:if>
                    </li>
                </c:forEach>
            </ul>
        </section>
    </aside>

    <div class="content-wrapper box-shadow">

        <section class="content">

            <div id="iframe-content" name="iframe-content" class="position:absolute; height:400px; overflow:auto">
                <!--Grid主页面-->
            </div>

            <div id="iframe-child" name="iframe-content" class="position:absolute; height:400px; overflow:auto">
                <!--Grid增加修改详情界面等-->
            </div>
        </section>
    </div>
</div>
<script>
    var menus = "<%= session.getAttribute("MENU")%>";
</script>
<script src="<c:url value="/static/js/PubFunc.js"/>"></script>
<script src="<c:url value="/static/js/main.js"/>"></script>
</body>
</html>

