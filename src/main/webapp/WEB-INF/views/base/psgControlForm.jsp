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
        <td class="col-md-1"><label class="label-center">优先级</label></td>
        <td class="col-md-4">
            <input type="text" class="form-control" id="userId" name="instCode" value="${pci.instCode}" ${param.readonly}/>
        </td>
        <td class="col-md-1"><label class="label-center">通道名称</label></td>
        <td class="col-md-4">
            <input type="text" class="form-control" name="instName" value="${pci.instCode}"
                   maxlength="15" required/>
        </td>
    </tr>
    <tr>
        <td class="col-md-1"><label class="label-center">通道使用标识</label></td>
        <td class="col-md-4">
            <input type="password" class="form-control" name="instStat" maxlength="40" value="${pci.instCode}"/>
            <input type="hidden" class="form-control" id="passwd" name="passwd" maxlength="40"/>
        </td>
        <td class="col-md-1"><label class="label-center">卡类型使用标识</label></td>
        <td class="col-md-4">
            <input type="password" class="form-control" name="srvId" maxlength="40" value="${pci.instCode}"/>
            <input type="hidden" class="form-control" name="passwd2" maxlength="40"/>
        </td>
    </tr>
    <tr>
        <td class="col-md-1"><label class="label-center">卡类型设置</label></td>
        <td class="col-md-4">
            <input type="text" class="form-control" name="chgFlag" value="${pci.instCode}" maxlength="11"/>
        </td>
        <td class="col-md-1"><label class="label-center">发卡方设置</label></td>
        <td class="col-md-4">
            <input type="text" class="form-control" name="xMchtNo" value="${pci.instCode}" maxlength="30"/>
        </td>
    </tr>
    <tr>
        <td class="col-md-1"><label class="label-center">发卡方编号</label></td>
        <td class="col-md-4">
          <input type="text" class="form-control" name="xTermId" value="${pci.instCode}" maxlength="30"/>
        </td>
        <td class="col-md-1"><label class="label-center">卡Bin长度</label></td>
		<td class="col-md-4">
          <input type="text" class="form-control" name="xBrhCode" value="${pci.instCode}" maxlength="30"/>
        </td>
    </tr>
    <tr>
        <td class="col-md-1"><label class="label-center">卡Bin</label></td>
        <td class="col-md-4">
            <input type="text" class="form-control" id="userId" name="dayTotMaxAmt" value="${pci.instCode}" ${param.readonly}/>
        </td>
        <td class="col-md-1"><label class="label-center">交易代码设置</label></td>
        <td class="col-md-4">
            <input type="text" class="form-control" name="monTotMaxAmt" value="${pci.instCode}"
                   maxlength="15" required/>
        </td>
    </tr>
    <tr>
        <td class="col-md-1"><label class="label-center">交易代码</label></td>
        <td class="col-md-4">
            <input type="text" class="form-control" id="userId" name="overrunFlag" value="${pci.instCode}" ${param.readonly}/>
        </td>
        <td class="col-md-1"><label class="label-center">交易金额设置</label></td>
        <td class="col-md-4">
            <input type="text" class="form-control" name="riskDayTxnAmt" value="${pci.instCode}"
                   maxlength="15" required/>
        </td>
    </tr>
    <tr>
        <td class="col-md-1"><label class="label-center">最小金额</label></td>
        <td class="col-md-4">
            <input type="text" class="form-control" id="userId" name="riskDayTxnNum" value="${pci.instCode}" ${param.readonly}/>
        </td>
        <td class="col-md-1"><label class="label-center">最大金额</label></td>
        <td class="col-md-4">
            <input type="text" class="form-control" name="riskMaxTxnAmt" value="${pci.instCode}"
                   maxlength="15" required/>
        </td>
    </tr>
     <tr>
        <td class="col-md-1"><label class="label-center">商户类型使用标识</label></td>
        <td class="col-md-4">
            <input type="text" class="form-control" id="userId" name="riskCtlType" value="${pci.instCode}" ${param.readonly}/>
        </td>
        <td class="col-md-1"><label class="label-center">商户类型</label></td>
        <td class="col-md-4">
            <input type="text" class="form-control" id="userId" name="riskCtlType" value="${pci.instCode}" ${param.readonly}/>
        </td>
    </tr>
    <tr>
        <td class="col-md-1"><label class="label-center">终端类型使用标识</label></td>
        <td class="col-md-4">
            <input type="text" class="form-control" id="userId" name="riskCtlType" value="${pci.instCode}" ${param.readonly}/>
        </td>
        <td class="col-md-1"><label class="label-center">终端类型</label></td>
        <td class="col-md-4">
            <input type="text" class="form-control" id="userId" name="riskCtlType" value="${pci.instCode}" ${param.readonly}/>
        </td>
    </tr>
    <tr>
        <td class="col-md-1"><label class="label-center">集团使用标识</label></td>
        <td class="col-md-4">
            <input type="text" class="form-control" id="userId" name="riskCtlType" value="${pci.instCode}" ${param.readonly}/>
        </td>
        <td class="col-md-1"><label class="label-center">集团编号</label></td>
        <td class="col-md-4">
            <input type="text" class="form-control" id="userId" name="riskCtlType" value="${pci.instCode}" ${param.readonly}/>
        </td>
    </tr>
     <tr>
        <td class="col-md-1"><label class="label-center">商户费率使用标识</label></td>
        <td class="col-md-4">
            <input type="text" class="form-control" id="userId" name="riskCtlType" value="${pci.instCode}" ${param.readonly}/>
        </td>
        <td class="col-md-1"><label class="label-center">商户费率类型</label></td>
        <td class="col-md-4">
            <input type="text" class="form-control" id="userId" name="riskCtlType" value="${pci.instCode}" ${param.readonly}/>
        </td>
    </tr>
     <tr>
        <td class="col-md-1"><label class="label-center">产品类型使用标识</label></td>
        <td class="col-md-4">
            <input type="text" class="form-control" id="userId" name="riskCtlType" value="${pci.instCode}" ${param.readonly}/>
        </td>
        <td class="col-md-1"><label class="label-center">产品类型</label></td>
        <td class="col-md-4">
            <input type="text" class="form-control" id="userId" name="riskCtlType" value="${pci.instCode}" ${param.readonly}/>
        </td>
    </tr>
     <tr>
        <td class="col-md-1"><label class="label-center">使用的通道池</label></td>
        <td class="col-md-4">
            <input type="text" class="form-control" id="userId" name="riskCtlType" value="${pci.instCode}" ${param.readonly}/>
        </td>
        <td class="col-md-1"><label class="label-center">商户组别使用标识</label></td>
        <td class="col-md-4">
            <input type="text" class="form-control" id="userId" name="riskCtlType" value="${pci.instCode}" ${param.readonly}/>
        </td>
    </tr>
     <tr>
        <td class="col-md-1"><label class="label-center">商户组别</label></td>
        <td class="col-md-4">
            <input type="text" class="form-control" id="userId" name="riskCtlType" value="${pci.instCode}" ${param.readonly}/>
        </td>
        <td class="col-md-1"><label class="label-center">地区码使用标识</label></td>
        <td class="col-md-4">
            <input type="text" class="form-control" id="userId" name="riskCtlType" value="${pci.instCode}" ${param.readonly}/>
        </td>
    </tr>
    <tr>
        <td class="col-md-1"><label class="label-center">商户地区码</label></td>
        <td class="col-md-4">
            <input type="text" class="form-control" id="userId" name="riskCtlType" value="${pci.instCode}" ${param.readonly}/>
        </td>
        <td class="col-md-1"><label class="label-center">特殊类型标识</label></td>
        <td class="col-md-4">
            <input type="text" class="form-control" id="userId" name="riskCtlType" value="${pci.instCode}" ${param.readonly}/>
        </td>
    </tr>
    <tr>
        <td class="col-md-1"><label class="label-center">商户特殊类型</label></td>
        <td class="col-md-4">
            <input type="text" class="form-control" id="userId" name="riskCtlType" value="${pci.instCode}" ${param.readonly}/>
        </td>
        <td class="col-md-1"><label class="label-center">商户池使用标识</label></td>
        <td class="col-md-4">
            <input type="text" class="form-control" id="userId" name="riskCtlType" value="${pci.instCode}" ${param.readonly}/>
        </td>
    </tr>
    <tr>
        <td class="col-md-1"><label class="label-center">特定商户池</label></td>
        <td class="col-md-4">
            <input type="text" class="form-control" id="userId" name="riskCtlType" value="${pci.instCode}" ${param.readonly}/>
        </td>
        <td class="col-md-1"><label class="label-center">行业细类使用标识</label></td>
        <td class="col-md-4">
            <input type="text" class="form-control" id="userId" name="riskCtlType" value="${pci.instCode}" ${param.readonly}/>
        </td>
    </tr>
    <tr>
        <td class="col-md-1"><label class="label-center">行业细类</label></td>
        <td class="col-md-4">
            <input type="text" class="form-control" id="userId" name="riskCtlType" value="${pci.instCode}" ${param.readonly}/>
        </td>
        <td class="col-md-1"><label class="label-center">特定MCC使用标识</label></td>
        <td class="col-md-4">
            <input type="text" class="form-control" id="userId" name="riskCtlType" value="${pci.instCode}" ${param.readonly}/>
        </td>
    </tr>
    <tr>
        <td class="col-md-1"><label class="label-center">MCC池</label></td>
        <td class="col-md-4">
            <input type="text" class="form-control" id="userId" name="riskCtlType" value="${pci.instCode}" ${param.readonly}/>
        </td>
    </tr>
</table>
</body>
</html>
