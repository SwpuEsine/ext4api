<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title></title>
    <meta charset="UTF-8">
</head>
<body>
<input type="hidden" name="menuId" value="${menu.menuId}"/>
<table class="table">
    <tr>
        <td class="tableleft"><label>菜单级别</label></td>
        <td>
            <select name="urlLevel" class="form-control select2" style="width: 100%;">
                <c:forEach var="item" items="${urlLevel.keySet()}" varStatus="status">
                    <option <c:if test='${item == menu.urlLevel}'>
                        selected
                    </c:if> value="${item}">${urlLevel.get(item)}</option>
                </c:forEach>
            </select>
    </tr>
    <tr>
        <td width="10%" class="tableleft"><label>上级菜单</label></td>
        <td>
            <select name="superId" class="form-control select2" style="width: 100%;" required>
                <c:forEach var="item" items="${superIds}" varStatus="status">
                    <option <c:if test='${item[0] == menu.superId}'>
                        selected
                    </c:if> value="${item[0]}">${item[1]}</option>
                </c:forEach>
            </select>
        </td>
    </tr>
    <tr>
        <td class="tableleft"><label>菜单名称</label></td>
        <td><input type="text" name="menuName" class="form-control" value="${menu.menuName}" maxlength="50"/></td>
    </tr>
    <tr>
        <td class="tableleft"><label>URL</label></td>
        <td><input type="text" name="menuUrl" class="form-control" value="${menu.menuUrl}" maxlength="50"/></td>
    </tr>
    <tr>
        <td class="tableleft"><label>图标</label></td>
        <td><input type="text" name="menuIcon" class="form-control" value="${menu.menuIcon}" maxlength="50"/></td>
    </tr>
    <tr>
        <td class="tableleft"><label>图标支持</label></td>
        <td><i class="${menu.menuIcon}"></i>FontAwesome 图标或Bootstrap 图标 仅限菜单列表可用</td>
    </tr>
</table>
<script>
    $(".select2").select2();
</script>
</body>
</html>
