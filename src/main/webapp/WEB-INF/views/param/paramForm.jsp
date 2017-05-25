<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title></title>
    <meta charset="UTF-8">
</head>
<body>
<table class="table">
    <tr>
        <td width="10%" class="tableleft"><label>参数键</label></td>
        <td><input type="text" name="key" class="form-control" value="${pm.key}" ${param.readonly} maxlength="50"
                   required/>
        </td>
    </tr>
    <tr>
        <td width="10%" class="tableleft"><label>参数值</label></td>
        <td><input type="text" name="value" class="form-control" value="${pm.value}" maxlength="50"
                   required/></td>
    </tr>
    <tr>
        <td width="10%" class="tableleft"><label>参数名称</label></td>
        <td><input type="text" name="name" class="form-control" value="${pm.name}" maxlength="50" required/></td>
    </tr>
    <tr>
        <td width="10%" class="tableleft"><label>分组名称</label></td>
        <td><input type="text" name="groupName" class="form-control" value="${pm.groupName}" maxlength="50"/>
        </td>
    </tr>
    <tr>
        <td width="10%" class="tableleft"><label>分组ID</label></td>
        <td><input type="text" name="groupId" class="form-control" value="${pm.groupId}" maxlength="50"/>
        </td>
    </tr>
</table>
</body>
</html>