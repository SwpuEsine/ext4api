<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<style type="text/css">
    li {
        list-style-type: none;
    }
</style>

<table class="table">
    <tr>
        <td class="col-md-1"><label class="label-center">机构编号</label></td>
        <td class="col-md-4">
            <input type="text" name="brhId" class="form-control" value="${brh.brhId}" style="width: 100%;"
                                    required/></td>
        <td class="col-md-1"><label class="label-center">机构名称</label></td>
        <td class="col-md-4"><input type="text" name="brhName" class="form-control" value="${brh.brhName}" style="width: 100%;"
                   required/></td>

    </tr>
    <tr>
        <td class="col-md-1"><label class="label-center">上级机构编号</label></td>
        <td class="col-md-4">
            <input type="text" name="cupBrhId" class="form-control" value="${brh.cupBrhId}" style="width: 100%;"
                   required/>
        </td>
        <td class="col-md-1"><label>机构类别</label></td>
        <td class="col-md-4">
            <select name = "brhType" class="select2 form-control" value="${brh.brhType}" style="width: 100%;">
                <option value=""></option>
                <c:forEach items="${brhTypeList.keySet()}" var="item">
                    <option value="${item}" <c:if test="${item==brh.brhType}"> selected </c:if> >
                        <c:out value="${brhTypeList.get(item)}"/>
                    </option>
                </c:forEach>
            </select>
        </td>

    </tr>
    <tr>

        <td class="col-md-1"><label>机构等级</label></td>
        <td class="col-md-4">
            <input type="text" name="brhLevel" class="form-control" value="${brh.brhLevel}"
                   style="width: 100%;" maxlength="1" required/>
        </td>
        <td class="col-md-1"><label>机构状态</label></td>
        <td class="col-md-4">
            <select name="brhSta" class="select2 form-control" value="${brh.brhSta}" style="width: 100%;">
                <option value=""></option>
                <c:forEach items="${brhStatusList.keySet()}" var="item">
                    <option value="${item}"
                        <c:if test="${item==brh.brhSta}">
                            selected
                        </c:if>>
                        <c:out value="${brhStatusList.get(item)}"/>
                    </option>
                </c:forEach>
            </select>
        </td>


    </tr>
    <tr>
        <td class="col-md-1"><label>银联机构号</label></td>
        <td class="col-md-4"><input type="text" name="upBrhId" class="form-control" value="${brh.upBrhId}" style="width: 100%;"
            required/></td>
        <td class="col-md-1"><label>注册时间</label></td>
        <td class="col-md-4">
            <div class="input-group date" style="width: 100%;">
                <div class="input-group-addon" style="width:15%;">
                    <i class="fa fa-calendar"></i>
                </div>
                <input type="text" class="form-control pull-right" name="regDt" size="8" value="${brh.regDt}">
            </div>
        </td>
    </tr>
    <tr>
        <td class="col-md-1"><label>邮政编码</label></td>
        <td class="col-md-4">
            <input type="text" name="postCd" class="form-control" value="${brh.postCd}" style="width: 100%;"
                                   maxlength="6" required/></td>
        <td class="col-md-1"><label>机构地址</label></td>
        <td class="col-md-4"><input type="text" name="brhAddr" class="form-control" value="${brh.brhAddr}" style="width: 100%;"
                   required/></td>


    </tr>
    <tr>
        <td class="col-md-1"><label>机构联系电话</label></td>
        <td class="col-md-4"><input type="text" name="brhTelNo" class="form-control" value="${brh.brhTelNo}" style="width: 100%;"
                                    required/></td>
        <td class="col-MD-1"><label>所在地区码</label></td>
        <td class="col-md-4"><input type="text" name="resv1" class="form-control" value="${brh.resv1}" style="width: 100%;"
                   required/></td>
    </tr>


</table>