<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title></title>
<meta charset="UTF-8">
</head>
<body>
	<table class="table">
		<tr>
			<td width="10%" class="tableleft"><label>通道编号</label></td>
			<td><input type="text" name="stlmId" class="form-control"
				value="${settleInsInf.stlmId }" maxlength="40" style="width: 100%"
				required /></td>
		</tr>
		<tr>
			<td width="10%" class="tableleft"><label>通道名称</label></td>
			<td><input type="text" name="descr" class="form-control"
				value="${settleInsInf.descr }" maxlength="50" style="width: 100%"
				required /></td>
		</tr>
		<tr>
			<td width="10%" class="tableleft"><label>状态</label></td>
			<td><select name="useFlag" class="form-control select2"
				style="width: 100%;">
					<option value=""></option>
					<c:forEach items="${routeStatus.keySet()}" var="item">
						<option value="${item}"
							<c:if test="${item==settleInsInf.useFlag}"> selected </c:if>>
							${routeStatus.get(item)}</option>
					</c:forEach>
			</select></td>
		</tr>
	</table>
</body>
</html>