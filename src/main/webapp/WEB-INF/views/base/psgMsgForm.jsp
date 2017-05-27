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
        <td class="col-md-1"><label class="label-center">通道编号</label></td>
        <td class="col-md-4">
            <input type="text" class="form-control" id="userId" name="instCode" 
            value="${pmi.instCode}" ${param.readonly} datatype="n4-4"/>
            <span><div class="Validform_checktip" ></div></span>
        </td>
        <td class="col-md-1"><label class="label-center">通道名称</label></td>
        <td class="col-md-4">
            <input type="text" class="form-control" name="instName" value="${pmi.instName}"
                   maxlength="15" datatype="*" />
                   <span><div class="Validform_checktip" ></div></span>
        </td>
    </tr>
    <tr>
        <td class="col-md-1"><label class="label-center">状态</label></td>
        <td class="col-md-4">
            <input type="text" class="form-control" datatype="*" name="instStat" maxlength="40" value="${pmi.instStat}"/>
            <span><div class="Validform_checktip" ></div></span>
        </td>
        <td class="col-md-1"><label class="label-center">进程编号</label></td>
        <td class="col-md-4">
            <input type="text" class="form-control" datatype="n4-4" name="srvId" maxlength="40" value="${pmi.srvId}"/>
            <span><div class="Validform_checktip" ></div></span>
        </td>
    </tr>
    <tr>
        <td class="col-md-1"><label class="label-center">转换标志</label></td>
        <td class="col-md-4">
            <input type="text" class="form-control" datatype="*" name="chgFlag" value="${pmi.chgFlag}" maxlength="11"/>
            <span><div class="Validform_checktip" ></div></span>
        </td>
        <td class="col-md-1"><label class="label-center">转换商户号</label></td>
        <td class="col-md-4">
            <input type="text" class="form-control" datatype="n15-15"  name="xMchtNo" value="${pmi.xMchtNo}" maxlength="30"/>
            <span><div class="Validform_checktip" ></div></span>
        </td>
    </tr>
    <tr>
        <td class="col-md-1"><label class="label-center">转换终端号</label></td>
        <td class="col-md-4">
          <input type="text" class="form-control" datatype="n8-8" name="xTermId" value="${pmi.xTermId}" maxlength="30"/>
          <span><div class="Validform_checktip" ></div></span>
        </td>
        <td class="col-md-1"><label class="label-center">转换机构号</label></td>
		<td class="col-md-4">
          <input type="text" class="form-control"  datatype="*" name="xBrhCode" value="${pmi.xBrhCode}" maxlength="30"/>
          <span><div class="Validform_checktip" ></div></span>
        </td>
    </tr>
    <tr>
        <td class="col-md-1"><label class="label-center">当日交易上限(元)</label></td>
        <td class="col-md-4">
            <input type="text" datatype="n" class="form-control" id="userId" name="dayTotMaxAmt" 
            value="${pmi.dayTotMaxAmt}" ${param.readonly} value="0" ignore="ignore"/>
            <span><div class="Validform_checktip" ></div></span>
        </td>
        <td class="col-md-1"><label class="label-center">当月交易上限(元)</label></td>
        <td class="col-md-4">
            <input type="text" class="form-control" name="monTotMaxAmt" value="${pmi.monTotMaxAmt}"
                datatype="n"   maxlength="15" value="0" ignore="ignore"/>
            <span><div class="Validform_checktip" ></div></span>
        </td>
    </tr>
    <tr>
        <td class="col-md-1"><label class="label-center">超限标志</label></td>
        <td class="col-md-4">
            <input type="text" datatype="*" class="form-control" id="userId" name="overrunFlag" value="${pmi.overrunFlag}" ${param.readonly}/>
            <span><div class="Validform_checktip" ></div></span>
        </td>
        <td class="col-md-1"><label class="label-center">日交易预警金额</label></td>
        <td class="col-md-4">
            <input type="text" class="form-control" name="riskDayTxnAmt" value="${pmi.riskDayTxnAmt}"
                   maxlength="15" required datatype="n"/>
                   <span><div class="Validform_checktip" ></div></span>
        </td>
    </tr>
    <tr>
        <td class="col-md-1"><label class="label-center">日交易预警笔数</label></td>
        <td class="col-md-4">
            <input type="text" class="form-control" datatype="n1-10000" id="userId" name="riskDayTxnNum" value="${pmi.riskDayTxnNum}" ${param.readonly}/>
            <span><div class="Validform_checktip" ></div></span>
        </td>
        <td class="col-md-1"><label class="label-center">单笔预警金额</label></td>
        <td class="col-md-4">
            <input type="text" class="form-control" name="riskMaxTxnAmt" value="${pmi.riskMaxTxnAmt}"
                   maxlength="15" datatype="n"/>
            <span><div class="Validform_checktip" ></div></span>
        </td>
    </tr>
     <tr>
        <td class="col-md-1"><label class="label-center">受控动作</label></td>
        <td class="col-md-4">
            <input type="text" class="form-control" datatype="*"  name="riskCtlType" value="${pmi.riskCtlType}" ${param.readonly}/>
            <span><div class="Validform_checktip" ></div></span>
        </td>
    </tr>
</table>
</body>
</html>
