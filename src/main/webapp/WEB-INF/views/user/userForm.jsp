<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title></title>
    <meta charset="UTF-8">
</head>
<body>
<input type="hidden" name="userMenu"/>
<table class="table">
    <tr>
        <td class="col-md-1"><label class="label-center">用户账号</label></td>
        <td class="col-md-4">
            <input type="text" class="form-control" id="userId" name="userId" value="${user.userId}" ${param.readonly}/>
        </td>
        <td class="col-md-1"><label class="label-center">姓名</label></td>
        <td class="col-md-4">
            <input type="text" class="form-control" name="name" value="${user.name}"
                   maxlength="15" required/>
        </td>
    </tr>
    <tr id="pwd">
        <td class="col-md-1"><label class="label-center">用户密码</label></td>
        <td class="col-md-4">
            <input type="password" class="form-control" name="userPwdShow" maxlength="40"/>
            <input type="hidden" class="form-control" id="passwd" name="passwd" maxlength="40"/>
        </td>
        <td class="col-md-1"><label class="label-center">确认密码</label></td>
        <td class="col-md-4">
            <input type="password" class="form-control" name="userPwd2Show" maxlength="40"/>
            <input type="hidden" class="form-control" name="passwd2" maxlength="40"/>
        </td>
    </tr>
    <tr>
        <td class="col-md-1"><label class="label-center">手机号</label></td>
        <td class="col-md-4">
            <input type="text" class="form-control" name="tel" value="${user.tel}" maxlength="11"/>
        </td>
        <td class="col-md-1"><label class="label-center">邮箱</label></td>
        <td class="col-md-4">
            <input type="text" class="form-control" name="email" value="${user.email}" maxlength="30"/>
        </td>
    </tr>
    <tr>
        <td class="col-md-1"><label class="label-center">用户角色</label></td>
        <td class="col-md-4">
            <select name="roleId" class="select2 form-control" style="width: 100%;">
                <c:forEach var="item" items="${role}" varStatus="status">
                    <option
                            <c:if test='${item.roleId == user.roleId}'>
                                selected
                            </c:if>
                            value="${item.roleId}">${item.roleName}</option>
                </c:forEach>
            </select>
        </td>
        <td class="col-md-1"><label class="label-center">用户状态</label></td>
        <td class="col-md-4">
            <select name="userStatus" class="select2 form-control" style="width: 100%;">
                <c:forEach var="item" items="${userStatus.keySet()}" varStatus="status">
                    <option <c:if test='${item == user.userStatus}'>
                        selected
                    </c:if> value="${item}">${userStatus.get(item)}</option>
                </c:forEach>
            </select>
        </td>
    </tr>
</table>
</body>
</html>
