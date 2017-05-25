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
        <td class="col-md-1"><label class="label-center">费率编号</label></td>
        <td class="col-md-4">
            <input type="text" class="form-control" id="userId" name="discCd" value="${user.userId}" ${param.readonly}/>
        </td>
        <td class="col-md-1"><label class="label-center">对应使用通道</label></td>
        <td class="col-md-4">
            <input type="text" class="form-control" name="instCode" value="${user.name}"
                   maxlength="15" required/>
        </td>
    </tr>
    <tr>
        <td class="col-md-1"><label class="label-center">卡种</label></td>
        <td class="col-md-4">
            <input type="password" class="form-control" name="friIn" maxlength="40"/>
        </td>
        <td class="col-md-1"><label class="label-center">商户MCC</label></td>
        <td class="col-md-4">
            <input type="password" class="form-control" name="mcc" maxlength="40"/>
        </td>
    </tr>
    <tr>
        <td class="col-md-1"><label class="label-center">计费类型</label></td>
        <td class="col-md-4">
            <input type="text" class="form-control" name="feeType" value="${user.tel}" maxlength="11"/>
        </td>
        <td class="col-md-1"><label class="label-center">固定手续费</label></td>
        <td class="col-md-4">
            <input type="text" class="form-control" name="feeFixed" value="${user.email}" maxlength="30"/>
        </td>
    </tr>
    <tr>
        <td class="col-md-1"><label class="label-center">交易上限(元)</label></td>
        <td class="col-md-4">
			<input type="text" class="form-control" name="floorAmount" value="${user.email}" maxlength="30"/>
        </td>
        <td class="col-md-1"><label class="label-center">交易下线(元)</label></td>
        <td class="col-md-4">
           <input type="text" class="form-control" name="upperAmount" value="${user.email}" maxlength="30"/>
        </td>
    </tr>
    <tr>
        <td class="col-md-1"><label class="label-center">手续费上限(元)</label></td>
        <td class="col-md-4">
            <input type="text" class="form-control" id="userId" name="feeMaxAmt" value="${user.userId}" ${param.readonly}/>
        </td>
        <td class="col-md-1"><label class="label-center">手续费下限(元)</label></td>
        <td class="col-md-4">
            <input type="text" class="form-control" name="feeMinAmt" value="${user.name}"
                   maxlength="15" required/>
        </td>
    </tr>
    <tr>
        <td class="col-md-1"><label class="label-center">扣率(%)</label></td>
        <td class="col-md-4">
            <input type="text" class="form-control" id="userId" name="feeRate" value="${user.userId}" ${param.readonly}/>
        </td>
        <td class="col-md-1"><label class="label-center">费率说明</label></td>
        <td class="col-md-4">
            <input type="text" class="form-control" name="discDesc" value="${user.name}"
                   maxlength="15" required/>
        </td>
    </tr>
</table>
</body>
</html>
