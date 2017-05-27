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
            <input type="text" class="form-control" name="discCd" value="${pci.discCd}" readonly/>
            <span><div class="Validform_checktip" ></div></span>
        </td>
        <td class="col-md-1"><label class="label-center">对应使用通道</label></td>
        <td class="col-md-4">
            <input type="text"   class="form-control"  name="instCode" value="${pci.instCode}"
                   datatype="*"/>
               <span><div id="cc" class="Validform_checktip" ></div></span>
        </td>
    </tr>
    <tr>
        <td class="col-md-1"><label class="label-center">卡种</label></td>
        <td class="col-md-4">
            <input type="text" class="form-control" name="friIn" maxlength="40" value="${pci.friIn}"/>
        </td>
        <td class="col-md-1"><label class="label-center">商户MCC</label></td>
        <td class="col-md-4">
            <input type="text" class="form-control" name="mcc" maxlength="40" value="${pci.mcc}" readonly/>
        </td>
    </tr>
    <tr>
        <td class="col-md-1"><label class="label-center">计费类型</label></td>
        <td class="col-md-4"><!-- 单笔按比例  单笔固定 -->
            <input type="text" class="form-control" name="feeType" value="${pci.feeType}" maxlength="11"  datatype="*"/>
             <span><div class="Validform_checktip" ></div></span>
        </td>
        <td class="col-md-1"><label class="label-center">固定手续费</label></td>
        <td class="col-md-4">
            <input type="text" class="form-control" name="feeFixed" value="${pci.feeFixed}" maxlength="30" datatype="n"/>
            <span><div class="Validform_checktip" ></div></span>
        </td>
    </tr>
    <tr>
        <td class="col-md-1"><label class="label-center">交易上限(元)</label></td>
        <td class="col-md-4">
			<input type="text" class="form-control" name="floorAmount" value="${pci.floorAmount}" maxlength="30" ignore="ignore" datatype="n"/>
			<span><div class="Validform_checktip" ></div></span>
        </td>
        <td class="col-md-1"><label class="label-center">交易下线(元)</label></td>
        <td class="col-md-4">
           <input type="text" class="form-control" name="upperAmount" value="${pci.upperAmount}" maxlength="30" ignore="ignore" datatype="n"/>
           <span><div class="Validform_checktip" ></div></span>
        </td>
    </tr>
    <tr>
        <td class="col-md-1"><label class="label-center">手续费上限(元)</label></td>
        <td class="col-md-4">
            <input type="text" class="form-control" id="userId" name="feeMaxAmt" value="${pci.feeMaxAmt}" ignore="ignore" datatype="n"/>
            <span><div class="Validform_checktip" ></div></span>
        </td>
        <td class="col-md-1"><label class="label-center">手续费下限(元)</label></td>
        <td class="col-md-4">
            <input type="text" class="form-control" name="feeMinAmt" value="${pci.feeMinAmt}"
                   ignore="ignore" datatype="n"/>
            <span><div class="Validform_checktip" ></div></span>
        </td>
    </tr>
    <tr>	<!-- 修改的时候上下限 以及扣率  都是只读 -->
        <td class="col-md-1"><label class="label-center">扣率(%)</label></td>
        <td class="col-md-4">
            <input type="text" class="form-control" id="userId" name="feeRate" value="${pci.feeRate}" datatype="gt-one"  errormsg="请输入大于1的数值" />
            <span><div class="Validform_checktip" ></div></span>
        </td>
        <td class="col-md-1"><label class="label-center">费率说明</label></td>
        <td class="col-md-4">
            <input type="text" class="form-control" name="discDesc" value="${pci.discDesc}"
                  ignore="ignore"/>
             <span><div class="Validform_checktip" ></div></span>
        </td>
    </tr>
</table>
</body>
</html>
