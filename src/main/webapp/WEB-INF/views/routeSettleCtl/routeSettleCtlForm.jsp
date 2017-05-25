<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<style type="text/css">
    li {
        list-style-type: none;
    }
</style>

<%--<input type="hidden" name="brhId" value="${brh.brhId}"/>--%>
<table class="table">
    <tr>
        <td class="col-md-1"><label class="label-center">通道编号</label></td>
        <td class="col-md-4">
            <input type="text" name="id" class="form-control" value="${routeSettleCtl.id}" style="width: 100%;"
                   maxlength="4" required/>
        </td>
        <td class="col-md-1"><label class="label-center">通道名称</label></td>
        <td class="col-md-4">
            <input type="text" name="routeName" class="form-control" value="${routeSettleCtl.routeName}"
                   style="width: 100%;" required/>
        </td>
    </tr>
    <tr>
        <td class="col-md-1"><label class="label-center">优先级</label></td>
        <td class="col-md-4">
            <input type="text" name="routeCtlId" class="form-control" value="${routeSettleCtl.routeCtlId}"
                   style="width: 100%;" maxlength="4" required/>
        </td>
        <td class="col-md-1"><label>通道状态</label></td>
        <td class="col-md-4">
            <select name="routeCtlSta" class="select2 form-control" value="${routeSettleCtl.routeCtlSta}"
                    style="width: 100%;">
                <option value=""></option>
                <c:forEach items="${routeStatus.keySet()}" var="item">
                    <option value="${item}" <c:if test="${item==routeSettleCtl.routeCtlSta}"> selected </c:if> >
                        <c:out value="${routeStatus.get(item)}"/>
                    </option>
                </c:forEach>
            </select>
        </td>
    </tr>
    <tr>
        <td class="col-md-1"><label>银行池使用标识</label></td>
        <td class="col-md-4">
            <input type="text" name="issuerUseFlag" class="form-control" value="${routeSettleCtl.issuerUseFlag}"
                   style="width: 100%;" maxlength="1" required/>
        </td>
        <td class="col-md-1"><label>指定银行池</label></td>
        <td class="col-md-4">
            <input type="text" name="issuerCd" class="form-control" value="${routeSettleCtl.issuerCd}"
                   style="width: 100%;" required/>
        </td>
    </tr>
    <tr>
        <td class="col-md-1"><label>交易金额设置</label></td>
        <td class="col-md-4">
            <input type="text" name="txnAmtUseFlag" class="form-control" value="${routeSettleCtl.txnAmtUseFlag}"
                   style="width: 100%;" maxlength="1" required/>
        </td>
        <td class="col-md-1"><label>最小金额(元)</label></td>
        <td class="col-md-4">
            <input type="text" name="minTxnAmt" class="form-control" value="${routeSettleCtl.minTxnAmt}"
                   style="width: 100%;" required/>
        </td>
    </tr>
    <tr>
        <td class="col-md-1"><label>最大金额(元)</label></td>
        <td class="col-md-4">
            <input type="text" name="maxTxnAmt" class="form-control" value="${routeSettleCtl.maxTxnAmt}" style="width: 100%;"
                   maxlength="6" required/></td>
        <td class="col-md-1"><label>使用的通道</label></td>
        <td class="col-md-4"><input type="text" name="instCode" class="form-control" value="${routeSettleCtl.instCode}"
                                    style="width: 100%;" maxlength="4" required/></td>
        <td class="col-MD-1"><label></label></td>
        <td class="col-md-4"></td>
    </tr>
    <tr>
        <td class="col-md-1"><label>商户地区码使用标志</label></td>
        <td class="col-md-4"><input type="text" name="cityCodeUseFlag" class="form-control" value="${routeSettleCtl.cityCodeUseFlag}"
                                    style="width: 100%;" maxlength="1" required/></td>
        <td class="col-MD-1"><label>商户地区码</label></td>
        <td class="col-md-4"><input type="text" name="cityCode" class="form-control" value="${routeSettleCtl.cityCode}"
                                    style="width: 100%;" required/></td>
    </tr>
    <tr>
        <td class="col-md-1"><label>商户池使用标志</label></td>
        <td class="col-md-4"><input type="text" name="mchtNoUseFlag" class="form-control" value="${routeSettleCtl.mchtNoUseFlag}"
                                    style="width: 100%;" maxlength="1" required/></td>
        <td class="col-MD-1"><label>指定商户池</label></td>
        <td class="col-md-4"><input type="text" name="mchtNo" class="form-control" value="${routeSettleCtl.mchtNo}"
                                    style="width: 100%;" required/></td>
    </tr>
    <tr>
        <td class="col-md-1"><label>账户类型使用标志</label></td>
        <td class="col-md-4"><input type="text" name="stlmTypeUseFlag" class="form-control" value="${routeSettleCtl.stlmTypeUseFlag}"
                                    style="width: 100%;" maxlength="1" required/></td>
        <td class="col-MD-1"><label>商户地区码</label></td>
        <td class="col-md-4"><input type="text" name="stlmType" class="form-control" value="${routeSettleCtl.stlmType}"
                                    style="width: 100%;" required/></td>
    </tr>
    <tr>
        <td class="col-md-1"><label>卡BIN池使用标志</label></td>
        <td class="col-md-4"><input type="text" name="cardBinUseFlag" class="form-control" value="${routeSettleCtl.cardBinUseFlag}"
                                    style="width: 100%;" maxlength="1" required/></td>
        <td class="col-MD-1"><label>指定卡BIN池</label></td>
        <td class="col-md-4"><input type="text" name="cardBin" class="form-control" value="${routeSettleCtl.cardBin}"
                                    style="width: 100%;" maxlength="10" required/></td>
    </tr>
    <tr>

    </tr>
</table>