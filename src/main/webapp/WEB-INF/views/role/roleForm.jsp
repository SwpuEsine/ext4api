<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<style type="text/css">
    li {
        list-style-type: none;
    }
</style>

<input type="hidden" name="roleMenu"/>
<input type="hidden" name="roleId" value="${role.roleId}"/>
<table class="table table-bordered">
    <tr>
        <td width="10%" class="tableleft"><label>角色名称</label></td>
        <td><input type="text" name="roleName" class="form-control" value="${role.roleName}" maxlength="20"
                   required/></td>
    </tr>
    <tr>
        <td class="tableleft">权限</td>
        <td>
            <div>
                <c:forEach var="item" items="${menuAll}" varStatus="status">
                    <c:if test="${empty item.superId}">
                        <li class="box box-default">
                            <div class="box-header with-border">
                                <label class="box-title"><input type='checkbox'
                                        <c:if test='${role != null && role.roleMenu.indexOf(item.menuId.toString()) != -1}'>
                                            checked
                                        </c:if> name='group[]' value='${item.menuId}'/>${item.menuName}
                                </label>
                            </div>
                            <ul class="box-body">
                                <c:forEach var="childItem" items="${menuAll}" varStatus="status">
                                    <c:if test="${ not empty childItem.superId && childItem.superId == item.menuId}">
                                        <li>
                                            <div class="checkbox" style="width: 100%;">
                                                <label style="color: #1f7f9f;">
                                                    <input type='checkbox' <c:if
                                                            test='${role != null && role.roleMenu.indexOf(childItem.menuId.toString()) != -1}'>
                                                        checked
                                                    </c:if> name='node[]'
                                                           value='${childItem.menuId}'/>${childItem.menuName}
                                                </label>
                                            </div>
                                            <ul>
                                                <c:forEach var="threeItem" items="${menuAll}" varStatus="status">
                                                    <c:if test="${ not empty threeItem.superId && threeItem.superId == childItem.menuId}">
                                                        <li>
                                                            <div class="checkbox" style="float: left;">
                                                                <label style="color: #1f7f9f;">
                                                                    <input type='checkbox'  <c:if
                                                                            test='${role != null && role.roleMenu.indexOf(threeItem.menuId.toString()) != -1}'>
                                                                        checked
                                                                    </c:if> name='node[]'
                                                                           value='${threeItem.menuId}'/>${threeItem.menuName}&nbsp;&nbsp;
                                                                </label>
                                                            </div>
                                                        </li>
                                                    </c:if>
                                                </c:forEach>
                                            </ul>
                                        </li>
                                    </c:if>
                                </c:forEach>
                            </ul>
                        </li>
                    </c:if>
                </c:forEach>
            </div>
        </td>
    </tr>

</table>